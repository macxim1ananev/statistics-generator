package com.example.statisticsgenerator.core.service.interfaces;
import com.example.statisticsgenerator.core.user.entities.User;

import java.util.Optional;

public interface Users {

    Optional<User> get(long id);
}
