package com.example.statisticsgenerator.core.statistics;

import com.example.statisticsgenerator.core.statistics.entities.UserStatistics;
import com.example.statisticsgenerator.core.statistics.results.UserStatisticsResult;
import com.example.statisticsgenerator.core.user.UserMapper;
import com.example.statisticsgenerator.infrastructure.output.data.models.UsersStatisticsModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        imports = {UserMapper.class})
public interface UsersStatisticsMapper {
    UserStatistics toEntity(UsersStatisticsModel model);

    UsersStatisticsModel toModel(UserStatistics statistics);

    UserStatisticsResult toResult(UserStatistics entity);
}
