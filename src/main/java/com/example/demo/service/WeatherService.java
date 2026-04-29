package com.example.demo.service;

import com.example.demo.entity.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@Service
public class WeatherService {

	@Value("${openweather.api.key}")
	private String apiKey;

	@Value("${openweather.api.url}")
	private String apiUrl;

	private final RestTemplate restTemplate = new RestTemplate();

	@Cacheable(value = "weatherCache", key = "#city.toLowerCase()")
	
public WeatherResponse getWeather(String city) {
		String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric";

		try {
			Map response = restTemplate.getForObject(url, Map.class);

			WeatherResponse weather = new WeatherResponse();
			weather.setCity(city);

			Map main = (Map) response.get("main");
			weather.setTemperature((Double) main.get("temp"));
			weather.setHumidity(((Number) main.get("humidity")).intValue());

			List weatherList = (List) response.get("weather");
			Map weatherObj = (Map) weatherList.get(0);
			weather.setDescription((String) weatherObj.get("description"));

			Map wind = (Map) response.get("wind");
			weather.setWindSpeed((Double) wind.get("speed"));

			return weather;

		} catch (Exception e) {
			throw new RuntimeException("City not found: " + city);
		}
	}
}