package org.limmen.mystart.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.application.AbstractApplicationMetadata;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * A {@link com.speedment.runtime.core.ApplicationMetadata} class for the {@link
 * com.speedment.runtime.config.Project} named mystart. This class contains the
 * meta data present at code generation time.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public class GeneratedMystartMetadata extends AbstractApplicationMetadata {
    
    private final static String METADATA = init();
    
    private static String init() {
        final StringBuilder sb = new StringBuilder();
        initPart0(sb);
        initPart1(sb);
        initPart2(sb);
        return sb.toString();
    }
    
    @Override
    protected Optional<String> getMetadata() {
        return Optional.of(METADATA);
    }
    
    private static void initPart0(StringBuilder sb) {
        Stream.of(
            "{",
            "  \"config\" : {",
            "    \"appId\" : \"8daf6252-00a1-40b8-82dc-7341c7b35e97\",",
            "    \"companyName\" : \"limmen\",",
            "    \"dbmses\" : [",
            "      {",
            "        \"enabled\" : true,",
            "        \"expanded\" : true,",
            "        \"id\" : \"mystart\",",
            "        \"ipAddress\" : \"127.0.0.1\",",
            "        \"name\" : \"mystart\",",
            "        \"nameProtected\" : true,",
            "        \"port\" : 5432,",
            "        \"schemas\" : [",
            "          {",
            "            \"enabled\" : true,",
            "            \"expanded\" : true,",
            "            \"id\" : \"public\",",
            "            \"name\" : \"public\",",
            "            \"nameProtected\" : true,",
            "            \"tables\" : [",
            "              {",
            "                \"columns\" : [",
            "                  {",
            "                    \"autoIncrement\" : true,",
            "                    \"databaseType\" : \"java.lang.Integer\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : false,",
            "                    \"id\" : \"id\",",
            "                    \"name\" : \"id\",",
            "                    \"nullable\" : false,",
            "                    \"ordinalPosition\" : 1,",
            "                    \"typeMapper\" : \"com.speedment.runtime.typemapper.primitive.PrimitiveTypeMapper\"",
            "                  },",
            "                  {",
            "                    \"databaseType\" : \"java.lang.Integer\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : false,",
            "                    \"id\" : \"user_id\",",
            "                    \"name\" : \"user_id\",",
            "                    \"nullable\" : true,",
            "                    \"ordinalPosition\" : 2",
            "                  },",
            "                  {",
            "                    \"databaseType\" : \"java.lang.String\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : false,",
            "                    \"id\" : \"description\",",
            "                    \"name\" : \"description\",",
            "                    \"nullable\" : true,",
            "                    \"ordinalPosition\" : 3",
            "                  },",
            "                  {",
            "                    \"databaseType\" : \"java.lang.String\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : true,",
            "                    \"id\" : \"source\",",
            "                    \"name\" : \"source\",",
            "                    \"nullable\" : true,",
            "                    \"ordinalPosition\" : 4",
            "                  },",
            "                  {",
            "                    \"databaseType\" : \"java.lang.String\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : false,",
            "                    \"id\" : \"title\",",
            "                    \"name\" : \"title\",",
            "                    \"nullable\" : true,",
            "                    \"ordinalPosition\" : 5",
            "                  },",
            "                  {",
            "                    \"autoIncrement\" : false,",
            "                    \"databaseType\" : \"java.lang.String\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : false,",
            "                    \"id\" : \"url\",",
            "                    \"name\" : \"url\",",
            "                    \"nameProtected\" : true,",
            "                    \"nullable\" : true,",
            "                    \"nullableImplementation\" : \"OPTIONAL\",",
            "                    \"ordinalPosition\" : 6",
            "                  },",
            "                  {",
            "                    \"databaseType\" : \"java.lang.String\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : false,",
            "                    \"id\" : \"host\",",
            "                    \"name\" : \"host\",",
            "                    \"nullable\" : true,",
            "                    \"ordinalPosition\" : 7",
            "                  },",
            "                  {",
            "                    \"autoIncrement\" : false,",
            "                    \"databaseType\" : \"java.lang.String\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : false,",
            "                    \"id\" : \"labels\",",
            "                    \"name\" : \"labels\",",
            "                    \"nameProtected\" : true,",
            "                    \"nullable\" : true,",
            "                    \"nullableImplementation\" : \"OPTIONAL\","
        ).forEachOrdered(sb::append);
    }
    
    private static void initPart1(StringBuilder sb) {
        Stream.of(
            "                    \"ordinalPosition\" : 8",
            "                  },",
            "                  {",
            "                    \"databaseType\" : \"java.lang.Boolean\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : false,",
            "                    \"id\" : \"private_network\",",
            "                    \"name\" : \"private_network\",",
            "                    \"nullable\" : true,",
            "                    \"ordinalPosition\" : 9",
            "                  },",
            "                  {",
            "                    \"databaseType\" : \"java.sql.Timestamp\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : true,",
            "                    \"id\" : \"last_visit\",",
            "                    \"name\" : \"last_visit\",",
            "                    \"nullable\" : true,",
            "                    \"ordinalPosition\" : 10",
            "                  },",
            "                  {",
            "                    \"databaseType\" : \"java.sql.Timestamp\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : true,",
            "                    \"id\" : \"creation_date\",",
            "                    \"name\" : \"creation_date\",",
            "                    \"nullable\" : true,",
            "                    \"ordinalPosition\" : 11",
            "                  }",
            "                ],",
            "                \"enabled\" : true,",
            "                \"expanded\" : true,",
            "                \"foreignKeys\" : [",
            "                  {",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : false,",
            "                    \"foreignKeyColumns\" : [",
            "                      {",
            "                        \"expanded\" : false,",
            "                        \"foreignColumnName\" : \"id\",",
            "                        \"foreignDatabaseName\" : \"mystart\",",
            "                        \"foreignSchemaName\" : \"public\",",
            "                        \"foreignTableName\" : \"ms_user\",",
            "                        \"id\" : \"user_id\",",
            "                        \"name\" : \"user_id\",",
            "                        \"ordinalPosition\" : 1",
            "                      }",
            "                    ],",
            "                    \"id\" : \"ms_link_user_id_fkey\",",
            "                    \"name\" : \"ms_link_user_id_fkey\"",
            "                  }",
            "                ],",
            "                \"id\" : \"ms_link\",",
            "                \"indexes\" : [",
            "                  {",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : false,",
            "                    \"id\" : \"ms_link_pkey\",",
            "                    \"indexColumns\" : [",
            "                      {",
            "                        \"expanded\" : false,",
            "                        \"id\" : \"id\",",
            "                        \"name\" : \"id\",",
            "                        \"orderType\" : \"ASC\",",
            "                        \"ordinalPosition\" : 1",
            "                      }",
            "                    ],",
            "                    \"name\" : \"ms_link_pkey\",",
            "                    \"unique\" : true",
            "                  }",
            "                ],",
            "                \"isView\" : false,",
            "                \"name\" : \"ms_link\",",
            "                \"nameProtected\" : true,",
            "                \"primaryKeyColumns\" : [",
            "                  {",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : false,",
            "                    \"id\" : \"id\",",
            "                    \"name\" : \"id\",",
            "                    \"nameProtected\" : false,",
            "                    \"ordinalPosition\" : 1",
            "                  }",
            "                ]",
            "              },",
            "              {",
            "                \"columns\" : [",
            "                  {",
            "                    \"autoIncrement\" : true,",
            "                    \"databaseType\" : \"java.lang.Integer\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : true,",
            "                    \"id\" : \"id\",",
            "                    \"name\" : \"id\",",
            "                    \"nullable\" : false,",
            "                    \"ordinalPosition\" : 1,",
            "                    \"typeMapper\" : \"com.speedment.runtime.typemapper.primitive.PrimitiveTypeMapper\"",
            "                  },",
            "                  {",
            "                    \"databaseType\" : \"java.lang.String\",",
            "                    \"enabled\" : true,"
        ).forEachOrdered(sb::append);
    }
    
    private static void initPart2(StringBuilder sb) {
        Stream.of(
            "                    \"expanded\" : true,",
            "                    \"id\" : \"email\",",
            "                    \"name\" : \"email\",",
            "                    \"nullable\" : true,",
            "                    \"ordinalPosition\" : 2",
            "                  },",
            "                  {",
            "                    \"databaseType\" : \"java.lang.String\",",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : true,",
            "                    \"id\" : \"password\",",
            "                    \"name\" : \"password\",",
            "                    \"nullable\" : true,",
            "                    \"ordinalPosition\" : 3",
            "                  }",
            "                ],",
            "                \"enabled\" : true,",
            "                \"expanded\" : false,",
            "                \"id\" : \"ms_user\",",
            "                \"indexes\" : [",
            "                  {",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : false,",
            "                    \"id\" : \"ms_user_pkey\",",
            "                    \"indexColumns\" : [",
            "                      {",
            "                        \"expanded\" : true,",
            "                        \"id\" : \"id\",",
            "                        \"name\" : \"id\",",
            "                        \"orderType\" : \"ASC\",",
            "                        \"ordinalPosition\" : 1",
            "                      }",
            "                    ],",
            "                    \"name\" : \"ms_user_pkey\",",
            "                    \"unique\" : true",
            "                  }",
            "                ],",
            "                \"isView\" : false,",
            "                \"name\" : \"ms_user\",",
            "                \"primaryKeyColumns\" : [",
            "                  {",
            "                    \"enabled\" : true,",
            "                    \"expanded\" : true,",
            "                    \"id\" : \"id\",",
            "                    \"name\" : \"id\",",
            "                    \"ordinalPosition\" : 1",
            "                  }",
            "                ]",
            "              }",
            "            ]",
            "          }",
            "        ],",
            "        \"typeName\" : \"PostgreSQL\",",
            "        \"username\" : \"postgres\"",
            "      }",
            "    ],",
            "    \"enabled\" : true,",
            "    \"expanded\" : true,",
            "    \"id\" : \"mystart\",",
            "    \"name\" : \"mystart\",",
            "    \"nameProtected\" : false,",
            "    \"packageLocation\" : \"src/main/java/\",",
            "    \"packageName\" : \"org.limmen.mystart\",",
            "    \"speedmentVersion\" : \"Speedment:3.1.6\"",
            "  }",
            "}"
        ).forEachOrdered(sb::append);
    }
}