package com.example.infrastructure.api;

import com.example.infrastructure.models.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ItemsForOrderApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
public interface ItemsForOrderApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /itemsForOrder/{orderId} : List all items for an order
     *
     * @param orderId  (required)
     * @return A list of items for an order. (status code 200)
     *         or unexpected error (status code 400)
     * @see ItemsForOrderApi#itemsForOrderOrderIdGet
     */
    default ResponseEntity<List<Item>> itemsForOrderOrderIdGet(Integer orderId) {
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

}
