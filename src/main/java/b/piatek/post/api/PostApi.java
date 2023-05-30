package b.piatek.post.api;

import b.piatek.post.domain.PostFacade;
import bpiatek.proto.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;

/**
 * Created by Bartosz Piatek on 28/05/2023
 */
@GrpcService
class PostApi extends PostApiGrpc.PostApiImplBase {

    private final PostFacade postFacade;
    private final PostApiMapper apiMapper;
    private final RequestValidator requestValidator;

    PostApi(PostFacade postFacade, PostApiMapper apiMapper, RequestValidator requestValidator) {
        this.postFacade = postFacade;
        this.apiMapper = apiMapper;
        this.requestValidator = requestValidator;
    }

    @Override
    public void getPosts(PostRequest request, StreamObserver<PostsResponse> responseObserver) {
        postFacade.getPosts()
            .map(apiMapper::mapToPostsResponse)
            .subscribe()
            .with(
                c -> completeWith(responseObserver, c),
                t -> logError(t, responseObserver)
            );
    }

    @Override
    public void savePost(PostCreateRequest request, StreamObserver<PostResponse> responseObserver) {
        Uni.createFrom()
            .item(request)
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

    private <T> void completeWith(StreamObserver<T> observer, T object) {
        observer.onNext(object);
        observer.onCompleted();
    }

    private <T> void logError(Throwable throwable, StreamObserver<T> responseObserver) {
        responseObserver.onError(Status.UNKNOWN.withDescription("Error reason: " + throwable.getMessage())
                                     .asException());
        Log.error("Error reason: " + throwable.getMessage(), throwable);
    }
}
