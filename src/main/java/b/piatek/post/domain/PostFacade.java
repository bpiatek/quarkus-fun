package b.piatek.post.domain;

import b.piatek.author.domain.AuthorFacade;
import bpiatek.proto.*;
import io.smallrye.mutiny.Uni;

import java.util.List;

/**
 * Created by Bartosz Piatek on 28/05/2023
 */
public class PostFacade {

    private final AuthorFacade authorFacade;
    private final PostRepository postRepository;
    private final PostEntityMapper entityMapper;

    PostFacade(AuthorFacade authorFacade, PostRepository postRepository, PostEntityMapper entityMapper) {
        this.authorFacade = authorFacade;
        this.postRepository = postRepository;
        this.entityMapper = entityMapper;
    }

    public Uni<List<PostDTO>> getPosts(long authorId, boolean fullAuthor) {
        return postRepository.getAll(authorId)
                .onItem()
//                .call(v -> {
//                    if(fullAuthor) {
//
//                    }
//                    return Uni.createFrom().item(v);
//                })
                .transform(entityMapper::mapToDtos);


    }

    private void addFullAuthor() {

    }

    public Uni<PostDTO> save(PostDTO postDTO) {
        return Uni.createFrom()
                .item(postDTO)
                .map(entityMapper::mapToEntity)
                .flatMap(postRepository::save)
                .map(entityMapper::mapToDto);
    }

    public Uni<PostDTO> updatePost(PostDTO postDTO) {
        return Uni.createFrom()
                .item(postDTO)
                .map(entityMapper::mapToEntity)
                .flatMap(postRepository::updatePost)
                .map(entityMapper::mapToDto);
    }
}
