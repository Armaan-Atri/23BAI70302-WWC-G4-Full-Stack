package com.example.project.controller;
import com.example.project.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.project.model.Event;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    public EventController (EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Event> addEvent(
            @PathVariable int id,
            @RequestBody Event event){

        // Check for duplicate ID
        if (eventService.getEventById(id) != null) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        }

        event.setId(id);
        Event savedEvent = eventService.addEvent(event);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEvent);
    }






}
