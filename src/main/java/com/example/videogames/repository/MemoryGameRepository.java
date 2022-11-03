package com.example.videogames.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import com.example.videogames.model.Game;

@Repository
public class MemoryGameRepository implements IGameRepository {

    private Map<String, Game> gamesMap;

    MemoryGameRepository(){
        gamesMap = new HashMap<>();
    }

    @Override
    public List<Game> getAll() {
        List<Game> list = new ArrayList<>();
        list.addAll(gamesMap.values());
        return list;
    }

    @Override
    public Game get(String gameId) {
        if(gamesMap.containsKey(gameId)){
            return gamesMap.get(gameId);
        }
        return null;
    }

    @Override
    public Game getByTitle(String gameTitle) {
        for(Entry<String, Game> entry: gamesMap.entrySet()){
            if(entry.getValue().getTitle().equals(gameTitle)){
                return gamesMap.get(entry.getKey());
            }
        }
        return null;
    }

    @Override
    public Game save(Game game) {
        if(game.getGameId() == null){
            game.setGameId(String.valueOf(System.currentTimeMillis()));
        }
        return gamesMap.put(game.getGameId(), game);
    }

    @Override
    public Game delete(String gameId) {
        if(gamesMap.containsKey(gameId)){
            return gamesMap.remove(gameId);
        }
        return null;
    }
    
}