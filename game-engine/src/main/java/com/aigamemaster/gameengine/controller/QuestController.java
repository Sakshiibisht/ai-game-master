package com.aigamemaster.gameengine.controller;

import com.aigamemaster.gameengine.dto.QuestDTO;
import com.aigamemaster.gameengine.entity.Quest;
import com.aigamemaster.gameengine.service.QuestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quests")
public class QuestController {

    private final QuestService questService;

    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @PostMapping
    public Quest createQuest(@RequestBody QuestDTO questDTO) {
        return questService.createQuest(questDTO);
    }
}