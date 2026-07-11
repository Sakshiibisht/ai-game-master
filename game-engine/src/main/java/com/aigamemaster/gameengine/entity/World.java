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
}