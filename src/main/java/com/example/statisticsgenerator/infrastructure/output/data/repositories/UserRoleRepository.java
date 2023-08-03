package com.example.statisticsgenerator.infrastructure.output.data.repositories;

import com.example.statisticsgenerator.infrastructure.output.data.models.UserRoleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRoleModel, Long> {

    Page<UserRoleModel> findAll(Specification<UserRoleModel> specification, Pageable pageable);

    Optional<UserRoleModel> findByCode(String code);
}
