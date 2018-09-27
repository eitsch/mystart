package org.limmen.mystart.mystart.public_.ms_user.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.field.Field;
import org.limmen.mystart.mystart.public_.ms_user.MsUser;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * The generated base interface for the manager of every {@link
 * org.limmen.mystart.mystart.public_.ms_user.MsUser} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedMsUserManager extends Manager<MsUser> {
    
    TableIdentifier<MsUser> IDENTIFIER = TableIdentifier.of("mystart", "public", "ms_user");
    List<Field<MsUser>> FIELDS = unmodifiableList(asList(
        MsUser.ID,
        MsUser.EMAIL,
        MsUser.PASSWORD
    ));
    
    @Override
    default Class<MsUser> getEntityClass() {
        return MsUser.class;
    }
}