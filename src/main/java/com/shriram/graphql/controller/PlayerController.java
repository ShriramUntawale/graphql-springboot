package com.shriram.graphql.controller;

import com.shriram.graphql.model.Player;
import com.shriram.graphql.model.Team;
import com.shriram.graphql.service.PlayerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @SchemaMapping(typeName = "Query", value = "getAllPlayers1") // Mapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @QueryMapping
    public Player getPlayerById(@Argument Integer id) {
        return playerService.getPlayerById(id);
    }
    @QueryMapping
    public List<Player> getPlayersByTeam(@Argument Team team) {
        return playerService.getPlayersByTeam(team);
    }

    @MutationMapping
    public Player addPlayer(@Argument String name, @Argument Team team) {
        return playerService.addPlayer(name, team);
    }

    @MutationMapping
    public void deletePlayer(@Argument Integer id) {
        playerService.deletePlayer(id);
    }
}