package com.softwaredesign.mmatoursafe.application.schedulestrategy;

import com.softwaredesign.mmatoursafe.domain.entity.Match;
import com.softwaredesign.mmatoursafe.persistence.repository.MatchRepository;
import com.softwaredesign.mmatoursafe.presentation.dto.MatchDTO;
import com.softwaredesign.mmatoursafe.presentation.dto.TournamentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component("Monthly")
public class MonthlyScheduler implements ScheduleStrategy {
    private final MatchRepository matchRepository;

    @Autowired
    public MonthlyScheduler(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public MatchDTO scheduleMatch(MatchDTO matchDTO) {
        TournamentDTO tournamentDTO = matchDTO.getTournament();
        LocalDateTime matchDateTime = findNewMatchTime(tournamentDTO);
        matchDTO.setDateTime(matchDateTime);
        return matchDTO;
    }

    private LocalDateTime findNewMatchTime(TournamentDTO tournamentDTO) {
        List<Match> scheduledMatches = matchRepository.findAllByTournament_Id(tournamentDTO.getId());
        LocalDate tournamentStartDate = LocalDate.parse(tournamentDTO.getStartDate());
        LocalDate tournamentEndDate = LocalDate.parse(tournamentDTO.getEndDate());

        if (scheduledMatches.isEmpty()) {
            return tournamentStartDate.atTime(21, 0);
        }
        else {
            LocalDateTime lastMatchTime = scheduledMatches.get(scheduledMatches.size() - 1).getDateTime();
            if (tournamentEndDate.isAfter(lastMatchTime.plusMonths(1).toLocalDate())) {
                return lastMatchTime.plusMonths(1);
            }
            else {
                return tournamentEndDate.atTime(21, 0);
            }
        }
    }
}
