package com.example.statisticsgenerator.infrastructure.output.data.mappers;

import com.example.statisticsgenerator.core.question.entities.Question;
import com.example.statisticsgenerator.infrastructure.output.data.models.QuestionModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface QuestionsModelMapper {

    QuestionModel toModel(Question entity);

    Question toEntity(QuestionModel model);
}
