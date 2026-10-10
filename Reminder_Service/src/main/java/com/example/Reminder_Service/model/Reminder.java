package com.example.Reminder_Service.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="reminder")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String message;

    @Column(nullable = false)
    private String recipientEmail;

    @Column(nullable = false)
    private LocalDateTime dueAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReminderStatus status = ReminderStatus.PENDING;
    //@Enumerated(EnumType.STRING) stores "PENDING" as text. Without it, Hibernate stores 0, 1, 2, and reordering the enum later would silently corrupt the data.

    private LocalDateTime createdAt = LocalDateTime.now();

    //JPA requires a no-argument constructor
    public Reminder(){

    }

    public Long getId() {
        return id;
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

    public ReminderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setStatus(ReminderStatus status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
