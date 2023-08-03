package com.example.statisticsgenerator.core.statistics;

import com.example.statisticsgenerator.core.statistics.entities.UserTechnologyStatistics;
import com.example.statisticsgenerator.core.statistics.results.FullUserStatisticsResult;
import com.example.statisticsgenerator.core.statistics.results.UserTechnologyStatisticsResult;
import com.example.statisticsgenerator.core.user.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        imports = {UserMapper.class})
public interface UserTechnologyStatisticMapper {
    @Mapping(target = "user", source = "userStatistics.user")
    UserTechnologyStatisticsResult toResult(UserTechnologyStatistics userTechnologyStatistics);

    @Mapping(target = "user", source = "userStatistics.user")
    UserTechnologyStatisticsResult toTechnologyStatisticsResult(UserTechnologyStatistics userTechnologyStatistics);
    FullUserStatisticsResult toFullUserStatisticsResult(UserTechnologyStatistics statistics);
}
