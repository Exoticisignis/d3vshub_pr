package com.example.infrastructure.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
@Controller
@RequestMapping("${openapi.delivery.base-path:}")
public class ItemsForOrderApiController implements ItemsForOrderApi {

    private final ItemsForOrderApiDelegate delegate;

    public ItemsForOrderApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) ItemsForOrderApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ItemsForOrderApiDelegate() {});
    }

    @Override
    public ItemsForOrderApiDelegate getDelegate() {
        return delegate;
    }

}
