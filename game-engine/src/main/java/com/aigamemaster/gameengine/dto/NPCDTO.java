package com.aigamemaster.gameengine.dto;

public class NPCDTO {

    private Long worldId;
    private String npcType;

    public NPCDTO() {
    }

    public Long getWorldId() {
        return worldId;
    }

    public void setWorldId(Long worldId) {
        this.worldId = worldId;
    }

    public String getNpcType() {
        return npcType;
    }

    public void setNpcType(String npcType) {
        this.npcType = npcType;
    }
}