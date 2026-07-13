package com.aigamemaster.gameengine.service;
import com.aigamemaster.gameengine.entity.World;
import com.aigamemaster.gameengine.generator.WorldGenerator;
import com.aigamemaster.gameengine.repository.WorldRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class WorldService {
    private final WorldRepository worldRepository;
    private final WorldGenerator worldGenerator;
    public WorldService(WorldRepository worldRepository, WorldGenerator worldGenerator){
        this.worldRepository = worldRepository;
        this.worldGenerator = worldGenerator;
    }
    public World createWorld(String theme, String magicLevel){
        World world = new World();
        world.setWorldName("World-" + Integer.toHexString(new Random().nextInt()).toUpperCase());
        world.setSeed(Math.abs(new Random().nextLong()));
        world.setTheme(theme);
        world.setMagicLevel(magicLevel);
//        world.setContinentName(generateContinentName());
//        world.setStartingBiome(generateBiome(theme));
//        world.setClimate(generateClimate());
//        world.setKingdomCount(generateKingdomCount());
//        world.setWorldDescription(generateWorldDescription(theme));
        world.setWorldStatus("ACTIVE");
        world.setCreatedAt(LocalDateTime.now());
        worldGenerator.generate(world);
        return worldRepository.save(world);
    }
//    private String generateContinentName() {
//        String[] names = {
//                "Eldoria",
//                "Ashen Hollow",
//                "Solaria",
//                "Drakmor",
//                "Frosthelm"
//        };
//
//        return names[new Random().nextInt(names.length)];
//    }

//    private String generateBiome(String theme) {
//
//        if ("Dark Fantasy".equalsIgnoreCase(theme)) {
//            return "Haunted Forest";
//        }
//
//        return "Green Plains";
//    }

//    private String generateClimate() {
//
//        String[] climates = {
//                "Cold",
//                "Temperate",
//                "Hot",
//                "Mystical"
//        };
//
//        return climates[new Random().nextInt(climates.length)];
//    }
//
//    private Integer generateKingdomCount() {
//        return new Random().nextInt(5) + 3;
//    }
//
//    private String generateWorldDescription(String theme) {
//
//        return "A " + theme +
//                " world filled with forgotten kingdoms, ancient ruins, dangerous creatures, and mysterious magic.";
//    }

}
