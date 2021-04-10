package com.softwaredesign.mmatoursafe.presentation.controller;

import com.softwaredesign.mmatoursafe.presentation.dto.TournamentDTO;
import com.softwaredesign.mmatoursafe.application.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {
    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping
    public TournamentDTO addTournament(@RequestBody TournamentDTO tournamentDTO) {
        return tournamentService.addTournament(tournamentDTO);
    }

    @GetMapping("/{id}")
    public TournamentDTO getTournamentById(@PathVariable Long id) {
        return tournamentService.findTournamentById(id);
    }

    @GetMapping
    public List<TournamentDTO> getAllTournaments() {
        return tournamentService.findAllTournaments();
    }
}
