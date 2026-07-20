package com.aigamemaster.gameengine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "enemies")
public class Enemy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enemyName;

    private String enemyType;

    private Integer health;

    private Integer attack;

    private Integer defense;

    private Integer experienceReward;

    private Integer goldReward;

    @ManyToOne
    @JoinColumn(name = "world_id")
    private World world;

    public Enemy() {
    }

    public Long getId() {
        return id;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public String getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(String enemyType) {
        this.enemyType = enemyType;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getExperienceReward() {
        return experienceReward;
    }

    public void setExperienceReward(Integer experienceReward) {
        this.experienceReward = experienceReward;
    }

    public Integer getGoldReward() {
        return goldReward;
    }

    public void setGoldReward(Integer goldReward) {
        this.goldReward = goldReward;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}