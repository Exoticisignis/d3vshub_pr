package com.example.infrastructure.api;

import com.example.infrastructure.models.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ItemsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
public interface ItemsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /items : List all items
     *
     * @param limit  (optional)
     * @return A list of items. (status code 200)
     *         or unexpected error (status code 400)
     * @see ItemsApi#itemsGet
     */
    default ResponseEntity<List<Item>> itemsGet(Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"quantity\" : 5, \"price\" : 5.962133916683182, \"imageUrl\" : \"imageUrl\", \"allergenInfo\" : \"allergenInfo\", \"description\" : \"description\", \"id\" : 1, \"category\" : \"category\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /items/{id} : Delete item by id
     *
     * @param id  (required)
     * @return Deleted (status code 204)
     *         or Id not found (status code 404)
     * @see ItemsApi#itemsIdDelete
     */
    default ResponseEntity<Void> itemsIdDelete(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /items/{id} : Get item by id
     *
     * @param id  (required)
     * @return Get item by id (status code 200)
     *         or unexpected error (status code 400)
     * @see ItemsApi#itemsIdGet
     */
    default ResponseEntity<Item> itemsIdGet(Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"quantity\" : 5, \"price\" : 5.962133916683182, \"imageUrl\" : \"imageUrl\", \"allergenInfo\" : \"allergenInfo\", \"description\" : \"description\", \"id\" : 1, \"category\" : \"category\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /items : Create an item
     *
     * @return Null response (status code 201)
     *         or unexpected error (status code 400)
     * @see ItemsApi#itemsPost
     */
    default ResponseEntity<Void> itemsPost() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
