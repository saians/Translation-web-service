package com.some.task.demorecordmanagement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Record {

    @Id
    String id;
    String languageKey;
    String text;
    String textMeaning;


    public Record() {
    }

    public Record(String languageKey, String text, String textMeaning) {
        this.languageKey = languageKey;
        this.text = text;
        this.textMeaning = textMeaning;
    }

    public void setLanguageKey(String languageKey) {
        this.languageKey = languageKey;
    }
    public String getId() {
        return this.languageKey;
    }
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextMeaning() {
        return this.textMeaning;
    }

    public void setTextMeaning(String textMeaning) {
        this.textMeaning = textMeaning;
    }


    @Override
    public String toString() {
        return "Language Key: "+languageKey+" Text: "+text+"Text Meaning: "+textMeaning;
    }

}
