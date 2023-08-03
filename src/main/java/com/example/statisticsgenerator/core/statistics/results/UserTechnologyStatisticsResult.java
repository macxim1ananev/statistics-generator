package com.example.statisticsgenerator.core.statistics.results;

import com.example.statisticsgenerator.core.technology.results.TechnologyResult;
import com.example.statisticsgenerator.core.user.result.UserResult;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserTechnologyStatisticsResult {
    Long id;
    UserResult user;
    TechnologyResult technology;
    int questionCount;
    int totalPoint;
}
