package com.aigamemaster.gameengine.service;

import com.aigamemaster.gameengine.dto.EnemyDTO;
import com.aigamemaster.gameengine.entity.Enemy;
import com.aigamemaster.gameengine.entity.World;
import com.aigamemaster.gameengine.generator.EnemyGenerator;
import com.aigamemaster.gameengine.repository.EnemyRepository;
import com.aigamemaster.gameengine.repository.WorldRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EnemyService {

    private final EnemyRepository enemyRepository;
    private final WorldRepository worldRepository;
    private final EnemyGenerator enemyGenerator;

    public EnemyService(EnemyRepository enemyRepository,
                        WorldRepository worldRepository,
                        EnemyGenerator enemyGenerator) {
        this.enemyRepository = enemyRepository;
        this.worldRepository = worldRepository;
        this.enemyGenerator = enemyGenerator;
    }

    public Enemy createEnemy(EnemyDTO enemyDTO) {

        World world = worldRepository.findById(enemyDTO.getWorldId())
                .orElseThrow(() -> new NoSuchElementException("World not found"));

        Enemy enemy = new Enemy();

        enemy.setWorld(world);

        enemyGenerator.generate(enemy);

        return enemyRepository.save(enemy);
    }
}