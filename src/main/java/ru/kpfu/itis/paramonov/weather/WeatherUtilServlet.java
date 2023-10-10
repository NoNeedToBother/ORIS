package ru.kpfu.itis.paramonov.weather;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import ru.kpfu.itis.paramonov.http_client.HttpClient;
import ru.kpfu.itis.paramonov.http_client.HttpClientImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/weather/util")
public class WeatherUtilServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        putWeatherAttr(req.getParameter("city"), req);

        resp.setContentType("text/plain");

        String content = "Result: \n" +
                "Temperate: %s \n" +
                "Humidity: %s \n" +
                "Weather type: %s \n";

        WeatherDto weather = (WeatherDto) req.getAttribute("weatherinfo");

        resp.getWriter().write(String.format(content, weather.getTemperature(), weather.getHumidity(),
                weather.getWeathertype()));
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

        HttpSession session = req.getSession();
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
