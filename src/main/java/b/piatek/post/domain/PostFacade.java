package b.piatek.post.domain;

import bpiatek.proto.*;
import io.smallrye.mutiny.Uni;

import java.util.List;

/**
 * Created by Bartosz Piatek on 28/05/2023
 */
//@ApplicationScoped
public class PostFacade {

    private final PostRepository repository;
    private final PostEntityMapper entityMapper;

    PostFacade(PostRepository repository, PostEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    public Uni<List<PostDTO>> getPosts() {
        return repository.getAll()
            .map(entityMapper::mapToDtos);
    }

    public Uni<PostDTO> save(PostDTO postDTO) {
        return Uni.createFrom()
            .item(postDTO)
            .map(entityMapper::mapToEntity)
            .flatMap(repository::save)
            .map(entityMapper::mapToDto);
    }

    public Uni<PostDTO> updatePost(PostDTO postDTO) {
        return Uni.createFrom()
            .item(postDTO)
            .map(entityMapper::mapToEntity)
            .flatMap(repository::updatePost)
            .map(entityMapper::mapToDto);
    }
}
