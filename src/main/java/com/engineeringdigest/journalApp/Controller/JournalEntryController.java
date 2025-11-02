package com.engineeringdigest.journalApp.Controller;

import com.engineeringdigest.journalApp.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    @GetMapping()
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry){
        journalEntries.put(entry.getId(), entry);
        return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteEntryById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }
    @PutMapping
    public JournalEntry updateEntry(@RequestBody JournalEntry entry){
        journalEntries.put(entry.getId(), entry);
        return entry;
    }
}
