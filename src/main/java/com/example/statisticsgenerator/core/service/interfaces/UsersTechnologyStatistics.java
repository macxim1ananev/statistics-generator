package com.example.statisticsgenerator.core.service.interfaces;

import com.example.statisticsgenerator.core.service.common.EntityList;
import com.example.statisticsgenerator.core.service.common.ListFilter;
import com.example.statisticsgenerator.core.statistics.entities.UserTechnologyStatistics;

import java.util.List;

public interface UsersTechnologyStatistics {
    UserTechnologyStatistics save(UserTechnologyStatistics userTechnologyStatistics);

    List<UserTechnologyStatistics> getById(Long id);
    EntityList<UserTechnologyStatistics> getAll(ListFilter filter);
}
