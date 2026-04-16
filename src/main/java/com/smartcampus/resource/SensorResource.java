package com.smartcampus.resource;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.smartcampus.model.Sensor;

@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {

    public static Map<String, Sensor> sensors = new HashMap<>();

    // CREATE sensor
    @POST
    public Sensor createSensor(Sensor sensor) {

        // VALIDATION: check room exists
        if (!RoomResource.rooms.containsKey(sensor.roomId)) {
            throw new RuntimeException("Room does not exist");
        }

        sensors.put(sensor.id, sensor);

        // LINK sensor to room
        RoomResource.rooms.get(sensor.roomId).sensorIds.add(sensor.id);

        return sensor;
    }

    // GET sensors (with optional filter)
    @GET
    public Collection<Sensor> getSensors(@QueryParam("type") String type) {

        if (type == null) {
            return sensors.values();
        }

        return sensors.values().stream()
                .filter(s -> s.type.equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}