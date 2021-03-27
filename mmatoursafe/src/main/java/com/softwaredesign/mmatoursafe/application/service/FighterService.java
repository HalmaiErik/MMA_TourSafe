package com.softwaredesign.mmatoursafe.application.service;

import com.softwaredesign.mmatoursafe.domain.entity.CovidTest;
import com.softwaredesign.mmatoursafe.domain.entity.Fighter;
import com.softwaredesign.mmatoursafe.persistence.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FighterService {
    private final FighterRepository fighterRepository;
    private final CovidTestService covidTestService;

    @Autowired
    public FighterService(FighterRepository fighterRepository, CovidTestService covidTestService) {
        this.fighterRepository = fighterRepository;
        this.covidTestService = covidTestService;
    }

    public Fighter addFighter(Fighter fighter) {
        return fighterRepository.save(fighter);
    }

    public List<Fighter> findNegativeFightersByTournamentId(Long id) {
        List<Fighter> allFighters = findFightersByTournamentId(id);
        List<Fighter> negativeFighters = new ArrayList<>();

        for (Fighter fighter : allFighters) {
            CovidTest lastTest = covidTestService.getLastTestForFighterId(fighter.getId());
            if (!lastTest.getResult()) {
                negativeFighters.add(fighter);
            }
        }
        return negativeFighters;
    }

    public List<Fighter> findPositiveFightersByTournamentId(Long id) {
        List<Fighter> allFighters = findFightersByTournamentId(id);
        List<Fighter> positiveFighters = new ArrayList<>();

        for (Fighter fighter : allFighters) {
            CovidTest lastTest = covidTestService.getLastTestForFighterId(fighter.getId());
            if (lastTest.getResult()) {
                positiveFighters.add(fighter);
            }
        }
        return positiveFighters;
    }

    private List<Fighter> findFightersByTournamentId(Long id) {
        return fighterRepository.findAllByTournament_Id(id);
    }
}
