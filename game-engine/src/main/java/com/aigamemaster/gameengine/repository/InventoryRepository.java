package com.aigamemaster.gameengine.repository;
import com.aigamemaster.gameengine.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
