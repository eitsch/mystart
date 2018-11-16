package org.limmen.mystart.server.servlet;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.limmen.mystart.LinkStorage;
import org.limmen.mystart.Storage;
import org.limmen.mystart.User;
import org.limmen.mystart.UserStorage;
import org.limmen.mystart.VisitStorage;

public class AbstractServlet extends HttpServlet {

  public static final String USER = "user";
  public static final String USER_ID = "userId";

  private static final long serialVersionUID = 1L;

  private static final Map<String, String> flair = new HashMap<>();
  private final MultipartConfigElement multipartConfigElement;
  private final Storage storage;
  private final Path temporaryDirectory;

  static {
    // common domains
    flair.put("github.com", "fa-github");
    flair.put("gitlab.com", "fa-gitlab");
    flair.put("bitbucket.org", "fa-bitbucket");
    flair.put("stackoverflow.com", "fa-stack-overflow");

    flair.put("bandcamp.com", "fa-bandcamp");
    flair.put("last.fm", "fa-lastfm");
    flair.put("soundcloud.com", "fa-soundcloud");
    flair.put("youtube.com", "fa-youtube");
    flair.put("reddit.com", "fa-reddit");
    flair.put("yelp.com", "fa-yelp");
    flair.put("slack.com", "fa-slack");
    flair.put("amazon.com", "fa-amazon");
    flair.put("google.com", "fa-google");
    flair.put("medium.com", "fa-medium");
    flair.put("news.ycombinator.com", "fa-hacker-news");
  }

  public AbstractServlet(Storage storage,
                         MultipartConfigElement multipartConfigElement,
                         Path temporaryDirectory) {
    this.storage = storage;
    this.multipartConfigElement = multipartConfigElement;
    this.temporaryDirectory = temporaryDirectory;
  }

  public LinkStorage getLinkStorage() {
    return this.storage.getLinkStorage();
  }

  public Storage getStorage() {
    return storage;
  }

  public Path getTemporaryDirectory() {
    return temporaryDirectory;
  }

  public UserStorage getUserStorage() {
    return this.storage.getUserStorage();
  }

  public VisitStorage getVisitStorage() {
    return this.storage.getVisitStorage();
  }

  protected void clearCookies(HttpServletRequest req, HttpServletResponse res) {
    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().startsWith("mystart")) {
          cookie.setValue("");
          cookie.setPath("/");
          cookie.setMaxAge(0);
          res.addCookie(cookie);
        }
      }
    }
    req.getSession().invalidate();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    if (req.getSession().getAttribute(USER_ID) == null) {
      // check cookies
      Cookie[] cookies = req.getCookies();
      if (cookies != null) {
        String email = null;
        String password = null;
        for (Cookie cookie : cookies) {
          switch (cookie.getName()) {
            case "mystartUser":
              email = cookie.getValue();
              break;
            case "mystartUserPassword":
              password = cookie.getValue();
              break;
            default:
              break;
          }
        }
        // check cookie data
        if (password != null & email != null) {
          User user = getUserStorage().getByEmail(email);
          if (user != null && user.getPassword().equals(password)) {
            req.getSession().setAttribute(USER_ID, user.getId());
          } else {
            clearCookies(req, res);
          }
        }
      }

      if (req.getSession().getAttribute(USER_ID) == null) {
        req.getRequestDispatcher("/login.jsp").include(req, res);
      }
    }

    if (req.getSession().getAttribute(USER_ID) != null) {
      Long userId = (Long) req.getSession().getAttribute(USER_ID);
      User user = getUserStorage().get(userId);
      req.setAttribute(USER_ID, userId);
      req.setAttribute(USER, user);
      req.setAttribute("links", getLinkStorage().getAllByLabel(userId, "MyStart"));
      req.setAttribute("flair", flair);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    if (req.getSession().getAttribute(USER_ID) == null) {
      res.sendRedirect("/home");
      return;
    }
    if (req.getContentType() != null && req.getContentType().startsWith("multipart/form-data")) {
      req.setAttribute(Request.__MULTIPART_CONFIG_ELEMENT, multipartConfigElement);
    }
  }

  protected boolean exists(HttpServletRequest req, String parameter) {
    return req.getParameter(parameter) != null;
  }

  protected boolean getBool(HttpServletRequest req, String parameter) {
    return req.getParameter(parameter) != null;
  }

  protected int getInt(HttpServletRequest req, String parameter) {
    return Integer.parseInt(req.getParameter(parameter));
  }

  protected long getLong(HttpServletRequest req, String parameter) {
    return Long.parseLong(req.getParameter(parameter));
  }

  protected String getOrignalParameters(HttpServletRequest req) {
    String referer = req.getHeader("Referer");

    if (referer != null && referer.contains("?")) {
      int index = referer.indexOf("?");
      return referer.substring(1 + index);
    }

    return referer;
  }

  protected boolean hasValue(HttpServletRequest req, String parameter) {
    return req.getParameter(parameter) != null && req.getParameter(parameter).length() > 0;
  }

  protected boolean hasValue(HttpServletRequest req, String parameter, String value) {
    return value.equals(req.getParameter(parameter));
  }
}
