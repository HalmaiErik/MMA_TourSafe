package com.softwaredesign.mmatoursafe.application.mapper;

import com.softwaredesign.mmatoursafe.presentation.dto.MatchDTO;
import com.softwaredesign.mmatoursafe.domain.entity.Match;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {
    private final ModelMapper modelMapper;

    public MatchMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public MatchDTO convertToDTO(Match match) {
        return modelMapper.map(match, MatchDTO.class);
    }

    public Match convertToEntity(MatchDTO matchDTO) {
        return modelMapper.map(matchDTO, Match.class);
    }
}
