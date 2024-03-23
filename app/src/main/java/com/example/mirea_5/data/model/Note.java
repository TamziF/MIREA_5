package com.example.mirea_5.data.model;

import java.util.UUID;

public class Note {
    public String title;
    public String content;
    public String id = UUID.randomUUID().toString();

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
