package com.softwaredesign.mmatoursafe.presentation.controller;

import com.softwaredesign.mmatoursafe.application.mapper.CovidTestMapper;
import com.softwaredesign.mmatoursafe.application.service.CovidTestService;
import com.softwaredesign.mmatoursafe.presentation.dto.CovidTestDTO;
import com.softwaredesign.mmatoursafe.domain.entity.CovidTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fighter")
public class CovidTestController {
    private final CovidTestService covidTestService;
    private final CovidTestMapper mapper;

    @Autowired
    public CovidTestController(CovidTestService covidTestService, CovidTestMapper mapper) {
        this.covidTestService = covidTestService;
        this.mapper = mapper;
    }

    @PostMapping("/{id}/covidtest")
    public CovidTestDTO addCovidTest(@RequestBody CovidTestDTO covidTestDTO, @PathVariable Long id) {
        covidTestDTO.setIdFighter(id);
        CovidTest covidTest = covidTestService.addCovidTest(mapper.convertToEntity(covidTestDTO));
        return mapper.convertToDTO(covidTest);
    }
}
