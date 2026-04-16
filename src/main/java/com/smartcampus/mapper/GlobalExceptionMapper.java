package com.smartcampus.mapper;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        if (exception instanceof WebApplicationException) {
            WebApplicationException webException = (WebApplicationException) exception;

            Map<String, Object> body = new HashMap<>();
            body.put("status", webException.getResponse().getStatus());
            body.put("message", exception.getMessage());

            return Response.status(webException.getResponse().getStatus())
                    .type(MediaType.APPLICATION_JSON)
                    .entity(body)
                    .build();
        }

        Map<String, Object> body = new HashMap<>();
        body.put("status", 500);
        body.put("message", "Internal Server Error");

        return Response.status(500)
                .type(MediaType.APPLICATION_JSON)
                .entity(body)
                .build();
    }
}