package com.example.statisticsgenerator.infrastructure.output.data.mappers;

import com.example.statisticsgenerator.core.statistics.UsersStatisticsMapper;
import com.example.statisticsgenerator.core.statistics.entities.UserTechnologyStatistics;
import com.example.statisticsgenerator.infrastructure.output.data.models.UserTechnologyStatisticsModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        imports = {UsersStatisticsMapper.class}
)
public interface UsersTechnologyStatisticsModelMapper {
    UserTechnologyStatisticsModel toModel(UserTechnologyStatistics statistics);

    UserTechnologyStatistics toEntity(UserTechnologyStatisticsModel model);
}
