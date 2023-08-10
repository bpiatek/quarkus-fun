package b.piatek.author.api;

import bpiatek.proto.*;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

/**
 * Created by Bartosz Piatek on 04/06/2023
 */
@ApplicationScoped
class AuthorApiMapper {

    AuthorDTO toAuthorDto(AuthorCreateRequest request) {
        return AuthorDTO.newBuilder()
            .setName(request.getName())
            .setNationality(request.getNationality())
            .build();
    }

    AuthorResponse toResponse(AuthorDTO dto) {
        return AuthorResponse.newBuilder()
            .setId(dto.getId())
            .setName(dto.getName())
            .setNationality(dto.getNationality())
            .build();
    }

    AuthorsResponse toAuthorsResponse(List<AuthorDTO> authorDtos) {
        var list = authorDtos.stream()
            .map(this::toResponse)
            .toList();

        return AuthorsResponse.newBuilder()
            .addAllAuthors(list)
            .build();
    }
}
