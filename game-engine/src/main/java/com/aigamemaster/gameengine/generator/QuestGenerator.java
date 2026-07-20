package com.aigamemaster.gameengine.generator;

import com.aigamemaster.gameengine.entity.Quest;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class QuestGenerator {

    private final Random random = new Random();

    public void generate(Quest quest) {

        String[] titles = {
                "Lost Relic",
                "Dragon Hunt",
                "Ancient Ruins",
                "Goblin Attack",
                "Rescue the Merchant"
        };

        String[] descriptions = {
                "Recover the lost relic from the cave.",
                "Defeat the dragon threatening the kingdom.",
                "Explore the forgotten ruins.",
                "Protect the village from goblins.",
                "Escort the merchant safely."
        };

        int index = random.nextInt(titles.length);

        quest.setTitle(titles[index]);
        quest.setDescription(descriptions[index]);

        quest.setRewardGold(random.nextInt(300) + 100);
        quest.setRewardExperience(random.nextInt(500) + 200);

        quest.setStatus("AVAILABLE");
    }
}