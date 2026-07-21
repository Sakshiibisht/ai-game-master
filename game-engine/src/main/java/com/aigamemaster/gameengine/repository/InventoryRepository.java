package com.aigamemaster.gameengine.repository;
import com.aigamemaster.gameengine.entity.Inventory;
import com.aigamemaster.gameengine.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByPlayer(Player player);
}
