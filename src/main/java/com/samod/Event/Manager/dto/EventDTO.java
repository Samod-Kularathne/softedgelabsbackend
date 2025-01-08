package com.samod.Event.Manager.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EventDTO {
    private String name;
    private String description;
    private LocalDate date;
    private String location;
    private String createdBy;
    private int capacity;
    private List<String> tags;
}

