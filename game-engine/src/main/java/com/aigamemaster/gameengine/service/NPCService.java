package com.aigamemaster.gameengine.service;

import com.aigamemaster.gameengine.dto.NPCDTO;
import com.aigamemaster.gameengine.entity.NPC;
import com.aigamemaster.gameengine.entity.World;
import com.aigamemaster.gameengine.generator.NPCGenerator;
import com.aigamemaster.gameengine.repository.NPCRepository;
import com.aigamemaster.gameengine.repository.WorldRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class NPCService {

    private final NPCRepository npcRepository;
    private final WorldRepository worldRepository;
    private final NPCGenerator npcGenerator;

    public NPCService(NPCRepository npcRepository,
                      WorldRepository worldRepository,
                      NPCGenerator npcGenerator) {

        this.npcRepository = npcRepository;
        this.worldRepository = worldRepository;
        this.npcGenerator = npcGenerator;
    }

    public NPC createNPC(NPCDTO npcDTO) {

        World world = worldRepository.findById(npcDTO.getWorldId())
                .orElseThrow(() -> new NoSuchElementException("World not found"));

        NPC npc = new NPC();

        npc.setNpcType(npcDTO.getNpcType());
        npc.setProfession(npcDTO.getNpcType());

        npc.setWorld(world);

        npcGenerator.generate(npc);

        return npcRepository.save(npc);
    }

}