package com.example.statisticsgenerator.core.service.interfaces;

import com.example.statisticsgenerator.core.service.common.EntityList;
import com.example.statisticsgenerator.core.service.common.ListFilter;
import com.example.statisticsgenerator.core.statistics.entities.UserStatistics;

import java.util.Optional;

public interface UsersStatistics {
    Optional<UserStatistics> get(Long id);

    UserStatistics save(UserStatistics updateStatistics);
}
