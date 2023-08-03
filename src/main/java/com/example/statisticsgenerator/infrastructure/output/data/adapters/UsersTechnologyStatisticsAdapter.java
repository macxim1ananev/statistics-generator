package com.example.statisticsgenerator.infrastructure.output.data.adapters;

import com.example.statisticsgenerator.core.service.common.EntityList;
import com.example.statisticsgenerator.core.service.common.ListFilter;
import com.example.statisticsgenerator.core.service.interfaces.UsersTechnologyStatistics;
import com.example.statisticsgenerator.core.statistics.entities.UserTechnologyStatistics;
import com.example.statisticsgenerator.infrastructure.output.data.FilteringAndSortingAdapter;
import com.example.statisticsgenerator.infrastructure.output.data.mappers.UsersTechnologyStatisticsModelMapper;
import com.example.statisticsgenerator.infrastructure.output.data.models.UserTechnologyStatisticsModel;
import com.example.statisticsgenerator.infrastructure.output.data.repositories.UsersTechnologyStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsersTechnologyStatisticsAdapter extends FilteringAndSortingAdapter<UserTechnologyStatisticsModel> implements UsersTechnologyStatistics {
    private final UsersTechnologyStatisticsRepository repository;
    private final UsersTechnologyStatisticsModelMapper mapper;

    @Override
    public UserTechnologyStatistics save(UserTechnologyStatistics statistics) {
        var model = mapper.toModel(statistics);
        return mapper.toEntity(repository.save(model));
    }

    @Override
    public List<UserTechnologyStatistics> getById(Long id) {
        return repository.findAllByUserStatisticsId(id).stream().map(mapper::toEntity).collect(Collectors.toList());
    }

    @Override
    public EntityList<UserTechnologyStatistics> getAll(ListFilter filter) {
        var page = repository.findAll(getSpecification(filter), getPageable(filter));
        return new EntityList<>(page.getTotalElements(), page.map(mapper::toEntity).getContent());
    }
}
