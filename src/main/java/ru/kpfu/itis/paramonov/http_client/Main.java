package ru.kpfu.itis.paramonov.http_client;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        Map<String, String> params = new HashMap<>();
        params.put("id", "100300");
        params.put("name", "Vasya Pupkin");

    }
}