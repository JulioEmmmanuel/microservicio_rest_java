package com.example.videogames.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Game {
    private String gameId;
    private String title;
    private String description;
    private String genre;
    private String publisher;
    
    public Game(String title, String description, String genre, String publisher) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.publisher = publisher;
    }

    
}
