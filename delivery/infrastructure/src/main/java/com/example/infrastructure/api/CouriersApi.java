/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.infrastructure.api;

import com.example.infrastructure.api.errors.UserExistsException;
import com.example.infrastructure.models.CourierDTO;
import com.example.infrastructure.models.Error;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
@Validated
@Api(value = "couriers", description = "the couriers API")
@PreAuthorize("hasRole('ADMIN')")
public interface CouriersApi {

    default CouriersApiDelegate getDelegate() {
        return new CouriersApiDelegate() {};
    }

    @GetMapping("/temp")
    default ResponseEntity<String> temp(){
        return getDelegate().temp();
    }

    /**
     * GET /couriers : List all couriers
     *
     * @param limit  (optional)
     * @return A list of couriers. (status code 200)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "List all couriers", nickname = "couriersGet", notes = "", response = CourierDTO.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of couriers.", response = CourierDTO.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @GetMapping(
        value = "/couriers",
        produces = { "application/json" }
    )
    default ResponseEntity<List<CourierDTO>> couriersGet(@ApiParam(value = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        return getDelegate().couriersGet(limit);
    }


    /**
     * DELETE /couriers/{id} : Delete courier by id
     *
     * @param id  (required)
     * @return Deleted (status code 204)
     *         or Id not found (status code 404)
     */
    @ApiOperation(value = "Delete courier by id", nickname = "couriersIdDelete", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 404, message = "Id not found") })
    @DeleteMapping(
        value = "/couriers/{id}"
    )
    default ResponseEntity<String> couriersIdDelete(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {
        return getDelegate().couriersIdDelete(id);
    }


    /**
     * GET /couriers/{id} : Get courier by id
     *
     * @param id  (required)
     * @return Get courier by id (status code 200)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "Get courier by id", nickname = "couriersIdGet", notes = "", response = CourierDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Get courier by id", response = CourierDTO.class),
        @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @GetMapping(
        value = "/couriers/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<CourierDTO> couriersIdGet(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {
        return getDelegate().couriersIdGet(id);
    }


    /**
     * POST /couriers : Create a courier
     *
     * @return Null response (status code 201)
     *         or unexpected error (status code 400)
     */
    @ApiOperation(value = "Create a courier", nickname = "couriersPost", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Null response"),
        @ApiResponse(code = 400, message = "unexpected error", response = Error.class) })
    @PostMapping(
        value = "/couriers",
        produces = { "application/json" }
    )
    default ResponseEntity<String> couriersPost(@RequestBody CourierDTO courier) throws UserExistsException {
        return getDelegate().couriersPost(courier);
    }

}
