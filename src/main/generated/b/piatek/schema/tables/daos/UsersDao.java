/*
 * This file is generated by jOOQ.
 */
package b.piatek.schema.tables.daos;


import b.piatek.schema.tables.Users;
import b.piatek.schema.tables.records.UsersRecord;

import io.github.jklingsporn.vertx.jooq.shared.reactive.AbstractReactiveVertxDAO;

import java.util.Collection;

import org.jooq.Configuration;


import java.util.List;
import io.smallrye.mutiny.Uni;
import io.github.jklingsporn.vertx.jooq.mutiny.reactive.ReactiveMutinyQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersDao extends AbstractReactiveVertxDAO<UsersRecord, b.piatek.schema.tables.pojos.Users, Long, Uni<List<b.piatek.schema.tables.pojos.Users>>, Uni<b.piatek.schema.tables.pojos.Users>, Uni<Integer>, Uni<Long>> implements io.github.jklingsporn.vertx.jooq.mutiny.VertxDAO<UsersRecord,b.piatek.schema.tables.pojos.Users,Long> {

        /**
     * @param configuration The Configuration used for rendering and query
     * execution.
     * @param vertx the vertx instance
     */
        public UsersDao(Configuration configuration, io.vertx.mutiny.sqlclient.SqlClient delegate) {
                super(Users.USERS, b.piatek.schema.tables.pojos.Users.class, new ReactiveMutinyQueryExecutor<UsersRecord,b.piatek.schema.tables.pojos.Users,Long>(configuration,delegate,b.piatek.schema.tables.mappers.RowMappers.getUsersMapper()));
        }

        @Override
        protected Long getId(b.piatek.schema.tables.pojos.Users object) {
                return object.getId();
        }

        /**
     * Find records that have <code>name IN (values)</code> asynchronously
     */
        public Uni<List<b.piatek.schema.tables.pojos.Users>> findManyByName(Collection<String> values) {
                return findManyByCondition(Users.USERS.NAME.in(values));
        }

        /**
     * Find records that have <code>name IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Uni<List<b.piatek.schema.tables.pojos.Users>> findManyByName(Collection<String> values, int limit) {
                return findManyByCondition(Users.USERS.NAME.in(values),limit);
        }

        @Override
        public ReactiveMutinyQueryExecutor<UsersRecord,b.piatek.schema.tables.pojos.Users,Long> queryExecutor(){
                return (ReactiveMutinyQueryExecutor<UsersRecord,b.piatek.schema.tables.pojos.Users,Long>) super.queryExecutor();
        }
}