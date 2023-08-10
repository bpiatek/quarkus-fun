package b.piatek.post.api;

import static b.piatek.common.CallbackFinalizer.completeWith;
import static b.piatek.common.CallbackFinalizer.logError;

import b.piatek.post.domain.PostFacade;
import bpiatek.proto.*;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

/**
 * Created by Bartosz Piatek on 28/05/2023
 */
@GrpcService
class PostGrpcApi extends PostApiGrpc.PostApiImplBase {

    private final PostFacade postFacade;
    private final PostApiMapper apiMapper;
    private final RequestValidator requestValidator;

    PostGrpcApi(PostFacade postFacade, PostApiMapper apiMapper, RequestValidator requestValidator) {
        this.postFacade = postFacade;
        this.apiMapper = apiMapper;
        this.requestValidator = requestValidator;
    }

    @Override
    public void getPosts(GetPostsRequest request, StreamObserver<PostsResponse> responseObserver) {
        postFacade.getPosts(request.getAuthorId(), request.getFullAuthor())
            .map(apiMapper::mapToPostsResponse)
            .subscribe()
            .with(
                c -> completeWith(responseObserver, c),
                t -> logError(t, responseObserver)
            );
    }

    @Override
    public void savePost(PostCreateRequest request, StreamObserver<PostResponse> responseObserver) {
        requestValidator.validateCreateRequest(request)
            .map(apiMapper::toPostDto)
            .flatMap(postFacade::save)
            .map(apiMapper::mapToResponse)
            .subscribe()
            .with(
                c -> completeWith(responseObserver, c),
                t -> logError(t, responseObserver)
            );
    }

    @Override
    public void updatePost(PostUpdateRequest request, StreamObserver<PostResponse> responseObserver) {
        requestValidator.validateUpdateRequest(request)
            .map(apiMapper::toPostDto)
            .flatMap(postFacade::updatePost)
            .map(apiMapper::mapToResponse)
            .subscribe()
            .with(
                c -> completeWith(responseObserver, c),
                t -> logError(t, responseObserver)
            );
    }
}
