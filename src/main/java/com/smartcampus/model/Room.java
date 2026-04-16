package com.smartcampus.model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    public String id;
    public String name;
    public int capacity;
    public List<String> sensorIds = new ArrayList<>();
}