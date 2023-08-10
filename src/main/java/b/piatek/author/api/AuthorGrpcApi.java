package b.piatek.author.api;

import static b.piatek.common.CallbackFinalizer.completeWith;
import static b.piatek.common.CallbackFinalizer.logError;

import b.piatek.author.domain.AuthorFacade;
import bpiatek.proto.*;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

/**
 * Created by Bartosz Piatek on 04/06/2023
 */
@GrpcService
class AuthorGrpcApi extends AuthorApiGrpc.AuthorApiImplBase {

    private final AuthorFacade authorFacade;
    private final RequestValidator requestValidator;
    private final AuthorApiMapper apiMapper;

    AuthorGrpcApi(AuthorFacade authorFacade, RequestValidator requestValidator, AuthorApiMapper apiMapper) {
        this.authorFacade = authorFacade;
        this.requestValidator = requestValidator;
        this.apiMapper = apiMapper;
    }

    @Override
    public void saveAuthor(AuthorCreateRequest request, StreamObserver<AuthorResponse> responseObserver) {
        requestValidator.validateCreateRequest(request)
            .map(apiMapper::toAuthorDto)
            .flatMap(authorFacade::save)
            .map(apiMapper::toResponse)
            .subscribe()
            .with(
                c -> completeWith(responseObserver, c),
                t -> logError(t, responseObserver)
            );
    }

    @Override
    public void getAuthors(GetAuthorsRequest request, StreamObserver<AuthorsResponse> responseObserver) {
        authorFacade.getAuthors()
            .map(apiMapper::toAuthorsResponse)
            .subscribe()
            .with(
                c -> completeWith(responseObserver, c),
                t -> logError(t, responseObserver)
            );
    }
}
