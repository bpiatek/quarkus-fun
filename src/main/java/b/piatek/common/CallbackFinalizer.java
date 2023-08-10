package b.piatek.common;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import io.quarkus.logging.Log;

/**
 * Created by Bartosz Piatek on 04/06/2023
 */
public class CallbackFinalizer {

    private CallbackFinalizer() {
    }

    public static <T> void completeWith(StreamObserver<T> observer, T object) {
        observer.onNext(object);
        observer.onCompleted();
    }

    public static <T> void logError(Throwable throwable, StreamObserver<T> responseObserver) {
        responseObserver.onError(Status.UNKNOWN.withDescription("Error reason: " + throwable.getMessage())
                                     .asException());
        Log.error("Error reason: " + throwable.getMessage(), throwable);
    }
}
