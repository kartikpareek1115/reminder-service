package com.example.Reminder_Service.repository;

import com.example.Reminder_Service.model.Reminder;
import com.example.Reminder_Service.model.ReminderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface ReminderRepository extends JpaRepository<Reminder,Long> {
    List<Reminder> findByStatus(ReminderStatus status);
    List<Reminder> findByStatusAndDueAtLessThanEqual(ReminderStatus status, LocalDateTime time);
}
//The two extra methods are derived queries. Spring reads the method name and writes the SQL itself:
//findByStatus becomes WHERE status = ?
//findByStatusAndDueAtLessThanEqual becomes WHERE status = ? AND due_at <= ?