package org.limmen.mystart.postgres;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.limmen.mystart.Link;
import org.limmen.mystart.LinkStorage;
import org.limmen.mystart.criteria.AbstractCriteria;

@Slf4j
public class DbLinkStorage extends DbAbstractStorage implements LinkStorage {

  private static final Function<Result, Link> LINK_MAPPER = (var res) -> {
    var link = new Link();
    link.setId(res.lng("id"));
    link.setUrl(res.string("url"));
    link.setTitle(res.string("title"));
    link.setDescription(res.string("description"));
    link.setSource(res.string("source"));
    link.setCheckResult(res.string("check_result"));
    link.setCreationDate(res.localDateTime("creation_date"));
    link.setLastVisit(res.localDateTime("last_visit"));
    link.setLastCheck(res.localDateTime("last_check"));
    link.setLabels(Arrays.asList(res.stringArray("labels")));
    link.setPrivateNetwork(res.bool("private_network"));
    return link;
  };

  public DbLinkStorage(String user, String password, String url) {
    super(user, password, url);
  }

  @Override
  public void create(Long userId, Link link) {
    String sql = "insert into links (user_id, description, source, title, url, labels, creation_date) "
        + "values (?, ?, ?, ?, ?, ?, ?)";
    executeSql(sql, stmt -> {
             stmt.setLong(1, userId);
             stmt.setString(2, link.getDescription());
             stmt.setString(3, link.getSource());
             stmt.setString(4, link.getTitle());
             stmt.setString(5, link.getUrl());
             stmt.setStringArray(6, link.getLabels().toArray(new String[link.getLabels().size()]));
             stmt.setLocalDate(7, link.getCreationDate());
           });
  }

  @Override
  public Link get(Long userId, Long id) {
    return executeSqlSingle("select * from links where user_id = ? and id = ?", args -> {
                          args.setLong(1, userId);
                          args.setLong(2, id);
                        }, LINK_MAPPER);
  }

  @Override
  public Collection<Link> getAll(Long userId) {
    return executeSql("select * from links where user_id = ? order by title asc", args -> {
                    args.setLong(1, userId);
                  }, LINK_MAPPER);
  }

  @Override
  public Collection<Link> getAllByLabel(Long userId, String label) {
    return executeSql("select * from links where user_id = ? and labels && array[?] order by title asc", args -> {
                    args.setLong(1, userId);
                    args.setStringArray(2, new String[]{label});
                  }, LINK_MAPPER);
  }

  @Override
  public Collection<String> getAllLabels(Long userId) {
    return executeSqlStringCollection("select distinct unnest(labels) from links where user_id = ? order by 1", args -> {
                                    args.setLong(1, userId);
                                  });
  }

  @Override
  public Link getByUrl(Long userId, String url) {

    if (url.startsWith("https://")) {
      url = url.substring(8);
    } else if (url.startsWith("http://")) {
      url = url.substring(7);
    }
    String strippedUrl = url.replaceAll("/", "");
    log.debug("Searching for url: {}", strippedUrl);

    String sql = "select t.* from (select l.id, "
        + "case "
        + "  when strpos(l.url, 'https://') = 1 "
        + "  then translate(substr(l.url, 9), '/', '') "
        + "  when strpos(l.url, 'http://') = 1 "
        + "  then translate(substr(l.url, 8), '/', '') "
        + "  else l.url "
        + "  end, "
        + "  l.title, "
        + "  l.creation_date, "
        + "  l.source, "
        + "  l.labels, "
        + "  l.description, "
        + "  l.private_network, "
        + "  l.last_check, "
        + "  l.check_result, "
        + "  l.last_visit, "
        + "  l.user_id "
        + "from links l) t "
        + "where t.user_id = ? and t.url = ?";
    return executeSqlSingle(sql, args -> {
                          args.setLong(1, userId);
                          args.setString(2, strippedUrl);
                        }, LINK_MAPPER);
  }

  @Override
  public void importCollection(Long userId, Collection<Link> links, boolean skipDuplicates) {
    links.forEach(l -> {
      Link link = getByUrl(userId, l.getUrl());
      if (link == null) {
        log.info("Creating link {}", l.getUrl());
        create(userId, l);
      } else {
        if (!skipDuplicates) {
          log.info("Updating link {}", l.getUrl());
          link.addLabels(l.getLabels());
          update(userId, link);
        } else {
          log.info("Scipping link {}", l.getUrl());
        }
      }
    });
  }

  @Override
  public Collection<Link> last20Visits(Long userId) {
    String sql = "select l.* "
        + "from links l "
        + "join visits v ON v.link_id = l.id "
        + "where l.user_id = ? "
        + "order by v.visit desc limit 20";

    return executeSql(sql, args -> {
                    args.setLong(1, userId);
                  }, LINK_MAPPER);
  }

  @Override
  public void remove(Long userId, Long id) {
    executeSql("delete from links where id = ? and user_id = ?", stmt -> {
             stmt.setLong(1, id);
             stmt.setLong(2, userId);
           });
  }

  @Override
  public Collection<Link> search(Long userId, Collection<AbstractCriteria> criteria) {
    StringBuilder sql = new StringBuilder();
    sql.append("select l.* from links l where l.user_id = ? ");

    criteria.forEach(c -> {
      sql.append(" and ").append(c.toSQL());
    });
    sql.append(" order by l.title asc");

    AtomicInteger index = new AtomicInteger(0);
    return executeSql(sql.toString(), args -> {
                    args.setLong(index.incrementAndGet(), userId);
                    criteria.forEach(c -> {
                      if (c.getValueType().equals(String.class)) {
                        args.setString(index.incrementAndGet(), "%" + c.getValue() + "%");
                      }
                      if (c.getValueType().equals(String[].class)) {
                        args.setString(index.incrementAndGet(), (String) c.getValue());
                      }
                    });
                  }, LINK_MAPPER);
  }

  @Override
  public void update(Long userId, Link link) {
    String sql = "update links "
        + "set description = ?,"
        + "title = ?,"
        + "source = ?,"
        + "url = ?,"
        + "labels = ?,"
        + "private_network = ?,"
        + "check_result = ?,"
        + "last_check = ?,"
        + "last_visit = ?"
        + "where id = ?"
        + "and user_id = ?";
    executeSql(sql, stmt -> {
             stmt.setString(1, link.getDescription());
             stmt.setString(2, link.getTitle());
             stmt.setString(3, link.getSource());
             stmt.setString(4, link.getUrl());
             stmt.setStringArray(5, link.getLabels().toArray(new String[link.getLabels().size()]));
             stmt.setBool(6, link.isPrivateNetwork());
             stmt.setString(7, link.getCheckResult());
             stmt.setLocalDate(8, link.getLastCheck());
             stmt.setLocalDate(9, link.getLastVisit());

             stmt.setLong(10, link.getId());
             stmt.setLong(11, userId);
           });
  }
}
