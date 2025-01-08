package com.samod.Event.Manager.service;

import com.samod.Event.Manager.dto.EventDTO;
import com.samod.Event.Manager.exception.ResourceNotFoundException;
import com.samod.Event.Manager.model.Attendee;
import com.samod.Event.Manager.model.Event;
import com.samod.Event.Manager.repository.AttendeeRepository;
import com.samod.Event.Manager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private AttendeeRepository attendeeRepository;
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }




    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    public Event createEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setDate(eventDTO.getDate());
        event.setLocation(eventDTO.getLocation());
        event.setCreatedBy(eventDTO.getCreatedBy());
        event.setCapacity(eventDTO.getCapacity());
        event.setRemainingCapacity(eventDTO.getCapacity());
        event.setTags(eventDTO.getTags());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }

    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

}
