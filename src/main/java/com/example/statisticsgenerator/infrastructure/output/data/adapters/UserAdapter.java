package com.example.statisticsgenerator.infrastructure.output.data.adapters;

import com.example.statisticsgenerator.core.service.interfaces.Users;
import com.example.statisticsgenerator.core.user.entities.User;
import com.example.statisticsgenerator.infrastructure.output.data.mappers.UserModelMapper;
import com.example.statisticsgenerator.infrastructure.output.data.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserAdapter implements Users {
    private final UserRepository repository;
    private final UserModelMapper mapper;

    @Override
    public Optional<User> get(long id) {
        return repository.findById(id).map(mapper::toEntity);
    }
}
