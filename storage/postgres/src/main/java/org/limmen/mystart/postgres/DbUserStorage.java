package org.limmen.mystart.postgres;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.limmen.mystart.User;
import org.limmen.mystart.UserStorage;

@Slf4j
public class DbUserStorage extends DbAbstractStorage implements UserStorage {

  private static final Function<Result, User> USER_MAPPER = res -> {
    User u = new User();
    u.setId(res.lng("id"));
    u.setFullName(res.string("full_name"));
    u.setEmail(res.string("email"));
    u.setAvatarFileName(res.string("avatar_filename"));
    u.setOpenInNewTab(res.bool("open_in_new_tab"));
    u.setPassword(res.string("password"));
    u.setResetCode(res.string("reset_code"));
    u.setResetCodeValid(res.localDateTime("reset_code_valid"));
    u.setAutoStartLabel(res.string("auto_start_label"));
    if (res.stringArray("menu_labels") != null) {
      u.setMenuLabels(Arrays.asList(res.stringArray("menu_labels")));
    }
    return u;
  };

  public DbUserStorage(String user, String password, String url) {
    super(user, password, url);
  }

  @Override
  public User get(Long id) {
    return executeSqlSingle("select * from users where id = ?", stmt -> {
      stmt.setLong(1, id);
    }, USER_MAPPER);
  }

  @Override
  public Collection<User> getAll() {
    return null;
  }

  @Override
  public User getByEmail(String email) {
    return executeSqlSingle("select * from users where email = ?", stmt -> {
      stmt.setString(1, email);
    }, USER_MAPPER);
  }

  @Override
  public User getByResetCode(String resetCode) {
    return executeSqlSingle("select * from users where reset_code = ?", stmt -> {
      stmt.setString(1, resetCode);
    }, USER_MAPPER);
  }

  @Override
  public void remove(Long id) {
    executeSql("delete from users where id = ?", stmt -> {
      stmt.setLong(1, id);
    });
  }

  @Override
  public void store(User item) {
    if (item.getId() == null) {
      executeSql("insert into users (email, password, full_name, avatar_filename, open_in_new_tab, auto_start_label, menu_labels) values (?, ?, ?, ?, ?, ?, ?)", stmt -> {
        stmt.setString(1, item.getEmail());
        stmt.setString(2, item.getPassword());
        stmt.setString(3, item.getFullName());
        stmt.setString(4, item.getAvatarFileName());
        stmt.setBool(5, item.isOpenInNewTab());
        stmt.setString(6, item.getAutoStartLabel());
        stmt.setStringArray(7, item.getMenuLabels().toArray(new String[item.getMenuLabels().size()]));
      });

    } else {
      executeSql("update users set email = ?, password = ?, full_name = ?, avatar_filename = ?, open_in_new_tab = ?, reset_code = ?, reset_code_valid = ?, auto_start_label = ?, menu_labels = ? where id = ?", stmt -> {
        stmt.setString(1, item.getEmail());
        stmt.setString(2, item.getPassword());
        stmt.setString(3, item.getFullName());
        stmt.setString(4, item.getAvatarFileName());
        stmt.setBool(5, item.isOpenInNewTab());
        stmt.setString(6, item.getResetCode());
        stmt.setLocalDate(7, item.getResetCodeValid());
        stmt.setString(8, item.getAutoStartLabel());
        stmt.setStringArray(9, item.getMenuLabels().toArray(new String[item.getMenuLabels().size()]));
        stmt.setLong(10, item.getId());
      });
    }
  }
}
