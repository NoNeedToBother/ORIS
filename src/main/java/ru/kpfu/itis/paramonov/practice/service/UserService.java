package ru.kpfu.itis.paramonov.practice.service;

import ru.kpfu.itis.paramonov.practice.dto.UserDto;
import ru.kpfu.itis.paramonov.practice.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto get(int id);

    void save(User user);
}
