package b.piatek.post.domain;

import static b.piatek.post.domain.QueryProvider.insert;
import static b.piatek.post.domain.QueryProvider.selectAll;
import static b.piatek.post.domain.QueryProvider.update;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.SqlConnection;
import io.vertx.mutiny.sqlclient.Tuple;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

/**
 * Created by Bartosz Piatek on 28/05/2023
 */
@ApplicationScoped
class PostRepository {

    private final PgPool pool;
    private final PostEntityMapper entityMapper;

    PostRepository(PgPool pool, PostEntityMapper entityMapper) {
        this.pool = pool;
        this.entityMapper = entityMapper;
    }

    Uni<Post> save(Post post) {
        return pool
            .withTransaction(conn -> runInsertQuery(conn, post));
    }

    Uni<List<Post>> getAll(long authorId) {
        return pool
            .withTransaction(conn -> runGetAllQuery(authorId, conn));
    }

    Uni<Post> updatePost(Post post) {
        return pool
            .withTransaction(conn -> updateOne(post, conn));
    }

    private Uni<Post> updateOne(Post post, SqlConnection conn) {
        return conn
            .query(update(post))
            .execute()
            .map(entityMapper::mapToEntity);
    }

    private Uni<List<Post>> runGetAllQuery(long authorId, SqlConnection conn) {
        return conn
            .query(selectAll(authorId))
            .execute()
            .map(entityMapper::mapToEntitiesList);
    }

    private Uni<Post> runInsertQuery(SqlConnection conn, Post post) {
        return conn
            .preparedQuery(insert())
            .execute(Tuple.of(post.getAuthorId(), post.getMessage()))
            .map(entityMapper::mapToEntity);
    }
}
