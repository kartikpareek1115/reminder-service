package com.example.Reminder_Service.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class ReminderRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @Size(max = 1000, message = "Message must be at most 1000 characters")
    private String message;

    @NotBlank(message = "Recipient email is required")
    @Email(message = "Recipient email is not a valid email address")
    private String recipientEmail;

    @NotNull(message = "Due date and time is required")
    @Future(message = "Due date and time must be in the future")
    private LocalDateTime dueAt;

    public ReminderRequest(){

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public void setDueAt(LocalDateTime dueAt) {
        this.dueAt = dueAt;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public LocalDateTime getDueAt() {
        return dueAt;
    }
}
