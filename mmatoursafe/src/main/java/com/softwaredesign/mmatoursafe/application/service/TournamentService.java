package com.softwaredesign.mmatoursafe.application.service;

import com.softwaredesign.mmatoursafe.application.exceptions.NotFoundException;
import com.softwaredesign.mmatoursafe.application.mapper.TournamentMapper;
import com.softwaredesign.mmatoursafe.domain.entity.Tournament;
import com.softwaredesign.mmatoursafe.persistence.repository.TournamentRepository;
import com.softwaredesign.mmatoursafe.presentation.dto.TournamentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;
    private final TournamentMapper mapper;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository, TournamentMapper mapper) {
        this.tournamentRepository = tournamentRepository;
        this.mapper = mapper;
    }

    public TournamentDTO addTournament(TournamentDTO tournamentDTO) {
        Tournament tournament = tournamentRepository.save(mapper.convertToEntity(tournamentDTO));
        return mapper.convertToDTO(tournament);
    }

    public TournamentDTO findTournamentById(Long id) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tournament with id " + id + " not found"));
        return mapper.convertToDTO(tournament);
    }

    public List<TournamentDTO> findAllTournaments() {
        List<Tournament> tournaments = tournamentRepository.findAll();
        return tournaments.stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
