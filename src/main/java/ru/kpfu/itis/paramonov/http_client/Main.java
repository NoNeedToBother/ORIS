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
        System.out.println(client.post("https://gorest.co.in/public/v2/users/", params));
        Map<String, String> test = new HashMap<>();
        test.put("name", "Vasiliy Pupkin");
        System.out.println(client.get("https://gorest.co.in/public/v2/users", test));
        System.out.println(client.delete("https://gorest.co.in/public/v2/users/5122121", test));
        System.out.println(client.get("https://gorest.co.in/public/v2/users", test));
    }
}