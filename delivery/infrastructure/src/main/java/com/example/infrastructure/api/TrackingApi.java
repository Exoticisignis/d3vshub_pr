/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.infrastructure.api;

import com.example.infrastructure.models.Error;
import com.example.infrastructure.models.Tracking;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
@Validated
@Api(value = "tracking", description = "the tracking API")
public interface TrackingApi {

    default TrackingApiDelegate getDelegate() {
        return new TrackingApiDelegate() {};
    }

    /**
     * GET /tracking : List all tracking
     *
     * @param limit  (optional)
     * @return A list of tracking. (status code 200)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "List all tracking", nickname = "trackingGet", notes = "", response = Tracking.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of tracking.", response = Tracking.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @GetMapping(
        value = "/tracking",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Tracking>> trackingGet(@ApiParam(value = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        return getDelegate().trackingGet(limit);
    }


    /**
     * DELETE /tracking/{id} : Delete tracking by id
     *
     * @param id  (required)
     * @return Deleted (status code 204)
     *         or Id not found (status code 404)
     */
    @ApiOperation(value = "Delete tracking by id", nickname = "trackingIdDelete", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 404, message = "Id not found") })
    @DeleteMapping(
        value = "/tracking/{id}"
    )
    default ResponseEntity<String> trackingIdDelete(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {
        return getDelegate().trackingIdDelete(id);
    }


    /**
     * GET /tracking/{id} : Get tracking by id
     *
     * @param id  (required)
     * @return Get tracking by id (status code 200)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "Get tracking by id", nickname = "trackingIdGet", notes = "", response = Tracking.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Get tracking by id", response = Tracking.class),
        @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @GetMapping(
        value = "/tracking/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<Tracking> trackingIdGet(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {
        return getDelegate().trackingIdGet(id);
    }


    /**
     * POST /tracking : Create a tracking
     *
     * @return Null response (status code 201)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "Create a tracking", nickname = "trackingPost", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Null response"),
        @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @PostMapping(
        value = "/tracking",
        produces = { "application/json" }
    )
    default ResponseEntity<String> trackingPost(@RequestBody Tracking tracking) {
        return getDelegate().trackingPost(tracking);
    }
    /**
     * GET /trackingForDelivery/{id} : Get tracking by delviery id
     *
     * @param id  (required)
     * @return Get tracking by delivery id (status code 200)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "Get tracking by delviery id", nickname = "trackingForDeliveryIdGet", notes = "", response = Tracking.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get tracking by delivery id", response = Tracking.class),
            @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @GetMapping(
            value = "/trackingForDelivery/{id}",
            produces = { "application/json" }
    )
    default ResponseEntity<List<Tracking>> trackingForDeliveryIdGet(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {
        return getDelegate().trackingForDeliveryIdGet(id);
    }

}
