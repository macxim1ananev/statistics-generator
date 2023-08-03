package com.example.statisticsgenerator.core.statistics.commands;

import com.example.statisticsgenerator.core.service.command_bus.Command;
import com.example.statisticsgenerator.core.statistics.entities.UserAnswer;
import com.example.statisticsgenerator.core.user.entities.User;
import lombok.Builder;
import lombok.Value;

import java.util.List;
@Value
@Builder
public class GenerateStatisticsCommand implements Command {
    List<UserAnswer> userAnswers;
    User user;
}
