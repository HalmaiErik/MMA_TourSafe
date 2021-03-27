package com.softwaredesign.mmatoursafe.presentation.controller;

import com.softwaredesign.mmatoursafe.application.mapper.TournamentMapper;
import com.softwaredesign.mmatoursafe.presentation.dto.TournamentDTO;
import com.softwaredesign.mmatoursafe.domain.entity.Tournament;
import com.softwaredesign.mmatoursafe.application.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class TournamentController {
    private final TournamentService tournamentService;
    private final TournamentMapper mapper;

    @Autowired
    public TournamentController(TournamentService tournamentService, TournamentMapper mapper) {
        this.tournamentService = tournamentService;
        this.mapper = mapper;
    }

    @PostMapping("add")
    public TournamentDTO addTournament(@RequestBody TournamentDTO tournamentDTO) {
        Tournament tournament = tournamentService.addTournament(mapper.convertToEntity(tournamentDTO));
        return mapper.convertToDTO(tournament);
    }

    @GetMapping("tournament/{id}")
    public TournamentDTO getTournamentById(@PathVariable Long id) {
        return mapper.convertToDTO(tournamentService.findTournamentById(id));
    }

    @GetMapping
    public List<TournamentDTO> getAllTournaments() {
        List<Tournament> tournaments = tournamentService.findAllTournaments();
        return tournaments.stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
