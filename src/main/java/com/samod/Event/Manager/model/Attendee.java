package com.samod.Event.Manager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Long eventId;

}
