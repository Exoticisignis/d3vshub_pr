package com.example.infrastructure.api;

import com.example.infrastructure.models.ItemDTO;
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
    default ResponseEntity<List<ItemDTO>> itemsGet(Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"quantity\" : 5, \"price\" : 5.962133916683182, \"imageUrl\" : \"imageUrl\", \"allergenInfo\" : \"allergenInfo\", \"description\" : \"description\", \"id\" : 1, \"category\" : \"category\" }";
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
    default ResponseEntity<String> itemsIdDelete(Long id) {
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
    default ResponseEntity<ItemDTO> itemsIdGet(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"quantity\" : 5, \"price\" : 5.962133916683182, \"imageUrl\" : \"imageUrl\", \"allergenInfo\" : \"allergenInfo\", \"description\" : \"description\", \"id\" : 1, \"category\" : \"category\" }";
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
    default ResponseEntity<String> itemsPost(ItemDTO item) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    default ResponseEntity<List<ItemDTO>> itemsForOrderOrderIdGet(Long orderId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"quantity\" : 5, \"price\" : 5.962133916683182, \"imageUrl\" : \"imageUrl\", \"allergenInfo\" : \"allergenInfo\", \"description\" : \"description\", \"id\" : 1, \"category\" : \"category\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
