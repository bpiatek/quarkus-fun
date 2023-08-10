package b.piatek.post.api;


import static org.apache.commons.lang3.StringUtils.isBlank;

import bpiatek.proto.PostCreateRequest;
import bpiatek.proto.PostUpdateRequest;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Created by Bartosz Piatek on 28/05/2023
 */
@ApplicationScoped
class RequestValidator {

    Uni<PostUpdateRequest> validateUpdateRequest(PostUpdateRequest request) {
        if (request.getId() == 0) {
           throw new IllegalArgumentException("Id must bo provided and can not be 0!");
        }

        if (request.getAuthorId() == 0 && isBlank(request.getMessage())) {
            throw new IllegalArgumentException("At least one field must be provided for update!");
        }

        return Uni.createFrom().item(request);
    }

    Uni<PostCreateRequest> validateCreateRequest(PostCreateRequest request) {
        if (request.getAuthorId() == 0 || isBlank(request.getMessage())) {
            throw new IllegalArgumentException("Both author and message must be provided!");
        }

        return Uni.createFrom().item(request);
    }
}
