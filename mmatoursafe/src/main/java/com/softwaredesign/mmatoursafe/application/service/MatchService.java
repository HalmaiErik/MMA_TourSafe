package com.softwaredesign.mmatoursafe.application.service;

import com.softwaredesign.mmatoursafe.application.mapper.MatchMapper;
import com.softwaredesign.mmatoursafe.application.schedulestrategy.ScheduleStrategy;
import com.softwaredesign.mmatoursafe.domain.entity.Match;
import com.softwaredesign.mmatoursafe.persistence.repository.MatchRepository;
import com.softwaredesign.mmatoursafe.presentation.dto.MatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final MatchMapper mapper;
    private final Map<String, ScheduleStrategy> scheduleStrategies;

    @Autowired
    public MatchService(MatchRepository matchRepository, MatchMapper mapper,
                        Map<String, ScheduleStrategy> scheduleStrategies) {
        this.matchRepository = matchRepository;
        this.mapper = mapper;
        this.scheduleStrategies = scheduleStrategies;
    }

    public List<MatchDTO> addMatches(List<MatchDTO> matchDTOs) {
        ScheduleStrategy scheduleStrategy = scheduleStrategies.get(matchDTOs.get(0).getTournament().getSchedule());
        List<MatchDTO> addedMatches = new LinkedList<>();
        for (MatchDTO matchDTO : matchDTOs) {
            MatchDTO toInsert = scheduleStrategy.scheduleMatch(matchDTO);
            Match addedMatch = matchRepository.save(mapper.convertToEntity(toInsert));
            addedMatches.add(mapper.convertToDTO(addedMatch));
        }
        return addedMatches;
    }

    public List<MatchDTO> findMatchesByTournamentId(Long id) {
        List<Match> matches = matchRepository.findAllByTournament_Id(id);
        return matches.stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
