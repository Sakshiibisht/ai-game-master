package com.aigamemaster.gameengine.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "worlds")
public class World {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String worldName;

    @Column(nullable = false)
    private Long seed;

    @Column(nullable = false)
    private String theme;

    @Column(nullable = false)
    private String magicLevel;

    @Column(nullable = false)
    private String worldStatus;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public World() {
    }

    public Long getId() {
        return id;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public Long getSeed() {
        return seed;
    }

    public void setSeed(Long seed) {
        this.seed = seed;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    private String capitalCity;
    public String getCapitalCity(){ return capitalCity; }
    public void setCapitalCity(String capitalCity) { this.capitalCity = capitalCity; }

    public String getMagicLevel() {
        return magicLevel;
    }

    public void setMagicLevel(String magicLevel) {
        this.magicLevel = magicLevel;
    }

    public String getWorldStatus() {
        return worldStatus;
    }

    public void setWorldStatus(String worldStatus) {
        this.worldStatus = worldStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    private String continentName;
    private String startingBiome;
    private String climate;
    private Integer kingdomCount;
    @Column(columnDefinition = "TEXT")
    private String worldDescription;
    public String getContinentName(){
        return continentName;
    }
    public void setContinentName(String continentName){
        this.continentName = continentName;
    }
    public String getStartingBiome() {
        return startingBiome;
    }
    public void setStartingBiome(String startingBiome){
        this.startingBiome = startingBiome;
    }
    public String getClimate(){
        return climate;
    }
    public void setClimate(String climate){
        this.climate = climate;
    }
    public Integer getKingdomCount(){
        return kingdomCount;
    }
    public void setKingdomCount(Integer kingdomCount){
        this.kingdomCount = kingdomCount;
    }
    public String getWorldDescription(){
        return worldDescription;
    }
    public void setWorldDescription(String worldDescription){
        this.worldDescription = worldDescription;
    }


}