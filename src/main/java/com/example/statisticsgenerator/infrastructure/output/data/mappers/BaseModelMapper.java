package com.example.statisticsgenerator.infrastructure.output.data.mappers;

import java.util.List;

public interface BaseModelMapper<E, M> {

    M toModel(E entity);

    E toEntity(M model);

    List<E> toEntityList(List<M> modelList);
}
