package com.polytech.nuitinfo.ftp.weather.connection;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONWeatherDownloader {

    private static String REQUEST_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static String IMAGE_URL = "http://openweathermap.org/img/w/";


    public String getWeatherData(String location) {

        String url = REQUEST_URL + location + "&APPID=a0d3e8b6718a0d657e1eb659e20fd283";

        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            connection = (HttpURLConnection) ( new URL(url).openConnection());
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            StringBuffer stringBuffer = new StringBuffer();
            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line =bufferedReader.readLine()) != null) {
                stringBuffer.append(line + "\r\n");
            }

            inputStream.close();
            connection.disconnect();
            return stringBuffer.toString();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            try {
                connection.disconnect();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

        }

        return null;
    }

    public byte[] getWeatherImage(String weatherCode) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            connection = (HttpURLConnection) ( new URL(IMAGE_URL + weatherCode).openConnection());
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            inputStream = connection.getInputStream();
            byte[] byteBuffer = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            while (inputStream.read(byteBuffer) != -1) {
                byteArrayOutputStream.write(byteBuffer);
            }

            return byteArrayOutputStream.toByteArray();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

            try {
                connection.disconnect();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

        }

        return null;
    }
}