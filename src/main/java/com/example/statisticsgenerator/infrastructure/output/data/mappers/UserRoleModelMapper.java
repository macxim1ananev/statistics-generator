package com.example.statisticsgenerator.infrastructure.output.data.mappers;

import com.example.statisticsgenerator.core.user.entities.UserRole;
import com.example.statisticsgenerator.infrastructure.output.data.models.UserRoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserRoleModelMapper extends BaseModelMapper<UserRole, UserRoleModel>{

    @Mapping(target = "permissions", ignore = true)
    UserRoleModel toModel(UserRole entity);

    Set<UserRole> toEntity(Set<UserRoleModel> userRoleModels);
}
