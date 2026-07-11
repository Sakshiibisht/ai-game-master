package com.aigamemaster.gameengine.controller;
import com.aigamemaster.gameengine.dto.WorldDTO;
import com.aigamemaster.gameengine.entity.World;
import com.aigamemaster.gameengine.service.WorldService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/worlds")
public class WorldController {
    private final WorldService worldService;
    public  WorldController(WorldService worldService){
        this.worldService = worldService;
    }
    @PostMapping
    public World createWorld(@RequestBody WorldDTO worldDTO){
        return worldService.createWorld(
                worldDTO.getTheme(),
                worldDTO.getMagicLevel()
        );
    }

}
