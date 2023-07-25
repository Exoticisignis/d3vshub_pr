/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.infrastructure.api.api_def;

import com.example.infrastructure.api.delegates.ItemsApiDelegate;
import com.example.infrastructure.models.Error;
import com.example.infrastructure.models.ItemDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
@Validated
@Api(value = "items", description = "the items API")
public interface ItemsApi {

    default ItemsApiDelegate getDelegate() {
        return new ItemsApiDelegate() {};
    }

    /**
     * GET /items : List all items
     *
     * @param limit  (optional)
     * @return A list of items. (status code 200)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "List all items", nickname = "itemsGet", notes = "", response = ItemDTO.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of items.", response = ItemDTO.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @GetMapping(
        value = "/items",
        produces = { "application/json" }
    )
    default ResponseEntity<List<ItemDTO>> itemsGet(@ApiParam(value = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        return getDelegate().itemsGet(limit);
    }


    /**
     * DELETE /items/{id} : Delete item by id
     *
     * @param id  (required)
     * @return Deleted (status code 204)
     *         or Id not found (status code 404)
     */
    @ApiOperation(value = "Delete item by id", nickname = "itemsIdDelete", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 404, message = "Id not found") })
    @DeleteMapping(
        value = "/items/{id}"
    )
    default ResponseEntity<String> itemsIdDelete(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {
        return getDelegate().itemsIdDelete(id);
    }


    /**
     * GET /items/{id} : Get item by id
     *
     * @param id  (required)
     * @return Get item by id (status code 200)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "Get item by id", nickname = "itemsIdGet", notes = "", response = ItemDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Get item by id", response = ItemDTO.class),
        @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @GetMapping(
        value = "/items/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<ItemDTO> itemsIdGet(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {
        return getDelegate().itemsIdGet(id);
    }


    /**
     * POST /items : Create an item
     *
     * @return Null response (status code 201)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "Create an item", nickname = "itemsPost", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Null response"),
        @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @PostMapping(
        value = "/items",
        produces = { "application/json" }
    )
    default ResponseEntity<String> itemsPost(@RequestBody ItemDTO item) {
        return getDelegate().itemsPost(item);
    }

    /**
     * GET /itemsForOrder/{orderId} : List all items for an order
     *
     * @param orderId  (required)
     * @return A list of items for an order. (status code 200)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "List all items for an order", nickname = "itemsForOrderOrderIdGet", notes = "", response = ItemDTO.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of items for an order.", response = ItemDTO.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @GetMapping(
            value = "/itemsForOrder/{orderId}",
            produces = { "application/json" }
    )
    default ResponseEntity<List<ItemDTO>> itemsForOrderOrderIdGet(@ApiParam(value = "",required=true) @PathVariable("orderId") Long orderId) {
        return getDelegate().itemsForOrderOrderIdGet(orderId);
    }

}