package com.example.infrastructure.api;

import com.example.infrastructure.models.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link OrdersForItemApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
public interface OrdersForItemApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /ordersForItem/{itemId} : List all orders containing item
     *
     * @param itemId  (required)
     * @return A list of orders containing item. (status code 200)
     *         or unexpected error (status code 400)
     * @see OrdersForItemApi#ordersForItemItemIdGet
     */
    default ResponseEntity<List<Order>> ordersForItemItemIdGet(Integer itemId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"address\" : \"address\", \"totalPrice\" : 2.3021358869347655, \"id\" : 0, \"orderItems\" : [ { \"quantity\" : 5, \"price\" : 5.962133916683182, \"imageUrl\" : \"imageUrl\", \"allergenInfo\" : \"allergenInfo\", \"description\" : \"description\", \"id\" : 1, \"category\" : \"category\" }, { \"quantity\" : 5, \"price\" : 5.962133916683182, \"imageUrl\" : \"imageUrl\", \"allergenInfo\" : \"allergenInfo\", \"description\" : \"description\", \"id\" : 1, \"category\" : \"category\" } ], \"orderDate\" : \"2000-01-23T04:56:07.000+00:00\", \"customer\" : 6 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
