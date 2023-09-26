package ru.kpfu.itis.paramonov.weather;

public class WeatherDto {
    private Double temperature;
    private Long humidity;
    private String weathertype;

    public WeatherDto(Double temperature, Long humidity, String weathertype) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.weathertype = weathertype;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Long getHumidity() {
        return humidity;
    }

    public String getWeathertype() {
        return weathertype;
    }
}
