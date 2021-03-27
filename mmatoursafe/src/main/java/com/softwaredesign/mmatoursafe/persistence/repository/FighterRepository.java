package com.softwaredesign.mmatoursafe.persistence.repository;

import com.softwaredesign.mmatoursafe.domain.entity.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long> {
    List<Fighter> findAllByTournament_Id(Long id);
}
