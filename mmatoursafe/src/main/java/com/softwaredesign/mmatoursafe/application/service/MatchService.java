package com.softwaredesign.mmatoursafe.application.service;

import com.softwaredesign.mmatoursafe.application.builder.MatchBuilder;
import com.softwaredesign.mmatoursafe.domain.entity.Match;
import com.softwaredesign.mmatoursafe.persistence.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final MatchBuilder matchBuilder;

    @Autowired
    public MatchService(MatchRepository matchRepository, MatchBuilder matchBuilder) {
        this.matchRepository = matchRepository;
        this.matchBuilder = matchBuilder;
    }

    public Match addMatch(Match match) {
        return matchRepository.save(matchBuilder.addFighter1(match.getFighter1())
                .addFighter2(match.getFighter2())
                .addTournament(match.getTournament())
                .build());
    }

    public List<Match> findMatchesByTournamentId(Long id) {
        return matchRepository.findAllByTournament_Id(id);
    }
}
