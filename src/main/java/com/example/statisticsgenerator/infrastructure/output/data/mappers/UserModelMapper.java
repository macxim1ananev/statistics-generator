package com.example.statisticsgenerator.infrastructure.output.data.mappers;

import com.example.statisticsgenerator.core.user.entities.User;
import com.example.statisticsgenerator.infrastructure.output.data.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserModelMapper {
    UserModel toModel(User entity);
    User toEntity(UserModel model);
}
