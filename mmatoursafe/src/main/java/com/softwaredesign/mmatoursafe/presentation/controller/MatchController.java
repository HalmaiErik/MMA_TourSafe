package com.softwaredesign.mmatoursafe.presentation.controller;

import com.softwaredesign.mmatoursafe.application.mapper.FighterMapper;
import com.softwaredesign.mmatoursafe.application.mapper.MatchMapper;
import com.softwaredesign.mmatoursafe.application.mapper.TournamentMapper;
import com.softwaredesign.mmatoursafe.application.service.MatchService;
import com.softwaredesign.mmatoursafe.presentation.dto.MatchDTO;
import com.softwaredesign.mmatoursafe.domain.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tournament")
public class MatchController {
    private final MatchService matchService;
    private final MatchMapper matchMapper;
    private final TournamentMapper tournamentMapper;
    private final FighterMapper fighterMapper;

    @Autowired
    public MatchController(MatchService matchService, MatchMapper mapper, TournamentMapper tournamentMapper,
                           FighterMapper fighterMapper) {
        this.matchService = matchService;
        this.matchMapper = mapper;
        this.tournamentMapper = tournamentMapper;
        this.fighterMapper = fighterMapper;
    }

    @PostMapping("/match/add")
    public MatchDTO addMatch(@RequestBody MatchDTO matchDTO) {
        Match match =  matchService.addMatch(matchMapper.convertToEntity(matchDTO));
        return matchMapper.convertToDTO(match);
    }

    @GetMapping("/{id}/matches")
    public List<MatchDTO> getTournamentMatches(@PathVariable Long id) {
        List<Match> matches = matchService.findMatchesByTournamentId(id);
        return matches.stream()
                .map(matchMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
