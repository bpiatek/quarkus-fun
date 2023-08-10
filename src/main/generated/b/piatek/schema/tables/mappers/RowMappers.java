package b.piatek.schema.tables.mappers;

import io.vertx.sqlclient.Row;
import java.util.function.Function;

public class RowMappers {

        private RowMappers(){}

        public static Function<Row,b.piatek.schema.tables.pojos.Author> getAuthorMapper() {
                return row -> {
                        b.piatek.schema.tables.pojos.Author pojo = new b.piatek.schema.tables.pojos.Author();
                        pojo.setId(row.getInteger("id"));
                        pojo.setName(row.getString("name"));
                        pojo.setNationality(row.getString("nationality"));
                        return pojo;
                };
        }

        public static Function<Row,b.piatek.schema.tables.pojos.FlywaySchemaHistory> getFlywaySchemaHistoryMapper() {
                return row -> {
                        b.piatek.schema.tables.pojos.FlywaySchemaHistory pojo = new b.piatek.schema.tables.pojos.FlywaySchemaHistory();
                        pojo.setInstalledRank(row.getInteger("installed_rank"));
                        pojo.setVersion(row.getString("version"));
                        pojo.setDescription(row.getString("description"));
                        pojo.setType(row.getString("type"));
                        pojo.setScript(row.getString("script"));
                        pojo.setChecksum(row.getInteger("checksum"));
                        pojo.setInstalledBy(row.getString("installed_by"));
                        pojo.setInstalledOn(row.getLocalDateTime("installed_on"));
                        pojo.setExecutionTime(row.getInteger("execution_time"));
                        pojo.setSuccess(row.getBoolean("success"));
                        return pojo;
                };
        }

        public static Function<Row,b.piatek.schema.tables.pojos.Post> getPostMapper() {
                return row -> {
                        b.piatek.schema.tables.pojos.Post pojo = new b.piatek.schema.tables.pojos.Post();
                        pojo.setId(row.getInteger("id"));
                        pojo.setMessage(row.getString("message"));
                        pojo.setAuthorid(row.getInteger("authorid"));
                        return pojo;
                };
        }

        public static Function<Row,b.piatek.schema.tables.pojos.Testuser> getTestuserMapper() {
                return row -> {
                        b.piatek.schema.tables.pojos.Testuser pojo = new b.piatek.schema.tables.pojos.Testuser();
                        pojo.setId(row.getLong("id"));
                        pojo.setPassword(row.getString("password"));
                        pojo.setRoles(row.getString("roles"));
                        pojo.setUsername(row.getString("username"));
                        return pojo;
                };
        }

        public static Function<Row,b.piatek.schema.tables.pojos.Users> getUsersMapper() {
                return row -> {
                        b.piatek.schema.tables.pojos.Users pojo = new b.piatek.schema.tables.pojos.Users();
                        pojo.setId(row.getLong("id"));
                        pojo.setName(row.getString("name"));
                        return pojo;
                };
        }

}
