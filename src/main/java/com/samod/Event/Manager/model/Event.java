package com.samod.Event.Manager.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDate date;
    private String location;
    private String createdBy;
    private int capacity;
    private int remainingCapacity;

    @ElementCollection
    private List<String> tags;

}




