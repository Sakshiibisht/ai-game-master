package com.aigamemaster.gameengine.controller;

import com.aigamemaster.gameengine.dto.NPCDTO;
import com.aigamemaster.gameengine.entity.NPC;
import com.aigamemaster.gameengine.service.NPCService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/npcs")
public class NPCController {
    private final NPCService npcService;

    public NPCController(NPCService npcService) {
        this.npcService = npcService;
    }

    @PostMapping
    public NPC createNPC(@RequestBody NPCDTO npcDTO) {
        return npcService.createNPC(npcDTO);
    }
}