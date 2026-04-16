package com.smartcampus.resource;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.smartcampus.model.Room;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {

    public static Map<String, Room> rooms = new HashMap<>();

    @GET
    public Collection<Room> getRooms() {
        return rooms.values();
    }

    @POST
    public Room createRoom(Room room) {
        rooms.put(room.id, room);
        return room;
    }

    @GET
    @Path("/{id}")
    public Room getRoom(@PathParam("id") String id) {
        return rooms.get(id);
    }
}