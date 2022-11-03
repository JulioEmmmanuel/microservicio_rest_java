package com.example.videogames.util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.videogames.model.Game;
import com.example.videogames.services.GameService;

@Component
public class GameFiller {
    private final GameService gameService;

    public GameFiller(GameService gameService){
        this.gameService = gameService;
    }

    @PostConstruct
    public void init(){
        Game game1 = new Game("The Legend of Zelda: Breath of the Wild", "Explora y descubre un mundo lleno de aventuras", "Aventura/acción", "Nintendo");
        gameService.addGame(game1);
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){

        }

        Game game2 = new Game("Hollow knight", "Una aventura clásica en 2D", "Aventura/acción", "Team Cherry");
        gameService.addGame(game2);
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){
            
        }

        Game game3 = new Game("Ghost song", "Descubre secretos debajo de la superficie", "Ciencia ficción/Acción", "Humble games");
        gameService.addGame(game3);
    }
}
