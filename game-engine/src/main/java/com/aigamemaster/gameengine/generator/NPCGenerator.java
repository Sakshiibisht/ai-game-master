package com.aigamemaster.gameengine.generator;

import com.aigamemaster.gameengine.entity.NPC;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NPCGenerator {

    private final Random random = new Random();

    public void generate(NPC npc) {

        String[] names = {
                "Aldric",
                "Luna",
                "Thorin",
                "Selene",
                "Eldor",
                "Kael"
        };

        String[] dialogues = {
                "Greetings, traveler.",
                "Danger lies beyond the forest.",
                "The king seeks brave warriors.",
                "Magic flows through these lands.",
                "Be careful... darkness is rising."
        };

        npc.setNpcName(
                names[random.nextInt(names.length)]
        );

        npc.setDialogue(
                dialogues[random.nextInt(dialogues.length)]
        );

        npc.setLevel(
                random.nextInt(10) + 1
        );
    }
}