package com.softwaredesign.mmatoursafe.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CovidTestDTO {
    private Long id;
    private Long idFighter;
    private String date;
    private Boolean result;
}
