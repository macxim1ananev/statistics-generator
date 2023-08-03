package com.example.statisticsgenerator.core.statistics.results;

import com.example.statisticsgenerator.core.user.result.UserResult;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserStatisticsResult {
    Long id;
    UserResult user;
    int totalOneToOneCount;
    int totalQuestionCount;
    int totalPoint;
}
