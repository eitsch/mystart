package org.limmen.mystart.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.injector.Injector;
import com.speedment.runtime.application.AbstractApplicationBuilder;
import org.limmen.mystart.MyStartApplication;
import org.limmen.mystart.MyStartApplicationBuilder;
import org.limmen.mystart.MyStartApplicationImpl;
import org.limmen.mystart.mystart.public_.ms_link.MsLinkManagerImpl;
import org.limmen.mystart.mystart.public_.ms_link.MsLinkSqlAdapter;
import org.limmen.mystart.mystart.public_.ms_user.MsUserManagerImpl;
import org.limmen.mystart.mystart.public_.ms_user.MsUserSqlAdapter;

/**
 * A generated base {@link
 * com.speedment.runtime.application.AbstractApplicationBuilder} class for the {@link com.speedment.runtime.config.Project} named mystart.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to it will be overwritten.
 *
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedMyStartApplicationBuilder extends AbstractApplicationBuilder<MyStartApplication, MyStartApplicationBuilder> {

  protected GeneratedMyStartApplicationBuilder() {
    super(MyStartApplicationImpl.class, GeneratedMyStartMetadata.class);
    withManager(MsLinkManagerImpl.class);
    withManager(MsUserManagerImpl.class);
    withComponent(MsLinkSqlAdapter.class);
    withComponent(MsUserSqlAdapter.class);
  }

  @Override
  public MyStartApplication build(Injector injector) {
    return injector.getOrThrow(MyStartApplication.class);
  }
}
