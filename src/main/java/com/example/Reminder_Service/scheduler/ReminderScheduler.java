package com.example.Reminder_Service.scheduler;

import com.example.Reminder_Service.model.Reminder;
import com.example.Reminder_Service.model.ReminderStatus;
import com.example.Reminder_Service.repository.ReminderRepository;
import com.example.Reminder_Service.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReminderScheduler {

    private static final Logger log = LoggerFactory.getLogger(ReminderScheduler.class);

    private final ReminderRepository reminderRepository;
    private final EmailService emailService;

    public ReminderScheduler(ReminderRepository reminderRepository, EmailService emailService) {
        this.reminderRepository = reminderRepository;
        this.emailService = emailService;
    }

    //Runs 1 minutes after the previous run  finishes (10 s is for testing)
    @Scheduled(fixedDelay = 60000)
    public void processDueReminders() {
        List<Reminder> dueReminders = reminderRepository
                .findByStatusAndDueAtLessThanEqual(ReminderStatus.PENDING, LocalDateTime.now());


        for (Reminder reminder : dueReminders) {
            try {
                emailService.sendReminderEmail(reminder);
                reminder.setStatus(ReminderStatus.SENT);
                reminderRepository.save(reminder);
                log.info("Reminder '{}' sent to {}", reminder.getTitle(), reminder.getRecipientEmail());
            } catch (Exception e) {
                log.error("Failed to send reminder id {}: {}", reminder.getId(), e.getMessage());
            }
        }
    }
}
