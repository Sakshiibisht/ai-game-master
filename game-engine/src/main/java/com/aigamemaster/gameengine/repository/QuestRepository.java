package com.aigamemaster.gameengine.repository;
import com.aigamemaster.gameengine.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest, Long> {
}
