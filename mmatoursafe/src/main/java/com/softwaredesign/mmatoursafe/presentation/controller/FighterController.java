package com.softwaredesign.mmatoursafe.presentation.controller;

import com.softwaredesign.mmatoursafe.application.mapper.FighterMapper;
import com.softwaredesign.mmatoursafe.application.service.FighterService;
import com.softwaredesign.mmatoursafe.presentation.dto.FighterDTO;
import com.softwaredesign.mmatoursafe.domain.entity.Fighter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tournament")
public class FighterController {
    private final FighterService fighterService;
    private final FighterMapper mapper;

    @Autowired
    public FighterController(FighterService fighterService, FighterMapper mapper) {
        this.fighterService = fighterService;
        this.mapper = mapper;
    }

    @PostMapping("/{id}/invitation")
    public FighterDTO addFighter(@RequestBody FighterDTO fighterDTO, @PathVariable Long id) {
        Fighter fighter = fighterService.addFighter(mapper.convertToEntity(fighterDTO));
        return mapper.convertToDTO(fighter);
    }

    @GetMapping("{id}/negativefighters")
    public List<FighterDTO> getTournamentNegativeFighters(@PathVariable Long id) {
        List<Fighter> fighters = fighterService.findNegativeFightersByTournamentId(id);
        return fighters.stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}/positivefighters")
    public List<FighterDTO> getTournamentPositiveFighters(@PathVariable Long id) {
        List<Fighter> fighters = fighterService.findPositiveFightersByTournamentId(id);
        return fighters.stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
