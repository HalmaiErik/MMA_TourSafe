package com.softwaredesign.mmatoursafe.presentation.controller;

import com.softwaredesign.mmatoursafe.application.service.MatchService;
import com.softwaredesign.mmatoursafe.presentation.dto.MatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {
    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/tournament/{id}")
    public List<MatchDTO> addMatches(@RequestBody List<MatchDTO> matchDTOs, @PathVariable Long id) {
        return matchService.addMatches(matchDTOs);
    }

    @GetMapping("/tournament/{id}")
    public List<MatchDTO> getTournamentMatches(@PathVariable Long id) {
        return matchService.findMatchesByTournamentId(id);
    }
}
