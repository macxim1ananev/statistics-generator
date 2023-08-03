package com.example.statisticsgenerator.core.service.command_bus;

public interface CommandBus {

    <C extends Command, R> R execute(C command);
}