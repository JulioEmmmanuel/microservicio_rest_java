package com.example.videogames.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.videogames.model.Game;
import com.example.videogames.repository.IGameRepository;

@Service
public class GameService {

    private final IGameRepository gameRepository;

    public GameService(IGameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public List<Game> getAll(){
        return gameRepository.getAll();
    }

    public Game get(String gameId){
        return gameRepository.get(gameId);
    }

    public Game getByTitle(String gameTitle){
        return gameRepository.getByTitle(gameTitle);
    }

    public Game addGame(Game game){
        game.setGameId(null);
        return gameRepository.save(game);
    }

    public Game updateGame(String gameId, Game game){
        Game gameR = gameRepository.get(gameId);
        if(gameR == null){
            return null;
        }
        game.setGameId(gameId);
        return gameRepository.save(game);
    }

    public Game deleteGame(String gameId){
        return gameRepository.delete(gameId);
    }
}
