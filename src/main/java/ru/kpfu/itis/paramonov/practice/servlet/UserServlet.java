package ru.kpfu.itis.paramonov.practice.servlet;

import ru.kpfu.itis.paramonov.practice.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "userServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    private static final List<UserDto> USERS = setUsers();

    private static List<UserDto> setUsers() {
        List<UserDto> res = new ArrayList<>();
        res.add(0, new UserDto("Vasya", "Pupkin"));
        res.add(1, new UserDto("Hihi", "Haha"));
        return res;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", USERS);
        req.getRequestDispatcher("users.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
