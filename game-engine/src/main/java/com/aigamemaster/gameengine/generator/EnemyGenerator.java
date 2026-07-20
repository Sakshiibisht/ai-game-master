package com.aigamemaster.gameengine.generator;

import com.aigamemaster.gameengine.entity.Enemy;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EnemyGenerator {

    private final Random random = new Random();

    public void generate(Enemy enemy) {

        String[] names = {
                "Goblin",
                "Orc",
                "Skeleton",
                "Dark Mage",
                "Forest Wolf",
                "Dragon"
        };

        int index = random.nextInt(names.length);

        enemy.setEnemyName(names[index]);
        enemy.setEnemyType(names[index]);

        enemy.setHealth(random.nextInt(80) + 70);
        enemy.setAttack(random.nextInt(25) + 10);
        enemy.setDefense(random.nextInt(15) + 5);

        enemy.setExperienceReward(random.nextInt(150) + 100);
        enemy.setGoldReward(random.nextInt(100) + 50);
    }
}