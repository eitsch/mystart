package org.limmen.mystart.mystart.public_.ms_link.generated;

import com.speedment.common.function.OptionalBoolean;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.core.util.OptionalUtil;
import com.speedment.runtime.field.ComparableField;
import com.speedment.runtime.field.ComparableForeignKeyField;
import com.speedment.runtime.field.IntField;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.OptionalInt;
import javax.annotation.Generated;
import org.limmen.mystart.mystart.public_.ms_link.MsLink;
import org.limmen.mystart.mystart.public_.ms_user.MsUser;

/**
 * The generated base for the {@link
 * org.limmen.mystart.mystart.public_.ms_link.MsLink}-interface representing
 * entities of the {@code ms_link}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public interface GeneratedMsLink {
    
    /**
     * This Field corresponds to the {@link MsLink} field that can be obtained
     * using the {@link MsLink#getId()} method.
     */
    final IntField<MsLink, Integer> ID = IntField.create(
        Identifier.ID,
        MsLink::getId,
        MsLink::setId,
        TypeMapper.primitive(), 
        true
    );
    /**
     * This Field corresponds to the {@link MsLink} field that can be obtained
     * using the {@link MsLink#getUserId()} method.
     */
    final ComparableForeignKeyField<MsLink, Integer, Integer, MsUser> USER_ID = ComparableForeignKeyField.create(
        Identifier.USER_ID,
        o -> OptionalUtil.unwrap(o.getUserId()),
        MsLink::setUserId,
        MsUser.ID,
        TypeMapper.identity(), 
        false
    );
    /**
     * This Field corresponds to the {@link MsLink} field that can be obtained
     * using the {@link MsLink#getDescription()} method.
     */
    final StringField<MsLink, String> DESCRIPTION = StringField.create(
        Identifier.DESCRIPTION,
        o -> OptionalUtil.unwrap(o.getDescription()),
        MsLink::setDescription,
        TypeMapper.identity(), 
        false
    );
    /**
     * This Field corresponds to the {@link MsLink} field that can be obtained
     * using the {@link MsLink#getSource()} method.
     */
    final StringField<MsLink, String> SOURCE = StringField.create(
        Identifier.SOURCE,
        o -> OptionalUtil.unwrap(o.getSource()),
        MsLink::setSource,
        TypeMapper.identity(), 
        false
    );
    /**
     * This Field corresponds to the {@link MsLink} field that can be obtained
     * using the {@link MsLink#getTitle()} method.
     */
    final StringField<MsLink, String> TITLE = StringField.create(
        Identifier.TITLE,
        o -> OptionalUtil.unwrap(o.getTitle()),
        MsLink::setTitle,
        TypeMapper.identity(), 
        false
    );
    /**
     * This Field corresponds to the {@link MsLink} field that can be obtained
     * using the {@link MsLink#getUrl()} method.
     */
    final StringField<MsLink, String> URL = StringField.create(
        Identifier.URL,
        o -> OptionalUtil.unwrap(o.getUrl()),
        MsLink::setUrl,
        TypeMapper.identity(), 
        false
    );
    /**
     * This Field corresponds to the {@link MsLink} field that can be obtained
     * using the {@link MsLink#getHost()} method.
     */
    final StringField<MsLink, String> HOST = StringField.create(
        Identifier.HOST,
        o -> OptionalUtil.unwrap(o.getHost()),
        MsLink::setHost,
        TypeMapper.identity(), 
        false
    );
    /**
     * This Field corresponds to the {@link MsLink} field that can be obtained
     * using the {@link MsLink#getLabels()} method.
     */
    final StringField<MsLink, String> LABELS = StringField.create(
        Identifier.LABELS,
        o -> OptionalUtil.unwrap(o.getLabels()),
        MsLink::setLabels,
        TypeMapper.identity(), 
        false
    );
    /**
     * This Field corresponds to the {@link MsLink} field that can be obtained
     * using the {@link MsLink#getPrivateNetwork()} method.
     */
    final ComparableField<MsLink, Boolean, Boolean> PRIVATE_NETWORK = ComparableField.create(
        Identifier.PRIVATE_NETWORK,
        o -> OptionalUtil.unwrap(o.getPrivateNetwork()),
        MsLink::setPrivateNetwork,
        TypeMapper.identity(), 
        false
    );
    /**
     * This Field corresponds to the {@link MsLink} field that can be obtained
     * using the {@link MsLink#getLastVisit()} method.
     */
    final ComparableField<MsLink, Timestamp, Timestamp> LAST_VISIT = ComparableField.create(
        Identifier.LAST_VISIT,
        o -> OptionalUtil.unwrap(o.getLastVisit()),
        MsLink::setLastVisit,
        TypeMapper.identity(), 
        false
    );
    /**
     * This Field corresponds to the {@link MsLink} field that can be obtained
     * using the {@link MsLink#getCreationDate()} method.
     */
    final ComparableField<MsLink, Timestamp, Timestamp> CREATION_DATE = ComparableField.create(
        Identifier.CREATION_DATE,
        o -> OptionalUtil.unwrap(o.getCreationDate()),
        MsLink::setCreationDate,
        TypeMapper.identity(), 
        false
    );
    
    /**
     * Returns the id of this MsLink. The id field corresponds to the database
     * column mystart.public.ms_link.id.
     * 
     * @return the id of this MsLink
     */
    int getId();
    
    /**
     * Returns the userId of this MsLink. The userId field corresponds to the
     * database column mystart.public.ms_link.user_id.
     * 
     * @return the userId of this MsLink
     */
    OptionalInt getUserId();
    
    /**
     * Returns the description of this MsLink. The description field corresponds
     * to the database column mystart.public.ms_link.description.
     * 
     * @return the description of this MsLink
     */
    Optional<String> getDescription();
    
    /**
     * Returns the source of this MsLink. The source field corresponds to the
     * database column mystart.public.ms_link.source.
     * 
     * @return the source of this MsLink
     */
    Optional<String> getSource();
    
    /**
     * Returns the title of this MsLink. The title field corresponds to the
     * database column mystart.public.ms_link.title.
     * 
     * @return the title of this MsLink
     */
    Optional<String> getTitle();
    
    /**
     * Returns the url of this MsLink. The url field corresponds to the database
     * column mystart.public.ms_link.url.
     * 
     * @return the url of this MsLink
     */
    Optional<String> getUrl();
    
    /**
     * Returns the host of this MsLink. The host field corresponds to the
     * database column mystart.public.ms_link.host.
     * 
     * @return the host of this MsLink
     */
    Optional<String> getHost();
    
    /**
     * Returns the labels of this MsLink. The labels field corresponds to the
     * database column mystart.public.ms_link.labels.
     * 
     * @return the labels of this MsLink
     */
    Optional<String> getLabels();
    
    /**
     * Returns the privateNetwork of this MsLink. The privateNetwork field
     * corresponds to the database column
     * mystart.public.ms_link.private_network.
     * 
     * @return the privateNetwork of this MsLink
     */
    OptionalBoolean getPrivateNetwork();
    
    /**
     * Returns the lastVisit of this MsLink. The lastVisit field corresponds to
     * the database column mystart.public.ms_link.last_visit.
     * 
     * @return the lastVisit of this MsLink
     */
    Optional<Timestamp> getLastVisit();
    
    /**
     * Returns the creationDate of this MsLink. The creationDate field
     * corresponds to the database column mystart.public.ms_link.creation_date.
     * 
     * @return the creationDate of this MsLink
     */
    Optional<Timestamp> getCreationDate();
    
    /**
     * Sets the id of this MsLink. The id field corresponds to the database
     * column mystart.public.ms_link.id.
     * 
     * @param id to set of this MsLink
     * @return   this MsLink instance
     */
    MsLink setId(int id);
    
    /**
     * Sets the userId of this MsLink. The userId field corresponds to the
     * database column mystart.public.ms_link.user_id.
     * 
     * @param userId to set of this MsLink
     * @return       this MsLink instance
     */
    MsLink setUserId(Integer userId);
    
    /**
     * Sets the description of this MsLink. The description field corresponds to
     * the database column mystart.public.ms_link.description.
     * 
     * @param description to set of this MsLink
     * @return            this MsLink instance
     */
    MsLink setDescription(String description);
    
    /**
     * Sets the source of this MsLink. The source field corresponds to the
     * database column mystart.public.ms_link.source.
     * 
     * @param source to set of this MsLink
     * @return       this MsLink instance
     */
    MsLink setSource(String source);
    
    /**
     * Sets the title of this MsLink. The title field corresponds to the
     * database column mystart.public.ms_link.title.
     * 
     * @param title to set of this MsLink
     * @return      this MsLink instance
     */
    MsLink setTitle(String title);
    
    /**
     * Sets the url of this MsLink. The url field corresponds to the database
     * column mystart.public.ms_link.url.
     * 
     * @param url to set of this MsLink
     * @return    this MsLink instance
     */
    MsLink setUrl(String url);
    
    /**
     * Sets the host of this MsLink. The host field corresponds to the database
     * column mystart.public.ms_link.host.
     * 
     * @param host to set of this MsLink
     * @return     this MsLink instance
     */
    MsLink setHost(String host);
    
    /**
     * Sets the labels of this MsLink. The labels field corresponds to the
     * database column mystart.public.ms_link.labels.
     * 
     * @param labels to set of this MsLink
     * @return       this MsLink instance
     */
    MsLink setLabels(String labels);
    
    /**
     * Sets the privateNetwork of this MsLink. The privateNetwork field
     * corresponds to the database column
     * mystart.public.ms_link.private_network.
     * 
     * @param privateNetwork to set of this MsLink
     * @return               this MsLink instance
     */
    MsLink setPrivateNetwork(Boolean privateNetwork);
    
    /**
     * Sets the lastVisit of this MsLink. The lastVisit field corresponds to the
     * database column mystart.public.ms_link.last_visit.
     * 
     * @param lastVisit to set of this MsLink
     * @return          this MsLink instance
     */
    MsLink setLastVisit(Timestamp lastVisit);
    
    /**
     * Sets the creationDate of this MsLink. The creationDate field corresponds
     * to the database column mystart.public.ms_link.creation_date.
     * 
     * @param creationDate to set of this MsLink
     * @return             this MsLink instance
     */
    MsLink setCreationDate(Timestamp creationDate);
    
    /**
     * Queries the specified manager for the referenced MsUser. If no such
     * MsUser exists, an {@code NullPointerException} will be thrown.
     * 
     * @param foreignManager the manager to query for the entity
     * @return               the foreign entity referenced
     */
    Optional<MsUser> findUserId(Manager<MsUser> foreignManager);
    
    enum Identifier implements ColumnIdentifier<MsLink> {
        
        ID              ("id"),
        USER_ID         ("user_id"),
        DESCRIPTION     ("description"),
        SOURCE          ("source"),
        TITLE           ("title"),
        URL             ("url"),
        HOST            ("host"),
        LABELS          ("labels"),
        PRIVATE_NETWORK ("private_network"),
        LAST_VISIT      ("last_visit"),
        CREATION_DATE   ("creation_date");
        
        private final String columnName;
        private final TableIdentifier<MsLink> tableIdentifier;
        
        Identifier(String columnName) {
            this.columnName      = columnName;
            this.tableIdentifier = TableIdentifier.of(    getDbmsName(), 
                getSchemaName(), 
                getTableName());
        }
        
        @Override
        public String getDbmsName() {
            return "mystart";
        }
        
        @Override
        public String getSchemaName() {
            return "public";
        }
        
        @Override
        public String getTableName() {
            return "ms_link";
        }
        
        @Override
        public String getColumnName() {
            return this.columnName;
        }
        
        @Override
        public TableIdentifier<MsLink> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}