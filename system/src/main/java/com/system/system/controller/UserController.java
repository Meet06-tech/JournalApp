package com.system.system.controller;

import com.system.system.entity.journalEntry;
import com.system.system.service.journalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/system")
public class UserController {


    @Autowired
    private journalEntryService journalEntryService;

    @GetMapping("/get")
    public List<journalEntry> getALl(){
        return journalEntryService.getAll();
    }

    @PostMapping("/send")
    public journalEntry createEntry(@RequestBody journalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myid}")
    public Optional<journalEntry> getJournalEntrybyId(@PathVariable ObjectId id){
        return journalEntryService.findById(id);
    }

    @DeleteMapping("id/{myid}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId id){
        journalEntryService.deleteById(id);
        return true;
    }

    @PutMapping("id/{myid}")
    public journalEntry updateJournalEntryById(@PathVariable ObjectId  id,@RequestBody journalEntry newEntry){
        journalEntry old = journalEntryService.findById(id).orElse(null);

        if(old == null){
            return null;
        }
        if(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty()){
            old.setTitle(newEntry.getTitle());
        }
        if(newEntry.getContent() != null && !newEntry.getContent().isEmpty()){
            old.setContent(newEntry.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }
}
