package com.example.infrastructure.api.delegates;

import com.example.infrastructure.api.utils.ApiUtil;
import com.example.infrastructure.api.api_def.CouriersApi;
import com.example.infrastructure.api.controllers.CouriersApiController;
import com.example.infrastructure.api.errors.UserExistsException;
import com.example.infrastructure.models.CourierDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link CouriersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
public interface CouriersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /couriers : List all couriers
     *
     * @param limit  (optional)
     * @return A list of couriers. (status code 200)
     *         or unexpected error (status code 400)
     * @see CouriersApi#couriersGet
     */
    default ResponseEntity<List<CourierDTO>> couriersGet(Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"salt\" : \"salt\", \"phone\" : \"phone\", \"surname\" : \"surname\", \"name\" : \"name\", \"id\" : 0, \"login\" : \"login\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /couriers/{id} : Delete courier by id
     *
     * @param id  (required)
     * @return Deleted (status code 204)
     *         or Id not found (status code 404)
     * @see CouriersApi#couriersIdDelete
     */
    default ResponseEntity<String> couriersIdDelete(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /couriers/{id} : Get courier by id
     *
     * @param id  (required)
     * @return Get courier by id (status code 200)
     *         or unexpected error (status code 400)
     * @see CouriersApi#couriersIdGet
     */
    default ResponseEntity<CourierDTO> couriersIdGet(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"salt\" : \"salt\", \"phone\" : \"phone\", \"surname\" : \"surname\", \"name\" : \"name\", \"id\" : 0, \"login\" : \"login\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /couriers : Create a courier
     *
     * @return Null response (status code 201)
     *         or unexpected error (status code 400)
     * @see CouriersApi#couriersPost
     */
    default ResponseEntity<String> couriersPost(CourierDTO courier) throws UserExistsException {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
    default ResponseEntity<String> temp(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
