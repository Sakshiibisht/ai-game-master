package com.aigamemaster.gameengine.dto;

public class PlayerDTO {
    private String playerName;
    private String playerClass;
    private Long worldId;
    public PlayerDTO(){

    }
    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    public String getPlayerClass(){
        return playerClass;
    }
    public void setPlayerClass(String playerClass){
        this.playerClass = playerClass;
    }
    public Long getWorldId() { return worldId; }
    public void setWorldId(Long worldId) { this.worldId = worldId; }
}
