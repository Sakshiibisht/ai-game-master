package com.aigamemaster.gameengine.repository;
import com.aigamemaster.gameengine.entity.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnemyRepository extends JpaRepository<Enemy, Long>{
}
