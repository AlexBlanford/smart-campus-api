package com.smartcampus.mapper;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.smartcampus.exception.RoomNotEmptyException;

@Provider
public class RoomNotEmptyExceptionMapper implements ExceptionMapper<RoomNotEmptyException> {

    @Override
    public Response toResponse(RoomNotEmptyException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", 409);
        body.put("message", exception.getMessage());

        return Response.status(409)
                .type(MediaType.APPLICATION_JSON)
                .entity(body)
                .build();
    }
}