package com.example.statisticsgenerator.infrastructure.output.data.adapters;

import com.example.statisticsgenerator.core.service.common.EntityList;
import com.example.statisticsgenerator.core.service.common.ListFilter;
import com.example.statisticsgenerator.core.service.interfaces.UsersStatistics;
import com.example.statisticsgenerator.core.statistics.UsersStatisticsMapper;
import com.example.statisticsgenerator.core.statistics.entities.UserStatistics;
import com.example.statisticsgenerator.infrastructure.output.data.FilteringAndSortingAdapter;
import com.example.statisticsgenerator.infrastructure.output.data.models.UsersStatisticsModel;
import com.example.statisticsgenerator.infrastructure.output.data.repositories.UsersStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsersStatisticsAdapter extends FilteringAndSortingAdapter<UsersStatisticsModel> implements UsersStatistics {
    private final UsersStatisticsRepository repository;
    private final UsersStatisticsMapper mapper;

    @Override
    public Optional<UserStatistics> get(Long id) {
        return repository.findByUserId(id).map(mapper::toEntity);
    }

    @Override
    public UserStatistics save(UserStatistics statistics) {
        var model = mapper.toModel(statistics);
        return mapper.toEntity(repository.save(model));
    }
}
