package com.softwaredesign.mmatoursafe.application.mapper;

import com.softwaredesign.mmatoursafe.presentation.dto.CovidTestDTO;
import com.softwaredesign.mmatoursafe.domain.entity.CovidTest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CovidTestMapper {
    private final ModelMapper modelMapper;

    public CovidTestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CovidTestDTO convertToDTO(CovidTest covidTest) {
        return modelMapper.map(covidTest, CovidTestDTO.class);
    }

    public CovidTest convertToEntity(CovidTestDTO covidTestDTO) {
        return modelMapper.map(covidTestDTO, CovidTest.class);
    }
}
