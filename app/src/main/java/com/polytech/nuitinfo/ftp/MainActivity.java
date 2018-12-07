package com.polytech.nuitinfo.ftp;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.polytech.nuitinfo.ftp.weather.connection.JSONWeatherDownloader;
import com.polytech.nuitinfo.ftp.weather.connection.JSONWeatherParser;
import com.polytech.nuitinfo.ftp.weather.model.Weather;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    private TextView weatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String city = "tours, france";

        weatherTextView = findViewById(R.id.activity_main_weather_textview);

        JSONWeatherTask task = new JSONWeatherTask();
        task.execute(city);
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

            Double temp = weather.getTemperature().getValue() - 273.15;
            weatherTextView.setText(String.valueOf(temp.intValue()) + "°C");
        }
    }
}
