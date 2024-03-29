/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.infrastructure.api.api_def;

import com.example.infrastructure.api.delegates.DeliveriesApiDelegate;
import com.example.infrastructure.models.DeliveryDTO;
import com.example.infrastructure.models.Error;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
@Validated
@Api(value = "deliveries", description = "the deliveries API")
public interface DeliveriesApi {

    default DeliveriesApiDelegate getDelegate() {
        return new DeliveriesApiDelegate() {};
    }

    /**
     * GET /deliveries : List all deliveries
     *
     * @param limit  (optional)
     * @return A list of deliveries. (status code 200)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "List all deliveries", nickname = "deliveriesGet", notes = "", response = DeliveryDTO.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of deliveries.", response = DeliveryDTO.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @GetMapping(
        value = "/deliveries",
        produces = { "application/json" }
    )
    default ResponseEntity<List<DeliveryDTO>> deliveriesGet(@ApiParam(value = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        return getDelegate().deliveriesGet(limit);
    }


    /**
     * DELETE /deliveries/{id} : Delete courier by id
     *
     * @param id  (required)
     * @return Deleted (status code 204)
     *         or Id not found (status code 404)
     */
    @ApiOperation(value = "Delete courier by id", nickname = "deliveriesIdDelete", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 404, message = "Id not found") })
    @DeleteMapping(
        value = "/deliveries/{id}"
    )
    default ResponseEntity<String> deliveriesIdDelete(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {
        return getDelegate().deliveriesIdDelete(id);
    }


    /**
     * GET /deliveries/{id} : Get delivery by id
     *
     * @param id  (required)
     * @return Get delivery by id (status code 200)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "Get delivery by id", nickname = "deliveriesIdGet", notes = "", response = DeliveryDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Get delivery by id", response = DeliveryDTO.class),
        @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @GetMapping(
        value = "/deliveries/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<DeliveryDTO> deliveriesIdGet(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {
        return getDelegate().deliveriesIdGet(id);
    }


    /**
     * POST /deliveries : Create a delivery
     *
     * @return Null response (status code 201)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "Create a delivery", nickname = "deliveriesPost", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Null response"),
        @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @PostMapping(
        value = "/deliveries",
        produces = { "application/json" }
    )
    default ResponseEntity<String> deliveriesPost(@RequestBody DeliveryDTO delivery) {
        return getDelegate().deliveriesPost(delivery);
    }

}
