package ru.kpfu.itis.paramonov.http_client;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        Map<String, String> params = new HashMap<>();
        params.put("name", "Vasiliy Pupkin");
        params.put("email", "vasil@test.tt");
        params.put("gender", "female");
        params.put("status", "active");
        System.out.println(client.post("http://localhost:8080/methodHandling", params));

    }
}