package com.softwaredesign.mmatoursafe.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class MatchDTO {
    private Long id;
    private FighterDTO fighter1;
    private FighterDTO fighter2;
    private TournamentDTO tournament;
    private String dateTime;
}
