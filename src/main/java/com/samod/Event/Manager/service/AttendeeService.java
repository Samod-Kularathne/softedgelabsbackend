package com.samod.Event.Manager.service;

import com.samod.Event.Manager.exception.ResourceNotFoundException;
import com.samod.Event.Manager.exception.ValidationException;
import com.samod.Event.Manager.model.Attendee;
import com.samod.Event.Manager.model.Event;
import com.samod.Event.Manager.repository.AttendeeRepository;
import com.samod.Event.Manager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    @Autowired
    private EventRepository eventRepository;

    public Attendee registerAttendee(Long eventId, Attendee attendee) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        if (event.getRemainingCapacity() > 0) {
            attendee.setEventId(eventId);
            attendeeRepository.save(attendee);

            event.setRemainingCapacity(event.getRemainingCapacity() - 1);
            eventRepository.save(event);

            return attendee;
        } else {
            throw new ValidationException("Event is full");
        }
    }


    public List<Attendee> getAttendeesByEventId(Long eventId) {
        return attendeeRepository.findByEventId(eventId);
    }
}


