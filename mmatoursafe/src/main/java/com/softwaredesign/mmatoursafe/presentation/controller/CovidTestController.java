package com.softwaredesign.mmatoursafe.presentation.controller;

import com.softwaredesign.mmatoursafe.application.service.CovidTestService;
import com.softwaredesign.mmatoursafe.presentation.dto.CovidTestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/covidtest")
public class CovidTestController {
    private final CovidTestService covidTestService;

    @Autowired
    public CovidTestController(CovidTestService covidTestService) {
        this.covidTestService = covidTestService;
    }

    @PostMapping("/fighter/{id}")
    public CovidTestDTO addCovidTest(@RequestBody CovidTestDTO covidTestDTO, @PathVariable Long id) {
        return covidTestService.addCovidTest(covidTestDTO);
    }
}
