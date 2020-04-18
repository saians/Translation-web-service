package com.some.task.demorecordmanagement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RecordController
 */
@RestController
@RequestMapping("/api")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping("/create")
    public String create(@RequestParam String languageKey, @RequestParam String text,
            @RequestParam String textMeaning) {

        Record r = recordService.createRecord(languageKey, text, textMeaning);
        return r.toString();

    }

    @GetMapping("/getRecord")
    public Optional<Record> get(@RequestParam String languageKey, @RequestParam String text) {
        return recordService.getRecord(languageKey, text);
    }

    @PutMapping("/put")
    public Record put(@RequestParam String languageKey, @RequestParam String text, @RequestParam String textMeaning) {
        return recordService.updateRecord(languageKey, text, textMeaning);
    }
}