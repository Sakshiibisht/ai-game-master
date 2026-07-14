package com.aigamemaster.gameengine.service;
import com.aigamemaster.gameengine.dto.PlayerDTO;
import com.aigamemaster.gameengine.entity.Player;
import com.aigamemaster.gameengine.entity.World;
import com.aigamemaster.gameengine.entity.Inventory;
import com.aigamemaster.gameengine.entity.Item;
import com.aigamemaster.gameengine.repository.PlayerRepository;
import com.aigamemaster.gameengine.repository.WorldRepository;
import com.aigamemaster.gameengine.repository.InventoryRepository;
import com.aigamemaster.gameengine.repository.ItemRepository;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final WorldRepository worldRepository;
    private final PlayerRepository playerRepository;
    private final InventoryRepository inventoryRepository;
    private final ItemRepository itemRepository;

    public PlayerService(PlayerRepository playerRepository,
                         WorldRepository worldRepository,
                         InventoryRepository inventoryRepository,
                         ItemRepository itemRepository) {
        this.playerRepository = playerRepository;
        this.worldRepository = worldRepository;
        this.inventoryRepository = inventoryRepository;
        this.itemRepository = itemRepository;
    }

    public Player createPlayer(PlayerDTO playerDTO) {

        Player player = new Player();
        player.setPlayerName(playerDTO.getPlayerName());
        player.setPlayerClass(playerDTO.getPlayerClass());
        player.setLevel(1);
        player.setExperience(0);
        player.setHealth(100);
        player.setMana(50);
        player.setGold(100);
        World world = worldRepository.findById(playerDTO.getWorldId())
                .orElseThrow(() -> new NoSuchElementException("World not found"));
        player.setCurrentWorld(world);
        Player savedPlayer = playerRepository.save(player);
        Inventory inventory = new Inventory();
        inventory.setPlayer(savedPlayer);
        inventory = inventoryRepository.save(inventory);
        Item weapon = new Item();
        weapon.setItemName("Wooden Sword");
        weapon.setItemType("Weapon");
        weapon.setQuantity(1);
        weapon.setValue(10);

        Item potion = new Item();
        potion.setItemName("Health Potion");
        potion.setItemType("Potion");
        potion.setQuantity(3);
        potion.setValue(25);

        inventory.getItems().add(weapon);
        inventory.getItems().add(potion);

        inventoryRepository.save(inventory);
        return savedPlayer;
    }
}