package b.piatek.post.api;

import bpiatek.proto.*;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

/**
 * Created by Bartosz Piatek on 28/05/2023
 */
@ApplicationScoped
class PostApiMapper {

    PostDTO toPostDto(PostCreateRequest request) {
        return PostDTO.newBuilder()
            .setAuthor(request.getAuthor())
            .setMessage(request.getMessage())
            .build();
    }

    PostResponse mapToResponse(PostDTO postDto) {
        return PostResponse.newBuilder()
            .setId(postDto.getId())
            .setAuthor(postDto.getAuthor())
            .setMessage(postDto.getMessage())
            .build();
    }

    PostsResponse mapToPostsResponse(List<PostDTO> postDtos) {
        var list = postDtos.stream()
            .map(this::mapToResponse)
            .toList();

        return PostsResponse.newBuilder()
            .addAllPosts(list)
            .build();
    }

    PostDTO toPostDto(PostUpdateRequest request) {
        return PostDTO.newBuilder()
            .setId(request.getId())
            .setAuthor(request.getAuthor())
            .setMessage(request.getMessage())
            .build();
    }
}
