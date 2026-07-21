package com.aigamemaster.gameengine.service;

import com.aigamemaster.gameengine.dto.CombatRequestDTO;
import com.aigamemaster.gameengine.dto.CombatResponseDTO;
import com.aigamemaster.gameengine.entity.Enemy;
import com.aigamemaster.gameengine.entity.Player;
import com.aigamemaster.gameengine.entity.Inventory;
import com.aigamemaster.gameengine.repository.EnemyRepository;
import com.aigamemaster.gameengine.repository.InventoryRepository;
import com.aigamemaster.gameengine.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class CombatService {

    private final PlayerRepository playerRepository;
    private final EnemyRepository enemyRepository;
    private final InventoryRepository inventoryRepository;

    public CombatService(PlayerRepository playerRepository,
                         EnemyRepository enemyRepository,
                         InventoryRepository inventoryRepository) {
        this.playerRepository = playerRepository;
        this.enemyRepository = enemyRepository;
        this.inventoryRepository = inventoryRepository;
    }
    @Transactional
    public CombatResponseDTO fight(CombatRequestDTO request) {

        Player player = playerRepository.findById(request.getPlayerId())
                .orElseThrow(() -> new NoSuchElementException("Player not found"));
        Inventory inventory = inventoryRepository.findByPlayer(player).
                orElseThrow(() -> new NoSuchElementException("Inventory not found"));
        Enemy enemy = enemyRepository.findById(request.getEnemyId())
                .orElseThrow(() -> new NoSuchElementException("Enemy not found"));

        Random random = new Random();

        int playerDamage = player.getLevel() * 5 + random.nextInt(11) + 5;
        boolean criticalHit = random.nextInt(100) < 10;
        if(criticalHit) {
            playerDamage *= 2;
        }
        int actualDamage = Math.max(playerDamage - (enemy.getDefense() / 2), 1);
        int enemyHealth = enemy.getHealth() - actualDamage;

        CombatResponseDTO response = new CombatResponseDTO();
        response.setCriticalHit(criticalHit);
        response.setPlayerDamage(actualDamage);
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
            if (player.getHealth() < 30) {

                inventory.getItems().stream()

                        .filter(item ->
                                item.getItemName().equals("Health Potion")
                                        && item.getQuantity() > 0)

                        .findFirst()

                        .ifPresent(item -> {

                            player.setHealth(
                                    Math.min(player.getHealth() + 50, 100)
                            );

                            item.setQuantity(item.getQuantity() - 1);

                            response.setPotionUsed(true);
                            response.setRemainingPotions(item.getQuantity());
                        });
            }

            playerRepository.save(player);

            response.setEnemyDamage(enemyDamage);
            response.setWinner("Enemy");
            response.setPlayerExperience(player.getExperience());
            response.setPlayerGold(player.getGold());
            response.setLevelUp(false);
            response.setMessage("Enemy survived and attacked back.");
        }
        if(response.getPotionUsed() == null){
            response.setPotionUsed(false);
        }
        return response;
    }
}