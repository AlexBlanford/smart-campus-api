package com.smartcampus.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.smartcampus.model.Sensor;
import com.smartcampus.model.SensorReading;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorReadingResource {

    private String sensorId;

    // store readings per sensor
    public static Map<String, List<SensorReading>> readings = new HashMap<>();

    public SensorReadingResource(String sensorId) {
        this.sensorId = sensorId;
    }

    // GET readings
    @GET
    public List<SensorReading> getReadings() {
        return readings.getOrDefault(sensorId, new ArrayList<>());
    }

    // POST new reading
    @POST
    public SensorReading addReading(SensorReading reading) {

        readings.putIfAbsent(sensorId, new ArrayList<>());
        readings.get(sensorId).add(reading);

        // update sensor current value
        Sensor sensor = SensorResource.sensors.get(sensorId);
        if (sensor != null) {
            sensor.currentValue = reading.value;
        }

        return reading;
    }
}