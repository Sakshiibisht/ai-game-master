package com.aigamemaster.gameengine.controller;

import com.aigamemaster.gameengine.dto.EnemyDTO;
import com.aigamemaster.gameengine.entity.Enemy;
import com.aigamemaster.gameengine.service.EnemyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enemies")
public class EnemyController {

    private final EnemyService enemyService;

    public EnemyController(EnemyService enemyService) {
        this.enemyService = enemyService;
    }

    @PostMapping
    public Enemy createEnemy(@RequestBody @Valid EnemyDTO enemyDTO) {
        return enemyService.createEnemy(enemyDTO);
    }
}