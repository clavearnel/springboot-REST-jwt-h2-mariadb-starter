package com.project.security.auth;

import com.project.security.TokenHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class LogoutSuccess implements LogoutSuccessHandler {
	final static Logger logger = LoggerFactory.getLogger(LogoutSuccess.class);

	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
    TokenHelper tokenHelper;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(tokenHelper.AUTH_COOKIE)) {
					logger.info("tokenHelper.AUTH_COOKIE " + tokenHelper.AUTH_COOKIE);
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
					break;
				}
			}
		}

		Map<String, String> result = new HashMap<>();
		result.put("result", "success");

		response.setContentType("application/json");
		response.getWriter().write(objectMapper.writeValueAsString(result));
		response.setStatus(HttpServletResponse.SC_OK);

    }

}