package com.aigamemaster.gameengine.dto;
import jakarta.validation.constraints.NotNull;

public class EnemyDTO {
    @NotNull(message = "World ID is required")
    private Long worldId;
    public EnemyDTO(){
    }
    public Long getWorldId(){
        return worldId;
    }
    public void setWorldId(Long worldId){
        this.worldId = worldId;
    }
}
