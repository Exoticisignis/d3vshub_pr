package com.example.infrastructure.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
@RestController
@RequestMapping("${openapi.delivery.base-path:}")
public class ItemsApiController extends BaseController implements ItemsApi {

    private final ItemsApiDelegate delegate;

    public ItemsApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) ItemsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ItemsApiDelegate() {});
    }

    @Override
    public ItemsApiDelegate getDelegate() {
        return delegate;
    }

}
