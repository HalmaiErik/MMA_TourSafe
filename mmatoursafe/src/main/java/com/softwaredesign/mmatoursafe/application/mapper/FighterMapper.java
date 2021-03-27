package com.softwaredesign.mmatoursafe.application.mapper;

import com.softwaredesign.mmatoursafe.presentation.dto.FighterDTO;
import com.softwaredesign.mmatoursafe.domain.entity.Fighter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FighterMapper {
    private final ModelMapper modelMapper;

    public FighterMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FighterDTO convertToDTO(Fighter fighter) {
        return modelMapper.map(fighter, FighterDTO.class);
    }

    public Fighter convertToEntity(FighterDTO fighterDTO) {
        return modelMapper.map(fighterDTO, Fighter.class);
    }
}
