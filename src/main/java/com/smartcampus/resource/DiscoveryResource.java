package com.smartcampus.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class DiscoveryResource {

    @GET
    public Map<String, Object> getInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("version", "v1");
        info.put("rooms", "/api/v1/rooms");
        info.put("sensors", "/api/v1/sensors");
        return info;
    }
}