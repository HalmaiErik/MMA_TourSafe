package com.softwaredesign.mmatoursafe.application.builder;

import com.softwaredesign.mmatoursafe.domain.entity.Fighter;
import com.softwaredesign.mmatoursafe.domain.entity.Match;
import com.softwaredesign.mmatoursafe.domain.entity.Tournament;
import com.softwaredesign.mmatoursafe.persistence.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class MatchBuilder {
    private Fighter fighter1;
    private Fighter fighter2;
    private Tournament tournament;
    private final MatchRepository matchRepository;

    @Autowired
    public MatchBuilder(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match build() {
        Match match = new Match();
        setFighter1(match);
        setFighter2(match);
        setTournament(match);
        setDateTime(match);

        return match;
    }

    public MatchBuilder addFighter1(Fighter fighter1) {
        this.fighter1 = fighter1;
        return this;
    }

    public MatchBuilder addFighter2(Fighter fighter2) {
        this.fighter2 = fighter2;
        return this;
    }

    public MatchBuilder addTournament(Tournament tournament) {
        this.tournament = tournament;
        return this;
    }

    private void setFighter1(Match match) {
        match.setFighter1(fighter1);
    }

    private void setFighter2(Match match) {
        match.setFighter2(fighter2);
    }

    private void setTournament(Match match) {
        match.setTournament(tournament);
    }

    private void setDateTime(Match match) {
        List<Match> scheduledMatches = getTournamentMatches();
        LocalDate tournamentStartDate = tournament.getStartDate().toLocalDate();
        LocalDate tournamentEndDate = tournament.getEndDate().toLocalDate();

        LocalDateTime matchDateTime;
        if (scheduledMatches.isEmpty()) {
            matchDateTime = tournamentStartDate.atTime(21, 0);
        }
        else {
            LocalDateTime lastScheduledMatch = getLastScheduledMatchTime();
            if (tournamentEndDate.isAfter(lastScheduledMatch.plusWeeks(1).toLocalDate())) {
                matchDateTime = lastScheduledMatch.plusWeeks(1);
            }
            else {
                matchDateTime = tournamentEndDate.atTime(21, 0);
            }
        }
        match.setDateTime(matchDateTime);
    }

    private LocalDateTime getLastScheduledMatchTime() {
        List<Match> tournamentMatches = getTournamentMatches();
        return tournamentMatches.get(tournamentMatches.size() - 1).getDateTime();
    }

    private List<Match> getTournamentMatches() {
        return matchRepository.findAllByTournament_Id(tournament.getId());
    }
}
