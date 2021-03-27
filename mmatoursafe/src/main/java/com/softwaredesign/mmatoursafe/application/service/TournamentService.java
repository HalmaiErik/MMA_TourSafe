package com.softwaredesign.mmatoursafe.application.service;

import com.softwaredesign.mmatoursafe.application.exceptions.NotFoundException;
import com.softwaredesign.mmatoursafe.domain.entity.Tournament;
import com.softwaredesign.mmatoursafe.persistence.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Tournament findTournamentById(Long id) {
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tournament with id " + id + " not found"));
    }

    public List<Tournament> findAllTournaments() {
        return tournamentRepository.findAll();
    }
}
