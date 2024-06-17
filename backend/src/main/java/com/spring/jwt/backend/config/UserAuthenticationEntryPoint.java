package com.spring.jwt.backend.config;

import java.io.IOException;

import javax.naming.AuthenticationException;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.jwt.backend.dto.ErrorDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {
private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


@Override
public void commence(HttpServletRequest request, HttpServletResponse response,
        org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.setHeader(HttpHeaders.CONTENT_TYPE, org.springframework.http.MediaType.APPLICATION_JSON_VALUE);
    OBJECT_MAPPER.writeValue(response.getOutputStream(), new ErrorDto("Unauthorized Path"));
}
}
