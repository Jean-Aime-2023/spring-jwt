package com.spring.jwt.backend.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.*;

import com.spring.jwt.backend.dto.ErrorDto;

@RequiredArgsConstructor
public class JwtAuthFilter implements OnceRequestFilter{

    private UserAuthProvider userAuthProvider;

    @Override
    protected void doFilterInternal(
        HttpServletRequest request, 
        HttpServletResponse response,
        FilterChain filterChain) throws IOException, ServletException {
   String header = request.getHeader(HttpHeaders.AUTHORIZATION);

   if(header != null){
    String[] elements = header.split(" ");

    if(elements.length == 2 && "Bearer".equals(elements[0])){
        try{
            SecurityContextHolder.getContext().setAuthentication(
                userAuthProvider.validateToken(elements[1])
            );
        }catch(RuntimeException e){
            SecurityContextHolder.clearContext();
            throw e;
        }
    }
   }
   filterChain.doFilter(request, response);
}
}