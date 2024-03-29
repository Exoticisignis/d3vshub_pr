package com.example.infrastructure.api.controllers;

import com.example.infrastructure.api.api_def.DeliveriesApi;
import com.example.infrastructure.api.delegates.DeliveriesApiDelegate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
@RestController
@RequestMapping("${openapi.delivery.base-path:}")
public class DeliveriesApiController extends BaseController implements DeliveriesApi {

    private final DeliveriesApiDelegate delegate;

    public DeliveriesApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) DeliveriesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new DeliveriesApiDelegate() {});
    }

    @Override
    public DeliveriesApiDelegate getDelegate() {
        return delegate;
    }

}
