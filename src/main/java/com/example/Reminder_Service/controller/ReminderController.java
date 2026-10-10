package com.example.Reminder_Service.controller;

import com.example.Reminder_Service.dto.ReminderRequest;
import com.example.Reminder_Service.model.Reminder;
import com.example.Reminder_Service.service.ReminderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.*;

import java.util.List;

@Tag(name = "Reminders", description = "Create, view, update and cancel reminders")
@RestController
@RequestMapping("/api/reminders")
public class ReminderController {
    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService){
        this.reminderService = reminderService;
    }

    // @Operation -- annotations used for adding text after api on swagger UI for better understanding
    @Operation(summary = "Create a reminder", description = "dueAt must be in the future, e.g. 2026-10-12T18:18:00:00")
    @PostMapping
    public ResponseEntity<Reminder> create(@Valid  @RequestBody ReminderRequest request){
        Reminder saved = reminderService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Operation(summary = "get the list of all reminders" )
    @GetMapping
    public List<Reminder> getAll(){
        return reminderService.getAll();
    }

    @Operation(summary = "get the reminder by id")
    @GetMapping("/{id}")
    public Reminder getById(@PathVariable Long id){
        return reminderService.getById(id);
    }

    @Operation(summary = "update the reminder by id")
    @PutMapping("/{id}")
    public Reminder update(@PathVariable Long id, @Valid @RequestBody ReminderRequest request){
        return reminderService.update(id,request);
    }

    @Operation(summary = "cancel any reminder by id")
    @PatchMapping("/{id}/cancel")
    public Reminder cancel(@PathVariable Long id){
        return reminderService.cancel(id);
    }

    @Operation(summary = "delete any reminder by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reminderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
