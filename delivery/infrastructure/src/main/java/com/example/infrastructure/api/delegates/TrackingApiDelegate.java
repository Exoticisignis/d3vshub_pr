package com.example.infrastructure.api.delegates;

import com.example.infrastructure.api.utils.ApiUtil;
import com.example.infrastructure.api.api_def.TrackingApi;
import com.example.infrastructure.api.controllers.TrackingApiController;
import com.example.infrastructure.models.TrackingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link TrackingApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
public interface TrackingApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /tracking : List all tracking
     *
     * @param limit  (optional)
     * @return A list of tracking. (status code 200)
     *         or unexpected error (status code 400)
     * @see TrackingApi#trackingGet
     */
    default ResponseEntity<List<TrackingDTO>> trackingGet(Integer limit) {
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

    /**
     * DELETE /tracking/{id} : Delete tracking by id
     *
     * @param id  (required)
     * @return Deleted (status code 204)
     *         or Id not found (status code 404)
     * @see TrackingApi#trackingIdDelete
     */
    default ResponseEntity<String> trackingIdDelete(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /tracking/{id} : Get tracking by id
     *
     * @param id  (required)
     * @return Get tracking by id (status code 200)
     *         or unexpected error (status code 400)
     * @see TrackingApi#trackingIdGet
     */
    default ResponseEntity<TrackingDTO> trackingIdGet(Long id) {
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

    /**
     * POST /tracking : Create a tracking
     *
     * @return Null response (status code 201)
     *         or unexpected error (status code 400)
     * @see TrackingApi#trackingPost
     */
    default ResponseEntity<String> trackingPost(TrackingDTO tracking) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
    default ResponseEntity<TrackingDTO> trackingForDeliveryIdGet(Long id) {
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
