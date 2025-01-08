package com.samod.Event.Manager.controller;

import com.samod.Event.Manager.exception.ResourceNotFoundException;
import com.samod.Event.Manager.model.Attendee;
import com.samod.Event.Manager.repository.AttendeeRepository;
import com.samod.Event.Manager.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {

    @Autowired
    private AttendeeService attendeeService;

    @Autowired
    private AttendeeRepository attendeeRepository;

    @PostMapping("/{eventId}")
    public Attendee registerAttendee(@PathVariable Long eventId, @RequestBody Attendee attendee) {
        return attendeeService.registerAttendee(eventId, attendee);
    }

    @GetMapping("/{eventId}")
    public List<Attendee> getAttendees(@PathVariable Long eventId) {
        List<Attendee> attendees = attendeeRepository.findByEventId(eventId);

        if (attendees.isEmpty()) {
            return new ArrayList<>();
        }

        return attendees;
    }


}

