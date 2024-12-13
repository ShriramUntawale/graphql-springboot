package com.shriram.graphql.service;

import com.shriram.graphql.exception.PlayerNotFoundException;
import com.shriram.graphql.model.Player;
import com.shriram.graphql.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class PlayerService {
    private List<Player> playerList = new ArrayList<>();
    AtomicInteger id = new AtomicInteger(0);

    @PostConstruct
    public void init() {
        playerList.add(new Player(id.incrementAndGet(), "Sachin", Team.MI));
        playerList.add(new Player(id.incrementAndGet(), "Dhoni", Team.CSK));
        playerList.add(new Player(id.incrementAndGet(), "Kohli", Team.RCB));
        playerList.add(new Player(id.incrementAndGet(), "Rohit", Team.MI));
        playerList.add(new Player(id.incrementAndGet(), "Kedar", Team.PBKS));
    }

    public Player addPlayer(String name, Team team) {
        Player player = new Player(id.incrementAndGet(), name, team);
        playerList.add(player);
        return player;
    }

    public List<Player> getAllPlayers() {
        return playerList;
    }

    public List<Player> getPlayersByTeam(Team team) {
        return playerList.stream().filter(p -> p.team().equals(team)).toList();
    }
    public Player getPlayerById(Integer id) {
        return playerList.stream().filter(p -> p.id().equals(id)).findFirst().orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + id));
    }

    public void deletePlayer(Integer id) {
        playerList.removeIf(p -> p.id().equals(id));
    }
}