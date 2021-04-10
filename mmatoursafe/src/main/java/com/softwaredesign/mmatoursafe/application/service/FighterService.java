package com.softwaredesign.mmatoursafe.application.service;

import com.softwaredesign.mmatoursafe.application.mapper.FighterMapper;
import com.softwaredesign.mmatoursafe.domain.entity.Fighter;
import com.softwaredesign.mmatoursafe.persistence.repository.FighterRepository;
import com.softwaredesign.mmatoursafe.presentation.dto.CovidTestDTO;
import com.softwaredesign.mmatoursafe.presentation.dto.FighterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FighterService {
    private final FighterRepository fighterRepository;
    private final FighterMapper mapper;
    private final CovidTestService covidTestService;

    @Autowired
    public FighterService(FighterRepository fighterRepository, FighterMapper mapper, CovidTestService covidTestService) {
        this.fighterRepository = fighterRepository;
        this.mapper = mapper;
        this.covidTestService = covidTestService;
    }

    public FighterDTO addFighter(FighterDTO fighterDTO) {
        Fighter fighter = fighterRepository.save(mapper.convertToEntity(fighterDTO));
        return mapper.convertToDTO(fighter);
    }

    public List<FighterDTO> findNegativeFightersByTournamentId(Long id) {
        List<FighterDTO> allFighters = findFightersByTournamentId(id);
        List<FighterDTO> negativeFighters = new ArrayList<>();

        for (FighterDTO fighterDTO : allFighters) {
            CovidTestDTO lastTest = covidTestService.getLastTestForFighterId(fighterDTO.getId());
            if (!lastTest.getResult()) {
                negativeFighters.add(fighterDTO);
            }
        }
        return negativeFighters;
    }

    public List<FighterDTO> findPositiveFightersByTournamentId(Long id) {
        List<FighterDTO> allFighters = findFightersByTournamentId(id);
        List<FighterDTO> positiveFighters = new ArrayList<>();

        for (FighterDTO fighterDTO : allFighters) {
            CovidTestDTO lastTest = covidTestService.getLastTestForFighterId(fighterDTO.getId());
            if (lastTest.getResult()) {
                positiveFighters.add(fighterDTO);
            }
        }
        return positiveFighters;
    }

    private List<FighterDTO> findFightersByTournamentId(Long id) {
        List<Fighter> fighters = fighterRepository.findAllByTournament_Id(id);
        return fighters.stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
