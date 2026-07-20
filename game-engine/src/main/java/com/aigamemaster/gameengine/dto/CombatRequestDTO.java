package com.aigamemaster.gameengine.dto;

import jakarta.validation.constraints.NotNull;

public class CombatRequestDTO {

    @NotNull(message = "Player ID is required")
    private Long playerId;

    @NotNull(message = "Enemy ID is required")
    private Long enemyId;

    public CombatRequestDTO() {
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getEnemyId() {
        return enemyId;
    }

    public void setEnemyId(Long enemyId) {
        this.enemyId = enemyId;
    }
}