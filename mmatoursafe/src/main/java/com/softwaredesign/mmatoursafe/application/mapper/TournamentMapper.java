package com.softwaredesign.mmatoursafe.application.mapper;

import com.softwaredesign.mmatoursafe.presentation.dto.TournamentDTO;
import com.softwaredesign.mmatoursafe.domain.entity.Tournament;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TournamentMapper {
    private final ModelMapper modelMapper;

    public TournamentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TournamentDTO convertToDTO(Tournament tournament) {
        return modelMapper.map(tournament, TournamentDTO.class);
    }

    public Tournament convertToEntity(TournamentDTO tournamentDTO) {
        return modelMapper.map(tournamentDTO, Tournament.class);
    }
}
