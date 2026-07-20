package com.aigamemaster.gameengine.service;

import com.aigamemaster.gameengine.dto.QuestDTO;
import com.aigamemaster.gameengine.entity.NPC;
import com.aigamemaster.gameengine.entity.Player;
import com.aigamemaster.gameengine.entity.Quest;
import com.aigamemaster.gameengine.generator.QuestGenerator;
import com.aigamemaster.gameengine.repository.NPCRepository;
import com.aigamemaster.gameengine.repository.PlayerRepository;
import com.aigamemaster.gameengine.repository.QuestRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class QuestService {

    private final QuestRepository questRepository;
    private final PlayerRepository playerRepository;
    private final NPCRepository npcRepository;
    private final QuestGenerator questGenerator;

    public QuestService(QuestRepository questRepository,
                        PlayerRepository playerRepository,
                        NPCRepository npcRepository,
                        QuestGenerator questGenerator) {

        this.questRepository = questRepository;
        this.playerRepository = playerRepository;
        this.npcRepository = npcRepository;
        this.questGenerator = questGenerator;
    }

    public Quest createQuest(QuestDTO questDTO) {

        Player player = playerRepository.findById(questDTO.getPlayerId())
                .orElseThrow(() -> new NoSuchElementException("Player not found"));

        NPC npc = npcRepository.findById(questDTO.getNpcId())
                .orElseThrow(() -> new NoSuchElementException("NPC not found"));

        Quest quest = new Quest();

        quest.setPlayer(player);
        quest.setNpc(npc);

        questGenerator.generate(quest);

        return questRepository.save(quest);
    }
}