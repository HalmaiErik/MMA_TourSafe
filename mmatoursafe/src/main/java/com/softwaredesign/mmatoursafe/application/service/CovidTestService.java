package com.softwaredesign.mmatoursafe.application.service;

import com.softwaredesign.mmatoursafe.domain.entity.CovidTest;
import com.softwaredesign.mmatoursafe.persistence.repository.CovidTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidTestService {
    private final CovidTestRepository covidTestRepository;

    @Autowired
    public CovidTestService(CovidTestRepository covidTestRepository) {
        this.covidTestRepository = covidTestRepository;
    }

    public CovidTest addCovidTest(CovidTest covidTest) {
        return covidTestRepository.save(covidTest);
    }

    public CovidTest getLastTestForFighterId(Long id) {
        return covidTestRepository.findFirstByFighter_IdOrderByDateDesc(id);
    }
}
