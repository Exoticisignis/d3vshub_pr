package com.example.infrastructure.api.controllers;

import com.example.infrastructure.api.api_def.TrackingApi;
import com.example.infrastructure.api.delegates.TrackingApiDelegate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
@RestController
@RequestMapping("${openapi.delivery.base-path:}")
public class TrackingApiController extends BaseController implements TrackingApi {

    private final TrackingApiDelegate delegate;

    public TrackingApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) TrackingApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new TrackingApiDelegate() {});
    }

    @Override
    public TrackingApiDelegate getDelegate() {
        return delegate;
    }

}
