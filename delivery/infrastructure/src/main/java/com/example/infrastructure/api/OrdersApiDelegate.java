package com.example.infrastructure.api;

import com.example.infrastructure.models.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link OrdersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
public interface OrdersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /orders/{customerId} : List all orders for a customer
     *
     * @param customerId  (required)
     * @return A list of orders for a customer. (status code 200)
     *         or unexpected error (status code 400)
     * @see OrdersApi#ordersCustomerIdGet
     */
    default ResponseEntity<List<Order>> ordersCustomerIdGet(Integer customerId) {
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

    /**
     * GET /orders : List all orders
     *
     * @param limit  (optional)
     * @return A list of orders. (status code 200)
     *         or unexpected error (status code 400)
     * @see OrdersApi#ordersGet
     */
    default ResponseEntity<List<Order>> ordersGet(Integer limit) {
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

    /**
     * DELETE /orders/{id} : Delete order by id
     *
     * @param id  (required)
     * @return Deleted (status code 204)
     *         or Id not found (status code 404)
     * @see OrdersApi#ordersIdDelete
     */
    default ResponseEntity<String> ordersIdDelete(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /orders/{id} : Get order by id
     *
     * @param id  (required)
     * @return Get order by id (status code 200)
     *         or unexpected error (status code 400)
     * @see OrdersApi#ordersIdGet
     */
    default ResponseEntity<Order> ordersIdGet(Integer id) {
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

    /**
     * POST /orders : Create an order
     *
     * @return Null response (status code 201)
     *         or unexpected error (status code 200)
     * @see OrdersApi#ordersPost
     */
    default ResponseEntity<String> ordersPost(Order order) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
    /**
     * GET /ordersForItem/{itemId} : List all orders containing item
     *
     * @param itemId  (required)
     * @return A list of orders containing item. (status code 200)
     *         or unexpected error (status code 400)
     * @see OrdersForItemApi#ordersForItemItemIdGet
     */
    default ResponseEntity<List<Order>> ordersForItemIdGet(Integer itemId) {
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
