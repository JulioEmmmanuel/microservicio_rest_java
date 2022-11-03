package com.example.videogames.repository;

import java.util.List;

import com.example.videogames.model.Game;

public interface IGameRepository {
    public List<Game> getAll();
    public Game get(String gameId);
    public Game getByTitle(String gameTitle);
    public Game save(Game game);
    public Game delete(String gameId);
}
