package com.softwaredesign.mmatoursafe.persistence.repository;

import com.softwaredesign.mmatoursafe.domain.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findAllByTournament_Id(Long id);
}
