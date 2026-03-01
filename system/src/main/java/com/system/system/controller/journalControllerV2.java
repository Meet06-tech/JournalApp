package com.system.system.controller;

import com.system.system.entity.journalEntry;
import com.system.system.repository.journalEntryRepository;
import com.system.system.service.journalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public boolean createEntry(@RequestBody journalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("id/{myid}")
    public journalEntry getJournalEntrybyId(@PathVariable long id){
        return null;
    }

    @DeleteMapping("id/{myid}")
    public journalEntry deleteJournalEntryById(@PathVariable long id){
        return null;
    }

    public journalEntry updateJournalEntryById(@PathVariable Long id,@RequestBody journalEntry journalEntry){
        return null;
    }
}
