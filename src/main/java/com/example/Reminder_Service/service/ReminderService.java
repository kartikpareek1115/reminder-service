package com.example.Reminder_Service.service;

import com.example.Reminder_Service.dto.ReminderRequest;
import com.example.Reminder_Service.exception.ReminderNotFoundException;
import com.example.Reminder_Service.model.Reminder;
import com.example.Reminder_Service.model.ReminderStatus;
import com.example.Reminder_Service.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {
    private final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }
//    -----------Before dto-----------------
//    public Reminder create(Reminder reminder){
//        reminder.setId(null); //we are not trusting id sent by the user
//        reminder.setStatus(ReminderStatus.PENDING); // new reminder starting as pending
//        return reminderRepository.save(reminder);
//    }

    //--------create - after dto
    public Reminder create(ReminderRequest request){
        Reminder reminder = new Reminder();
        reminder.setTitle(request.getTitle());
        reminder.setMessage(request.getMessage());
        reminder.setRecipientEmail(request.getRecipientEmail());
        reminder.setDueAt(request.getDueAt());
        //status defaults to PENDING and createdAt is set inside the entity
        return reminderRepository.save(reminder);
    }

    public List<Reminder> getAll(){
        return reminderRepository.findAll();
    }

    public Reminder getById(Long id){
        return reminderRepository.findById(id)
                .orElseThrow(() -> new ReminderNotFoundException(id));
    }
//------------update - before dto
//    public Reminder update(Long id, Reminder updated){
//        Reminder existing = getById(id);
//        existing.setTitle(updated.getTitle());
//        existing.setMessage(updated.getMessage());
//        existing.setRecipientEmail(updated.getRecipientEmail());
//        existing.setDueAt(updated.getDueAt());
//        return reminderRepository.save(existing);
//    }

    // update -- after dto
    public Reminder update(Long id, ReminderRequest request){
        Reminder existing = getById(id);
        existing.setTitle(request.getTitle());
        existing.setMessage(request.getMessage());
        existing.setRecipientEmail(request.getRecipientEmail());
        existing.setDueAt(request.getDueAt());
        return reminderRepository.save(existing);
    }

    public Reminder cancel(Long id){
        Reminder existing = getById(id);
        existing.setStatus(ReminderStatus.CANCELLED);
        return reminderRepository.save(existing);
    }

    public void delete(Long id){
        Reminder existing = getById(id);
        reminderRepository.delete(existing);
    }
}
