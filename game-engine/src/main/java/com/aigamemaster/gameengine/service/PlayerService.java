package com.aigamemaster.gameengine.service;

import com.aigamemaster.gameengine.dto.PlayerDTO;
import com.aigamemaster.gameengine.entity.Player;
import com.aigamemaster.gameengine.repository.PlayerRepository;
import com.aigamemaster.gameengine.repository.WorldRepository;
import com.aigamemaster.gameengine.entity.World;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final WorldRepository worldRepository;

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository,
                         WorldRepository worldRepository) {
        this.playerRepository = playerRepository;
        this.worldRepository = worldRepository;
    }

    public Player createPlayer(PlayerDTO playerDTO) {

        Player player = new Player();

        player.setPlayerName(playerDTO.getPlayerName());
        player.setPlayerClass(playerDTO.getPlayerClass());

        // Default Game Values
        player.setLevel(1);
        player.setExperience(0);
        player.setHealth(100);
        player.setMana(50);
        player.setGold(100);
        World world = worldRepository.findById(playerDTO.getWorldId())
                .orElseThrow(() -> new NoSuchElementException("World not found"));
        player.setCurrentWorld(world);
        return playerRepository.save(player);
    }
}