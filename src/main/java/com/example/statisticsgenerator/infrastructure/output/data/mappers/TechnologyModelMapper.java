package com.example.statisticsgenerator.infrastructure.output.data.mappers;

import com.example.statisticsgenerator.core.technology.entities.Technology;
import com.example.statisticsgenerator.infrastructure.output.data.models.TechnologyModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TechnologyModelMapper {
    TechnologyModel toModel(Technology entity);

    Technology toEntity(TechnologyModel put);
}
