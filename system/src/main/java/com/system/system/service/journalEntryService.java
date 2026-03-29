package com.system.system.service;

import com.system.system.entity.journalEntry;
import com.system.system.repository.journalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class journalEntryService {

    @Autowired
    private journalEntryRepository journalEntryRepository;

    public void saveEntry(journalEntry journalEntry) {
        try{
            journalEntry.setDate(LocalDateTime.now());
            journalEntryRepository.save(journalEntry);
        }catch(Exception e){
            System.out.println("Exception !"+e);
        }

    }

    public List<journalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<journalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    public boolean deleteById(ObjectId id) {
        journalEntryRepository.deleteById(id);
        return true;
    }
}
