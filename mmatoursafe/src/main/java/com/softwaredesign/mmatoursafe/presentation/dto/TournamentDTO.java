package com.softwaredesign.mmatoursafe.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TournamentDTO {
    private Long id;
    private String name;
    @JsonIgnore
    private List<FighterDTO> fighters;
    @JsonIgnore
    private List<MatchDTO> matches;
    private String startDate;
    private String endDate;
}
