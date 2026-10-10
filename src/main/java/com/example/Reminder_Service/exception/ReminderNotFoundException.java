package com.example.Reminder_Service.exception;

public class ReminderNotFoundException extends RuntimeException{
    public ReminderNotFoundException(Long id){
        super("Reminder not found with id "+ id);
    }
}
