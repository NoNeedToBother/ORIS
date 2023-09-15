package ru.kpfu.itis.paramonov.method_handling_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.stream.Collectors;


@WebServlet(name = "methodHandlingServlet", urlPatterns = "/methodHandling")
public class MethodHandlingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printInfo(req);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printInfo(req);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printInfo(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printInfo(req);
    }

    private void printInfo(HttpServletRequest req) throws IOException{
        printParameters(req);
        printBody(req);
        printHeaders(req);
    }

    private void printParameters(HttpServletRequest req) {
        System.out.println("Parameters: \n");

        for (String parameter : Collections.list(req.getParameterNames())) {
            System.out.printf("%s: %s\n", parameter, req.getParameter(parameter));
        }
    }

    private void printBody(HttpServletRequest req) throws IOException{
        System.out.println("Body: \n");
        StringBuilder body = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            body.append(reader.readLine()).append("\n");
        }
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("Headers: \n");

        for (String name : Collections.list(req.getHeaderNames())) {
            System.out.printf("%s: %s\n", name, req.getHeader(name));
        }
    }
}
