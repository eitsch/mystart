package org.limmen.mystart;

import com.typesafe.config.Config;
import org.limmen.mystart.mystart.public_.ms_link.MsLinkManager;
import org.limmen.mystart.mystart.public_.ms_user.MsUserManager;

public class DbStorage implements Storage {

    private MystartApplication app;
    private MsLinkManager links;
    private MsUserManager users;

    public DbStorage() {
    }

    @Override
    public String getName() {
        return "speedment";
    }

    @Override
    public LinkStorage getLinkStorage() {		 
        return new DbLinkStorage(links);
    }

    @Override
    public UserStorage getUserStorage() {
		 if (users == null) {
			 throw new IllegalStateException();
		 }
        return new DbUserStorage(users);
    }

    @Override
    public void initialize(Config conf) {
        this.app = new MystartApplicationBuilder()
            .withConnectionUrl(conf.getString("server.db.jdbcUrl"))
            .withUsername(conf.getString("server.db.username"))
            .withPassword(conf.getString("server.db.password"))
            .build();

        links = app.getOrThrow(MsLinkManager.class);
        users = app.getOrThrow(MsUserManager.class);
    }
}