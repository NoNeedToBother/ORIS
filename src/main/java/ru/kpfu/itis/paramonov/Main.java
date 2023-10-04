package ru.kpfu.itis.paramonov;

import ru.kpfu.itis.paramonov.practice.dao.Dao;
import ru.kpfu.itis.paramonov.practice.dao.UserDaoImpl;
import ru.kpfu.itis.paramonov.practice.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Dao userDao = new UserDaoImpl();
        User user = new User("Ivan", "Popov", "ivan@ya.com", "van'ka", "hihihaha");
        userDao.save(user);
    }
}
