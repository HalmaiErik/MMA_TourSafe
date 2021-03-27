package com.softwaredesign.mmatoursafe.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softwaredesign.mmatoursafe.domain.entity.CovidTest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FighterDTO {
    private Long id;
    private String name;
    private int age;
    private String weightClass;
    private Long idTournament;
    @JsonIgnore
    private List<CovidTest> tests;
}
