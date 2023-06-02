package b.piatek.post.domain;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import bpiatek.proto.PostDTO;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartosz Piatek on 29/05/2023
 */
@ApplicationScoped
class PostEntityMapper {

    List<PostDTO> mapToDtos(List<Post> posts) {
        return posts.stream()
            .map(this::mapToDto)
            .toList();
    }

    PostDTO mapToDto(Post post) {
        return PostDTO.newBuilder()
            .setId(post.getId() != null ? post.getId() : 0)
            .setAuthor(post.getAuthor() != null ? post.getAuthor() : EMPTY)
            .setMessage(post.getMessage() != null ? post.getMessage() : EMPTY)
            .build();
    }

    Post mapToEntity(PostDTO dto) {
        return new Post(
            dto.getId(),
            dto.getAuthor(),
            dto.getMessage()
        );
    }

    Post mapToEntity(RowSet<Row> rows) {
        if (rows.rowCount() != 0) {
            return createPostFromRow(rows.iterator().next());
        }
        return new Post();
    }

    List<Post> mapToEntitiesList(RowSet<Row> rows) {
        List<Post> posts = new ArrayList<>();
        for (Row row : rows) {
            posts.add(createPostFromRow(row));
        }
        return posts;
    }

    private Post createPostFromRow(Row row) {
        var id = row.getLong("id");
        var author = row.getString("author");
        var message = row.getString("message");
        return new Post(id, author, message);
    }
}
