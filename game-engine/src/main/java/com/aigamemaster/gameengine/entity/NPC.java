package com.aigamemaster.gameengine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "npcs")
public class NPC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String npcName;

    private String npcType;

    private String profession;

    @Column(length = 1000)
    private String dialogue;

    private Integer level;

    @ManyToOne
    @JoinColumn(name = "world_id")
    private World world;

    public NPC() {
    }

    public Long getId() {
        return id;
    }

    public String getNpcName() {
        return npcName;
    }

    public void setNpcName(String npcName) {
        this.npcName = npcName;
    }

    public String getNpcType() {
        return npcType;
    }

    public void setNpcType(String npcType) {
        this.npcType = npcType;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}