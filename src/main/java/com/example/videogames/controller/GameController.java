package com.example.videogames.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.videogames.model.Game;

import com.example.videogames.services.GameService;

@RestController
@RequestMapping({"game"})
public class GameController {
    private final GameService gameservice;

    public GameController(GameService gameService){
        this.gameservice = gameService;
    }

    @GetMapping("")
    public List<Game> getAll(){
        return gameservice.getAll();
    }

    @GetMapping("/{gameId}")
    public Game get(@PathVariable String gameId){
        return gameservice.get(gameId);
    }

    @GetMapping("/titles")
    public Game getByTitle(@RequestParam String title){
        return gameservice.getByTitle(title);
    }

    @PostMapping("")
    public Game addGame(@RequestBody Game game){
        return gameservice.addGame(game);
    }

    @PutMapping("/{gameId}")
    public Game updateGame(@PathVariable String gameId, @RequestBody Game game){
        return gameservice.updateGame(gameId, game);
    }

    @DeleteMapping("/{gameId}")
    public Game detleteGame(@PathVariable String gameId){
        return gameservice.deleteGame(gameId);
    }
}
