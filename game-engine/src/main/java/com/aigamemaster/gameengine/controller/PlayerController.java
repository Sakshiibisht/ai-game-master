package com.aigamemaster.gameengine.controller;

import com.aigamemaster.gameengine.dto.PlayerDTO;
import com.aigamemaster.gameengine.entity.Player;
import com.aigamemaster.gameengine.service.PlayerService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Player createPlayer(@RequestBody @Valid PlayerDTO playerDTO) {
        return playerService.createPlayer(playerDTO);
    }
}