package com.aigamemaster.gameengine.dto;

public class QuestDTO {

    private Long playerId;
    private Long npcId;

    public QuestDTO() {
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getNpcId() {
        return npcId;
    }

    public void setNpcId(Long npcId) {
        this.npcId = npcId;
    }
}