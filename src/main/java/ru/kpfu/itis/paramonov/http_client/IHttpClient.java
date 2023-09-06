package ru.kpfu.itis.paramonov.http_client;

import java.util.Map;

public interface IHttpClient {
    String get(String url, Map<String, String> params);
    String post(String url, Map<String, String> params);
    String put(String url, Map<String, String> params);
    String delete(String url, Map<String, String> params);
}
