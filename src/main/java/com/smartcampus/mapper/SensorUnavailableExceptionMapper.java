package com.smartcampus.mapper;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.smartcampus.exception.SensorUnavailableException;

@Provider
public class SensorUnavailableExceptionMapper implements ExceptionMapper<SensorUnavailableException> {

    @Override
    public Response toResponse(SensorUnavailableException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", 403);
        body.put("message", exception.getMessage());

        return Response.status(403)
                .type(MediaType.APPLICATION_JSON)
                .entity(body)
                .build();
    }
}