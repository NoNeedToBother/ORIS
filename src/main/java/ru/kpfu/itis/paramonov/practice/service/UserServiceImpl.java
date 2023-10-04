package ru.kpfu.itis.paramonov.practice.service;


import ru.kpfu.itis.paramonov.practice.dao.Dao;
import ru.kpfu.itis.paramonov.practice.dao.UserDaoImpl;
import ru.kpfu.itis.paramonov.practice.dto.UserDto;
import ru.kpfu.itis.paramonov.practice.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final Dao<User> dao = new UserDaoImpl();
    @Override
    public List<UserDto> getAll() {
        return dao.getAll().stream().map(
                u -> new UserDto(u.getName(), u.getLastname())
        ).collect(Collectors.toList());
    }

    @Override
    public UserDto get(int id) {
        return null;
    }

    @Override
    public void save(User user) {
        //user.setPassword();
        dao.save(user);
    }
}
