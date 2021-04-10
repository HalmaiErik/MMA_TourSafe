package com.softwaredesign.mmatoursafe.presentation.controller;

import com.softwaredesign.mmatoursafe.application.service.FighterService;
import com.softwaredesign.mmatoursafe.presentation.dto.FighterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fighters")
public class FighterController {
    private final FighterService fighterService;

    @Autowired
    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @PostMapping("/tournament/{id}")
    public FighterDTO addFighter(@RequestBody FighterDTO fighterDTO, @PathVariable Long id) {
        return fighterService.addFighter(fighterDTO);
    }

    @GetMapping("/negative/tournament/{id}")
    public List<FighterDTO> getTournamentNegativeFighters(@PathVariable Long id) {
        return fighterService.findNegativeFightersByTournamentId(id);
    }

    @GetMapping("/positive/tournament/{id}")
    public List<FighterDTO> getTournamentPositiveFighters(@PathVariable Long id) {
        return fighterService.findPositiveFightersByTournamentId(id);
    }
}
