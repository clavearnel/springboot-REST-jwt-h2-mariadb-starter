/*
 * Copyright 2014 Allan Ditzel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.project.http;

import static org.springframework.http.HttpHeaders.SET_COOKIE;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Binds a {@link org.springframework.security.web.csrf.CsrfToken} to the {@link HttpServletResponse}
 * headers if the Spring {@link org.springframework.security.web.csrf.CsrfFilter} has placed one in the {@link HttpServletRequest}.
 *
 * Based on the work found in: <a href="http://stackoverflow.com/questions/20862299/with-spring-security-3-2-0-release-how-can-i-get-the-csrf-token-in-a-page-that">Stack Overflow</a>
 *
 * @author Allan Ditzel
 * @since 1.0
 */
public class CsrfTokenResponseHeaderBindingFilter extends OncePerRequestFilter {
    protected static final String RESPONSE_COOKIE_NAME = "XSRF-TOKEN";
    protected static final String RESPONSE_TOKEN_NAME = "X-XSRF-TOKEN";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, javax.servlet.FilterChain filterChain) throws ServletException, IOException {
        //CsrfToken token = (CsrfToken) request.getAttribute(REQUEST_ATTRIBUTE_NAME);
        String token = null;
        for (String cookieVal : response.getHeaders(SET_COOKIE)) {
            if (cookieVal.contains(RESPONSE_COOKIE_NAME)) {
                String[] rawCookieParams = cookieVal.split(";");
                for (String cookieParam : rawCookieParams) {
                    int len = cookieParam.trim().split("=").length;
                    if (cookieParam.contains(RESPONSE_COOKIE_NAME) && len == 2 && !StringUtils.isEmpty(cookieParam.trim().split("=")[1])) {
                        token = cookieParam.trim().split("=")[1];
                    }
                }
            }
        }

        final String reqUrl = request.getRequestURL().toString();
        System.out.println(reqUrl);

        if (reqUrl.contains("images")) {
            response.setHeader(SET_COOKIE, "");
        } else {

            if (token != null) {
                response.setHeader(RESPONSE_TOKEN_NAME , token);
            }
        }

        filterChain.doFilter(request, response);
    }
}