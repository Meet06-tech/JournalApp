package com.system.system.controller;

import com.system.system.entity.journalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system")
public class journalControllerV2 {


    @GetMapping
    public List<journalEntry> getALl(){
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody journalEntry journalEntry){
        return true;
    }

    @GetMapping("id/{myid")
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
