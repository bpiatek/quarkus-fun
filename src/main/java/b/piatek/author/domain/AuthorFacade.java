package b.piatek.author.domain;

import bpiatek.proto.AuthorDTO;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

/**
 * Created by Bartosz Piatek on 04/06/2023
 */
@ApplicationScoped
public class AuthorFacade {

    private final AuthorEntityMapper entityMapper;
    private final AuthorRepository repository;

    public AuthorFacade(AuthorEntityMapper entityMapper, AuthorRepository repository) {
        this.entityMapper = entityMapper;
        this.repository = repository;
    }

    public Uni<AuthorDTO> save(AuthorDTO authorDTO) {
        return Uni.createFrom()
            .item(authorDTO)
            .map(entityMapper::toEntity)
            .flatMap(repository::save)
            .map(entityMapper::toDto);
    }

    public Uni<List<AuthorDTO>> getAuthors() {
        return repository.getAll()
            .map(entityMapper::toDtoList);
    }

    public Uni<AuthorDTO> getById(long authorId) {
        return repository.getById(authorId)
            .map(entityMapper::toDto);
    }
}
