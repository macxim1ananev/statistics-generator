package com.example.statisticsgenerator.core.statistics.results;

import com.example.statisticsgenerator.core.technology.results.TechnologyResult;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FullUserStatisticsResult {
    Long id;
    UserStatisticsResult userStatistics;
    TechnologyResult technology;
    int questionCount;
    int totalPoint;
}
