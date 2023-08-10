package b.piatek.author.domain;

import static b.piatek.author.domain.QueryProvider.insert;
import static b.piatek.author.domain.QueryProvider.selectAll;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.SqlConnection;
import io.vertx.mutiny.sqlclient.Tuple;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

/**
 * Created by Bartosz Piatek on 04/06/2023
 */
@ApplicationScoped
class AuthorRepository {

    private final PgPool pool;
    private final AuthorEntityMapper entityMapper;

    public AuthorRepository(PgPool pool, AuthorEntityMapper entityMapper) {
        this.pool = pool;
        this.entityMapper = entityMapper;
    }

    Uni<Author> save(Author author) {
        return pool
            .withTransaction(conn -> runInsertQuery(conn, author));
    }

    Uni<List<Author>> getAll() {
        return pool
            .withTransaction(this::runGetAllQuery);
    }

    Uni<Author> getById(long authorId) {
        return pool
            .withTransaction(conn -> runGetAByIdQuery(conn, authorId));
    }


    private Uni<Author> runInsertQuery(SqlConnection conn, Author author) {
        return conn
            .preparedQuery(insert())
            .execute(Tuple.of(author.getName(), author.getNationality()))
            .map(entityMapper::toEntity);
    }

    private Uni<List<Author>> runGetAllQuery(SqlConnection conn) {
        return conn
            .query(selectAll())
            .execute()
            .map(entityMapper::toEntitiesList);
    }

    private Uni<Author> runGetAByIdQuery(SqlConnection conn, long authorId) {
        return conn
            .query(QueryProvider.getById(authorId))
            .execute()
            .map(entityMapper::toEntity);
    }
}
