package com.example.infrastructure.api;

import com.example.infrastructure.models.Tracking;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

/**
 * A delegate to be called by the {@link TrackingForDeliveryApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
public interface TrackingForDeliveryApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /trackingForDelivery/{id} : Get tracking by delviery id
     *
     * @param id  (required)
     * @return Get tracking by delivery id (status code 200)
     *         or unexpected error (status code 400)
     * @see TrackingForDeliveryApi#trackingForDeliveryIdGet
     */
    default ResponseEntity<Tracking> trackingForDeliveryIdGet(Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"delivery\" : 6, \"location\" : \"location\", \"updateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : 0, \"status\" : \"status\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
