package org.limmen.mystart.mystart.public_.ms_visits.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.core.util.OptionalUtil;
import com.speedment.runtime.field.ComparableField;
import com.speedment.runtime.field.ComparableForeignKeyField;
import com.speedment.runtime.field.LongField;
import com.speedment.runtime.typemapper.TypeMapper;
import org.limmen.mystart.mystart.public_.ms_link.MsLink;
import org.limmen.mystart.mystart.public_.ms_visits.MsVisits;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.OptionalLong;

/**
 * The generated base for the {@link
 * org.limmen.mystart.mystart.public_.ms_visits.MsVisits}-interface representing
 * entities of the {@code ms_visits}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedMsVisits {
    
    /**
     * This Field corresponds to the {@link MsVisits} field that can be obtained
     * using the {@link MsVisits#getId()} method.
     */
    LongField<MsVisits, Long> ID = LongField.create(
        Identifier.ID,
        MsVisits::getId,
        MsVisits::setId,
        TypeMapper.primitive(),
        true
    );
    /**
     * This Field corresponds to the {@link MsVisits} field that can be obtained
     * using the {@link MsVisits#getLinkId()} method.
     */
    ComparableForeignKeyField<MsVisits, Long, Long, MsLink> LINK_ID = ComparableForeignKeyField.create(
        Identifier.LINK_ID,
        o -> OptionalUtil.unwrap(o.getLinkId()),
        MsVisits::setLinkId,
        MsLink.ID,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link MsVisits} field that can be obtained
     * using the {@link MsVisits#getVisit()} method.
     */
    ComparableField<MsVisits, Timestamp, Timestamp> VISIT = ComparableField.create(
        Identifier.VISIT,
        o -> OptionalUtil.unwrap(o.getVisit()),
        MsVisits::setVisit,
        TypeMapper.identity(),
        false
    );
    
    /**
     * Returns the id of this MsVisits. The id field corresponds to the database
     * column mystart.public.ms_visits.id.
     * 
     * @return the id of this MsVisits
     */
    long getId();
    
    /**
     * Returns the linkId of this MsVisits. The linkId field corresponds to the
     * database column mystart.public.ms_visits.link_id.
     * 
     * @return the linkId of this MsVisits
     */
    OptionalLong getLinkId();
    
    /**
     * Returns the visit of this MsVisits. The visit field corresponds to the
     * database column mystart.public.ms_visits.visit.
     * 
     * @return the visit of this MsVisits
     */
    Optional<Timestamp> getVisit();
    
    /**
     * Sets the id of this MsVisits. The id field corresponds to the database
     * column mystart.public.ms_visits.id.
     * 
     * @param id to set of this MsVisits
     * @return   this MsVisits instance
     */
    MsVisits setId(long id);
    
    /**
     * Sets the linkId of this MsVisits. The linkId field corresponds to the
     * database column mystart.public.ms_visits.link_id.
     * 
     * @param linkId to set of this MsVisits
     * @return       this MsVisits instance
     */
    MsVisits setLinkId(Long linkId);
    
    /**
     * Sets the visit of this MsVisits. The visit field corresponds to the
     * database column mystart.public.ms_visits.visit.
     * 
     * @param visit to set of this MsVisits
     * @return      this MsVisits instance
     */
    MsVisits setVisit(Timestamp visit);
    
    /**
     * Queries the specified manager for the referenced MsLink. If no such
     * MsLink exists, an {@code NullPointerException} will be thrown.
     * 
     * @param foreignManager the manager to query for the entity
     * @return               the foreign entity referenced
     */
    Optional<MsLink> findLinkId(Manager<MsLink> foreignManager);
    
    enum Identifier implements ColumnIdentifier<MsVisits> {
        
        ID      ("id"),
        LINK_ID ("link_id"),
        VISIT   ("visit");
        
        private final String columnId;
        private final TableIdentifier<MsVisits> tableIdentifier;
        
        Identifier(String columnId) {
            this.columnId        = columnId;
            this.tableIdentifier = TableIdentifier.of(    getDbmsId(), 
                getSchemaId(), 
                getTableId());
        }
        
        @Override
        public String getDbmsId() {
            return "mystart";
        }
        
        @Override
        public String getSchemaId() {
            return "public";
        }
        
        @Override
        public String getTableId() {
            return "ms_visits";
        }
        
        @Override
        public String getColumnId() {
            return this.columnId;
        }
        
        @Override
        public TableIdentifier<MsVisits> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}