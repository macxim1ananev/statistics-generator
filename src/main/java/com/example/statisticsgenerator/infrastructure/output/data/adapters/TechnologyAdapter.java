package com.example.statisticsgenerator.infrastructure.output.data.adapters;

import com.example.statisticsgenerator.core.service.common.EntityList;
import com.example.statisticsgenerator.core.service.common.ListFilter;
import com.example.statisticsgenerator.core.service.interfaces.Technologies;
import com.example.statisticsgenerator.core.technology.entities.Technology;
import com.example.statisticsgenerator.infrastructure.output.data.FilteringAndSortingAdapter;
import com.example.statisticsgenerator.infrastructure.output.data.mappers.TechnologyModelMapper;
import com.example.statisticsgenerator.infrastructure.output.data.models.TechnologyModel;
import com.example.statisticsgenerator.infrastructure.output.data.repositories.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TechnologyAdapter extends FilteringAndSortingAdapter<TechnologyModel> implements Technologies {
    private final TechnologyRepository repository;
    private final TechnologyModelMapper mapper;

    @Override
    public Technology put(Technology entity) {
        var model = mapper.toModel(entity);
        return mapper.toEntity(repository.save(model));
    }

    @Override
    public EntityList<Technology> getAll(ListFilter filter) {
        var page = repository.findAll(getSpecification(filter), getPageable(filter));
        return new EntityList<>(page.getTotalElements(), page.map(mapper::toEntity).getContent());
    }

    @Override
    public Optional<Technology> get(Long id) {
        return repository.findById(id).map(mapper::toEntity);
    }
}
