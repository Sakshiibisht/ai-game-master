package com.aigamemaster.gameengine.service;

import com.aigamemaster.gameengine.dto.CombatRequestDTO;
import com.aigamemaster.gameengine.dto.CombatResponseDTO;
import com.aigamemaster.gameengine.entity.Enemy;
import com.aigamemaster.gameengine.entity.Player;
import com.aigamemaster.gameengine.repository.EnemyRepository;
import com.aigamemaster.gameengine.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class CombatService {

    private final PlayerRepository playerRepository;
    private final EnemyRepository enemyRepository;

    public CombatService(PlayerRepository playerRepository,
                         EnemyRepository enemyRepository) {
        this.playerRepository = playerRepository;
        this.enemyRepository = enemyRepository;
    }

    public CombatResponseDTO fight(CombatRequestDTO request) {

        Player player = playerRepository.findById(request.getPlayerId())
                .orElseThrow(() -> new NoSuchElementException("Player not found"));

        Enemy enemy = enemyRepository.findById(request.getEnemyId())
                .orElseThrow(() -> new NoSuchElementException("Enemy not found"));

        Random random = new Random();

        int playerDamage = player.getLevel() * 5 + random.nextInt(11) + 5;

        int enemyHealth = enemy.getHealth() - playerDamage;

        CombatResponseDTO response = new CombatResponseDTO();

        response.setPlayerDamage(playerDamage);
        response.setRemainingEnemyHealth(Math.max(enemyHealth, 0));

        if (enemyHealth <= 0) {

            player.setExperience(
                    player.getExperience() + enemy.getExperienceReward()
            );

            player.setGold(
                    player.getGold() + enemy.getGoldReward()
            );

            boolean levelUp = false;

            if (player.getExperience() >= player.getLevel() * 100) {

                player.setLevel(player.getLevel() + 1);
                levelUp = true;
            }

            playerRepository.save(player);

            response.setWinner("Player");
            response.setPlayerExperience(player.getExperience());
            response.setPlayerGold(player.getGold());
            response.setLevelUp(levelUp);
            response.setMessage("Enemy defeated!");

        } else {

            enemy.setHealth(enemyHealth);
            enemyRepository.save(enemy);

            int enemyDamage = Math.max(
                    enemy.getAttack() - player.getLevel() * 2,
                    5
            );

            player.setHealth(
                    Math.max(player.getHealth() - enemyDamage, 0)
            );

            playerRepository.save(player);

            response.setEnemyDamage(enemyDamage);
            response.setWinner("Enemy");
            response.setPlayerExperience(player.getExperience());
            response.setPlayerGold(player.getGold());
            response.setLevelUp(false);
            response.setMessage("Enemy survived and attacked back.");
        }

        return response;
    }
}