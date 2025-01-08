package com.samod.Event.Manager.controller;

import com.samod.Event.Manager.dto.EventDTO;
import com.samod.Event.Manager.model.Attendee;
import com.samod.Event.Manager.model.Event;
import com.samod.Event.Manager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/get-events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/get-event/{id}")
    public Event getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        if (event == null) {
            throw new IllegalArgumentException("Event not found");
        }
        return event;


    }

    @PostMapping("/create-event")
    public Event createEvent(@RequestBody EventDTO eventDTO) {
        return eventService.createEvent(eventDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

    @PutMapping("/events/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        Event existingEvent = eventService.getEventById(id);
        if (existingEvent == null) {
            throw new IllegalArgumentException("Event not found");
        }

        existingEvent.setName(eventDTO.getName());
        existingEvent.setDescription(eventDTO.getDescription());
        existingEvent.setDate(eventDTO.getDate());
        existingEvent.setLocation(eventDTO.getLocation());
        existingEvent.setCreatedBy(eventDTO.getCreatedBy());
        existingEvent.setCapacity(eventDTO.getCapacity());
        existingEvent.setTags(eventDTO.getTags());

        return eventService.updateEvent(existingEvent);
    }

}

