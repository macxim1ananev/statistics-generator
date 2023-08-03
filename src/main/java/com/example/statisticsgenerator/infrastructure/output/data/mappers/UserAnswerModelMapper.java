package com.example.statisticsgenerator.infrastructure.output.data.mappers;

import com.example.statisticsgenerator.core.statistics.entities.UserAnswer;
import com.example.statisticsgenerator.infrastructure.output.data.models.UserAnswerModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserAnswerModelMapper {
    UserAnswer toEntity(UserAnswerModel model);

    UserAnswerModel toModel(UserAnswer userAnswer);
}
