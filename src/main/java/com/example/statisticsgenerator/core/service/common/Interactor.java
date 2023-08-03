package com.example.statisticsgenerator.core.service.common;

import com.example.statisticsgenerator.core.service.command_bus.Command;

import javax.validation.constraints.NotNull;

@FunctionalInterface
public interface Interactor<T extends Command, R> {

    R execute(@NotNull T t);
}
