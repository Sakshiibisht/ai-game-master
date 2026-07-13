package com.aigamemaster.gameengine.generator;

import com.aigamemaster.gameengine.entity.World;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class WorldGenerator {

    public void generate(World world) {

        Random random = new Random(world.getSeed());

        String[] continents = {
                "Drakmor",
                "Eldoria",
                "Valoria",
                "Ashen Reach",
                "Frostheim"
        };

        String[] climates = {
                "Cold",
                "Hot",
                "Temperate",
                "Frozen",
                "Tropical"
        };

        String[] biomes = {
                "Haunted Forest",
                "Crystal Desert",
                "Ancient Jungle",
                "Frozen Wasteland",
                "Volcanic Plains"
        };
        String[] capitals = {
                "Blackspire",
                "Silverhold",
                "Dragon's Rest",
                "Stromhaven",
                "Moonfall"
        };

        world.setContinentName(
                continents[random.nextInt(continents.length)]
        );

        world.setClimate(
                climates[random.nextInt(climates.length)]
        );

        world.setStartingBiome(
                biomes[random.nextInt(biomes.length)]
        );

        world.setKingdomCount(
                random.nextInt(5) + 3
        );
        world.setWorldDescription(
                "A" + world.getTheme() + "world filled with forgotten kingdoms, ancient ruins, dangerous creatures, and mysterious magic."
        );
        world.setCapitalCity(
                capitals[random.nextInt(capitals.length)]
        );

    }

}