package com.aigamemaster.gameengine.repository;
import com.aigamemaster.gameengine.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
