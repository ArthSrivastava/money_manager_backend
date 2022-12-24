package com.thesnoozingturtle.moneymanagerrestapi.config.security.jwtutil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thesnoozingturtle.moneymanagerrestapi.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    //to show error if unauthorized person tries to access
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        System.out.println("\n\n\n\n HELLO INSIDE COMMENCE! \n\n\n");
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
        ApiResponse apiResponse = new ApiResponse(authException.getMessage(), false);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.getWriter().write(convertObjectToJson(apiResponse));
    }

    private String convertObjectToJson(ApiResponse apiResponse) throws JsonProcessingException {
        if (apiResponse == null) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(apiResponse);
    }
}