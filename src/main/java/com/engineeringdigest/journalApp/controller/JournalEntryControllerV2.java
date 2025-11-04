package com.engineeringdigest.journalApp.controller;

import com.engineeringdigest.journalApp.entity.JournalEntry;
import com.engineeringdigest.journalApp.service.JournalEntryServices;
import com.sun.jdi.LocalVariable;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    JournalEntryServices journalEntryServices;

    @GetMapping()
    public List<JournalEntry> getAll() {
        return journalEntryServices.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryServices.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable ObjectId myId) {
        return journalEntryServices.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable ObjectId myId) {
        journalEntryServices.deleteById(myId);
        return true;
    }

    @PutMapping
    public JournalEntry updateEntry(@RequestBody JournalEntry entry) {
        return null;
    }
    @PutMapping("id/{id}")
    public JournalEntry updateEntry(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryServices.findById(id).orElse(null);
        if(old != null && newEntry != null){
            old.setTitle(newEntry.getTitle() != null ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null ? newEntry.getContent() : old.getContent());
        }
        journalEntryServices.saveEntry(old);
        return old;
    }
}
