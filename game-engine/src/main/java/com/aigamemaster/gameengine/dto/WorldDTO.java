package com.aigamemaster.gameengine.dto;

public class WorldDTO {
    private String theme;
    private String magicLevel;
    public WorldDTO(){
    }
    public String getTheme(){
        return theme;
    }
    public void setTheme(String theme){
        this.theme = theme;
    }
    public String getMagicLevel(){
        return magicLevel;
    }
    public void setMagicLevel(String magicLevel){
        this.magicLevel = magicLevel;
    }
}
