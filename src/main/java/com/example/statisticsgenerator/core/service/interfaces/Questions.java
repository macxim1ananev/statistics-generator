package com.example.statisticsgenerator.core.service.interfaces;

import com.example.statisticsgenerator.core.question.entities.Question;
import com.example.statisticsgenerator.core.service.common.EntityList;
import com.example.statisticsgenerator.core.service.common.ListFilter;

import java.util.List;
import java.util.Optional;

public interface Questions {
    Question put(Question entity);

    List<Question> getAllByUserId(long authorId);

    EntityList<Question> getAll(ListFilter filter);

    Optional<Question> getById(long id);
}
