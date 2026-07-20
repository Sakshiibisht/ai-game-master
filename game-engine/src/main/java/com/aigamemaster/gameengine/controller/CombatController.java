package com.aigamemaster.gameengine.controller;

import com.aigamemaster.gameengine.dto.CombatRequestDTO;
import com.aigamemaster.gameengine.dto.CombatResponseDTO;
import com.aigamemaster.gameengine.service.CombatService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/combat")
public class CombatController {

    private final CombatService combatService;

    public CombatController(CombatService combatService) {
        this.combatService = combatService;
    }

    @PostMapping("/fight")
    public CombatResponseDTO fight(@RequestBody @Valid CombatRequestDTO request) {
        return combatService.fight(request);
    }
}