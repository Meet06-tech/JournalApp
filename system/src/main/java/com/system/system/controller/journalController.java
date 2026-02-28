package com.system.system.controller;

import com.system.system.entity.journalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_system")
public class journalController {

    private Map<Long,journalEntry> journalEntries = new HashMap<>();


    @GetMapping
    public List<journalEntry> getALl(){

        return  new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody journalEntry journalEntry){

        journalEntries.put(journalEntry.getId(),journalEntry);
        return true;
    }

    @GetMapping("id/{myid")
    public journalEntry getJournalEntrybyId(@PathVariable long id){
        return journalEntries.get(id);
    }

    @DeleteMapping("id/{myid}")
    public journalEntry deleteJournalEntryById(@PathVariable long id){
        return journalEntries.remove(id);
    }

    public journalEntry updateJournalEntryById(@PathVariable Long id,@RequestBody journalEntry journalEntry){
        return journalEntries.put(id,journalEntry);
    }
}
