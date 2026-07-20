package com.aigamemaster.gameengine.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PlayerDTO {
    @NotBlank(message = "Player name is required")
    private String playerName;
    @NotBlank(message = "Player class is required")
    private String playerClass;
    @NotNull(message = "World ID is required")
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
