package com.polytech.nuitinfo.ftp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.polytech.nuitinfo.ftp.weather.connection.JSONWeatherDownloader;
import com.polytech.nuitinfo.ftp.weather.connection.JSONWeatherParser;
import com.polytech.nuitinfo.ftp.weather.model.Weather;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    private Button weatherButton;
    private ImageView weatherIcon;
    private TextView weatherTemperature;
    private TextView weatherCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String city = "tours, france";

        weatherButton = findViewById(R.id.activity_main_weather_button);
        weatherTemperature = findViewById(R.id.activity_main_weather_temperature);
        weatherCity = findViewById(R.id.activity_main_weather_city);
        weatherIcon = findViewById(R.id.activity_main_weather_icon);

        JSONWeatherTask task = new JSONWeatherTask();
        task.execute(city);

        weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });
    }

    private class JSONWeatherTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected Weather doInBackground(String... params) {
            Weather weather = new Weather();

            String data = ((new JSONWeatherDownloader()).getWeatherData(params[0]));

            try {
                weather = JSONWeatherParser.getWeather(data);

                // Let's retrieve the icon
                weather.setIcon((new JSONWeatherDownloader()).getWeatherImage(weather.getCondition().getIcon()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return weather;

        }

        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

            if(weather.getCondition().getType().equals("Thunderstorm")) {
                weatherIcon.setImageResource(R.drawable.weather_storm);
            } else if (weather.getCondition().getType().equals("Drizzle")) {
                weatherIcon.setImageResource(R.drawable.weather_drizzle);
            } else if (weather.getCondition().getType().equals("Rain")) {
                weatherIcon.setImageResource(R.drawable.weather_rain);
            } else if (weather.getCondition().getType().equals("Snow")) {
                weatherIcon.setImageResource(R.drawable.weather_snow);
            } else if (weather.getCondition().getType().equals("Clear")) {
                weatherIcon.setImageResource(R.drawable.weather_clear);
            } else if (weather.getCondition().getType().equals("Clouds")) {
                weatherIcon.setImageResource(R.drawable.weather_clouds);
            }

            Double temp = weather.getTemperature().getValue() - 273.15;
            weatherTemperature.setText(String.valueOf(temp.intValue()) + "°C");

            weatherCity.setText("(" + weather.getLocation().getCity() + ")");
        }
    }
}
