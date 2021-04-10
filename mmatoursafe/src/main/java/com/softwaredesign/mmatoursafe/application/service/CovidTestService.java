package com.softwaredesign.mmatoursafe.application.service;

import com.softwaredesign.mmatoursafe.application.mapper.CovidTestMapper;
import com.softwaredesign.mmatoursafe.domain.entity.CovidTest;
import com.softwaredesign.mmatoursafe.persistence.repository.CovidTestRepository;
import com.softwaredesign.mmatoursafe.presentation.dto.CovidTestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidTestService {
    private final CovidTestRepository covidTestRepository;
    private final CovidTestMapper mapper;

    @Autowired
    public CovidTestService(CovidTestRepository covidTestRepository, CovidTestMapper mapper) {
        this.covidTestRepository = covidTestRepository;
        this.mapper = mapper;
    }

    public CovidTestDTO addCovidTest(CovidTestDTO covidTestDTO) {
        CovidTest covidTest = covidTestRepository.save(mapper.convertToEntity(covidTestDTO));
        return mapper.convertToDTO(covidTest);
    }

    public CovidTestDTO getLastTestForFighterId(Long id) {
        CovidTest covidTest = covidTestRepository.findFirstByFighter_IdOrderByDateDesc(id);
        return mapper.convertToDTO(covidTest);
    }
}
