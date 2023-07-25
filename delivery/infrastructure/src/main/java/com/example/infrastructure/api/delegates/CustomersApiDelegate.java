package com.example.infrastructure.api.delegates;

import com.example.infrastructure.api.utils.ApiUtil;
import com.example.infrastructure.api.api_def.CustomersApi;
import com.example.infrastructure.api.controllers.CustomersApiController;
import com.example.infrastructure.api.errors.UserExistsException;
import com.example.infrastructure.models.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link CustomersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
public interface CustomersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /customers : List all customers
     *
     * @param limit  (optional)
     * @return A list of customers. (status code 200)
     *         or unexpected error (status code 400)
     * @see CustomersApi#customersGet
     */
    default ResponseEntity<List<CustomerDTO>> customersGet(Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"address\" : \"address\", \"salt\" : \"salt\", \"phone\" : \"phone\", \"surname\" : \"surname\", \"name\" : \"name\", \"id\" : 0, \"login\" : \"login\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /customers/{id} : Delete customer by id
     *
     * @param id  (required)
     * @return Deleted (status code 204)
     *         or Id not found (status code 404)
     * @see CustomersApi#customersIdDelete
     */
    default ResponseEntity<String> customersIdDelete(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /customers/{id} : Get customer by id
     *
     * @param id  (required)
     * @return Get customer by id (status code 200)
     *         or unexpected error (status code 400)
     * @see CustomersApi#customersIdGet
     */
    default ResponseEntity<CustomerDTO> customersIdGet(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"address\" : \"address\", \"salt\" : \"salt\", \"phone\" : \"phone\", \"surname\" : \"surname\", \"name\" : \"name\", \"id\" : 0, \"login\" : \"login\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /customers : Create a customer
     *
     * @return Null response (status code 201)
     *         or unexpected error (status code 400)
     * @see CustomersApi#customersPost
     */
    default ResponseEntity<String> customersPost(CustomerDTO customer) throws UserExistsException {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
