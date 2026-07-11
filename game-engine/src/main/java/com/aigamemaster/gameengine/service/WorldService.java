package com.aigamemaster.gameengine.service;
import com.aigamemaster.gameengine.entity.World;
import com.aigamemaster.gameengine.repository.WorldRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class WorldService {
    private final WorldRepository worldRepository;
    public WorldService(WorldRepository worldRepository){
        this.worldRepository = worldRepository;
    }
    public World createWorld(String theme, String magicLevel){
        World world = new World();
        world.setWorldName("World-" + Integer.toHexString(new Random().nextInt()).toUpperCase());
        world.setSeed(Math.abs(new Random().nextLong()));
        world.setTheme(theme);
        world.setMagicLevel(magicLevel);
        world.setWorldStatus("ACTIVE");
        world.setCreatedAt(LocalDateTime.now());
        return worldRepository.save(world);
    }
}
