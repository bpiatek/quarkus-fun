package b.piatek.author.api;

import static org.apache.commons.lang3.StringUtils.isBlank;

import bpiatek.proto.AuthorCreateRequest;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Created by Bartosz Piatek on 04/06/2023
 */
@ApplicationScoped
class RequestValidator {

    Uni<AuthorCreateRequest> validateCreateRequest(AuthorCreateRequest request) {
        if (isBlank(request.getName()) || isBlank(request.getNationality())) {
            throw new IllegalArgumentException("Both name and nationality must be provided!");
        }

        return Uni.createFrom().item(request);
    }

}
