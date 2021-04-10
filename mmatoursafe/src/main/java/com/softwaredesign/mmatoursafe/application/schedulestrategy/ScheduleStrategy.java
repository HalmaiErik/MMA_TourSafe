package com.softwaredesign.mmatoursafe.application.schedulestrategy;

import com.softwaredesign.mmatoursafe.presentation.dto.MatchDTO;

public interface ScheduleStrategy {
    public MatchDTO scheduleMatch(MatchDTO matchDTO);
}
