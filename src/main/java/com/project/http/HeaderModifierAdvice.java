package com.project.http;

import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

@ControllerAdvice
public class HeaderModifierAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(final MethodParameter returnType, final Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(final Object body,
                                  final MethodParameter returnType,
                                  final MediaType selectedContentType,
                                  final Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  final ServerHttpRequest request,
                                  final ServerHttpResponse response) {
        response.getHeaders().add("Access-Control-Expose-Headers", "X-XSRF-TOKEN");
        /*if (response.getHeaders().get("Set-Cookie") != null) {
          String xsrfToken = response.getHeaders().get("Set-Cookie").get(1);
          response.getHeaders().add("XSRF-TOKEN", xsrfToken);
        }*/
        return body;
    }
}