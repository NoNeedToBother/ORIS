package ru.kpfu.itis.paramonov.weather;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import ru.kpfu.itis.paramonov.http_client.HttpClient;
import ru.kpfu.itis.paramonov.http_client.HttpClientImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "weatherServlet", urlPatterns = "/weather")
public class WeatherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("city.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        putWeatherAttr(city, req);
        req.getRequestDispatcher("weather.ftl").forward(req, resp);
    }

    private String API_KEY = "8b4a0acd96ca08b566885cabd39599e7";

    private void putWeatherAttr(String city, HttpServletRequest req) throws IOException {
        String url = "https://api.openweathermap.org/data/2.5/weather";
        HttpClient client = new HttpClientImpl(API_KEY);
        Map<String, String> params = new HashMap<>();
        params.put("q", city);
        params.put("appid", API_KEY);

        String content = client.get(url, params);

        JSONObject json = (JSONObject) JSONValue.parse(content);
        Long code = (Long) json.get("cod");
        if (200 <= code && code < 300) {
            JSONArray weather = (JSONArray) json.get("weather");
            String weatherType = (String) ((JSONObject) weather.get(0)).get("description");
            Double temperature = ((Double) ((JSONObject) json.get("main")).get("temp")) - 273;
            Long humidity = (Long) ((JSONObject) json.get("main")).get("humidity");
            WeatherDto weatherDto = new WeatherDto(temperature, humidity, weatherType);
            req.setAttribute("weatherinfo", weatherDto);
            req.setAttribute("res", 0);
        } else {
            req.setAttribute("res", code);
        }


    }

}
