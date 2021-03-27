package com.softwaredesign.mmatoursafe.persistence.repository;

import com.softwaredesign.mmatoursafe.domain.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    Optional<Tournament> findById(Long id);
    List<Tournament> findAll();
}
