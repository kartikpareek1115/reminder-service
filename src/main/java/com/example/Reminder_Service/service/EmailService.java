package com.example.Reminder_Service.service;

import com.example.Reminder_Service.model.Reminder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;


    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendReminderEmail(Reminder reminder){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(reminder.getRecipientEmail());
        mail.setSubject("Reminder: " + reminder.getTitle());
        mail.setText(
                "Hi,\n\n"
                + reminder.getTitle() + "\n"
                + (reminder.getMessage() == null ? "" : reminder.getMessage() + "\n")
                + "\nSent by Reminder Service"

        );
        mailSender.send(mail);
    }
}
