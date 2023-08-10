package b.piatek.author.domain;

import bpiatek.proto.AuthorDTO;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartosz Piatek on 04/06/2023
 */
@ApplicationScoped
class AuthorEntityMapper {

    AuthorDTO toDto(Author author) {
        return AuthorDTO.newBuilder()
            .setId(author.getId())
            .setName(author.getName())
            .setNationality(author.getNationality())
            .build();
    }

    List<AuthorDTO> toDtoList(List<Author> authors) {
        return authors.stream()
            .map(this::toDto)
            .toList();
    }

    Author toEntity(AuthorDTO authorDto) {
        return new Author(
            authorDto.getId(),
            authorDto.getName(),
            authorDto.getNationality()
        );
    }

    Author toEntity(RowSet<Row> rows) {
        if (rows.rowCount() != 0) {
            return createAuthorFromRow(rows.iterator().next());
        }

        return new Author();
    }

    List<Author> toEntitiesList(RowSet<Row> rows) {
        List<Author> authors = new ArrayList<>();
        for (Row row : rows) {
            authors.add(createAuthorFromRow(row));
        }
        return authors;
    }

    private Author createAuthorFromRow(Row row) {
        var id = row.getLong("id");
        var name = row.getString("name");
        var nationality = row.getString("nationality");
        return new Author(id, name, nationality);
    }
}
