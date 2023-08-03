package com.example.statisticsgenerator.core.user;

import com.example.statisticsgenerator.core.user.entities.User;
import com.example.statisticsgenerator.core.user.entities.UserStatus;
import com.example.statisticsgenerator.core.user.result.UserResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        imports = {UserStatus.class}
)
public interface UserMapper {
}
