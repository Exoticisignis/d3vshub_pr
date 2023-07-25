package com.example.infrastructure.api.delegates;

import com.example.infrastructure.api.utils.ApiUtil;
import com.example.infrastructure.api.api_def.DeliveriesApi;
import com.example.infrastructure.api.controllers.DeliveriesApiController;
import com.example.infrastructure.models.DeliveryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link DeliveriesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
public interface DeliveriesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /deliveries : List all deliveries
     *
     * @param limit  (optional)
     * @return A list of deliveries. (status code 200)
     *         or unexpected error (status code 400)
     * @see DeliveriesApi#deliveriesGet
     */
    default ResponseEntity<List<DeliveryDTO>> deliveriesGet(Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"courier\" : 1, \"id\" : 0, \"deliveryDate\" : \"2000-01-23T04:56:07.000+00:00\", \"order\" : 6 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /deliveries/{id} : Delete courier by id
     *
     * @param id  (required)
     * @return Deleted (status code 204)
     *         or Id not found (status code 404)
     * @see DeliveriesApi#deliveriesIdDelete
     */
    default ResponseEntity<String> deliveriesIdDelete(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /deliveries/{id} : Get delivery by id
     *
     * @param id  (required)
     * @return Get delivery by id (status code 200)
     *         or unexpected error (status code 400)
     * @see DeliveriesApi#deliveriesIdGet
     */
    default ResponseEntity<DeliveryDTO> deliveriesIdGet(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"courier\" : 1, \"id\" : 0, \"deliveryDate\" : \"2000-01-23T04:56:07.000+00:00\", \"order\" : 6 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /deliveries : Create a delivery
     *
     * @return Null response (status code 201)
     *         or unexpected error (status code 400)
     * @see DeliveriesApi#deliveriesPost
     */
    default ResponseEntity<String> deliveriesPost(DeliveryDTO delivery) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
