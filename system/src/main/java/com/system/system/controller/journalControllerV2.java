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
public class journalControllerV2 {


    @Autowired
    private journalEntryService journalEntryService;

    @GetMapping
    public List<journalEntry> getALl(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public journalEntry createEntry(@RequestBody journalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myid}")
    public Optional<journalEntry> getJournalEntrybyId(@PathVariable ObjectId id){
        return Optional.ofNullable(journalEntryService.findById(id).orElse(null));
    }

    @DeleteMapping("id/{myid}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId id){
        journalEntryService.deleteById(id);
        return true;
    }

    public journalEntry updateJournalEntryById(@PathVariable ObjectId  id,@RequestBody journalEntry myEntry){
        Optional<journalEntry> journalEntry = journalEntryService.findById(id);
        if(journalEntry != null){

        }
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }
}
