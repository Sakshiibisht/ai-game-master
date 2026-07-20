package com.aigamemaster.gameengine.dto;

public class CombatResponseDTO {

    private String winner;
    private Integer playerDamage;
    private Integer enemyDamage;
    private Integer remainingEnemyHealth;
    private Integer playerExperience;
    private Integer playerGold;
    private Boolean levelUp;
    private String message;

    public CombatResponseDTO() {
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Integer getPlayerDamage() {
        return playerDamage;
    }

    public void setPlayerDamage(Integer playerDamage) {
        this.playerDamage = playerDamage;
    }

    public Integer getEnemyDamage() {
        return enemyDamage;
    }

    public void setEnemyDamage(Integer enemyDamage) {
        this.enemyDamage = enemyDamage;
    }

    public Integer getRemainingEnemyHealth() {
        return remainingEnemyHealth;
    }

    public void setRemainingEnemyHealth(Integer remainingEnemyHealth) {
        this.remainingEnemyHealth = remainingEnemyHealth;
    }

    public Integer getPlayerExperience() {
        return playerExperience;
    }

    public void setPlayerExperience(Integer playerExperience) {
        this.playerExperience = playerExperience;
    }

    public Integer getPlayerGold() {
        return playerGold;
    }

    public void setPlayerGold(Integer playerGold) {
        this.playerGold = playerGold;
    }

    public Boolean getLevelUp() {
        return levelUp;
    }

    public void setLevelUp(Boolean levelUp) {
        this.levelUp = levelUp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}