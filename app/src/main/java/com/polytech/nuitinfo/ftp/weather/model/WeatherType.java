package com.polytech.nuitinfo.ftp.weather.model;

public enum WeatherType {

    THUNDERSTORM,
    DRIZZLE,
    RAIN,
    SNOW,
    ATMOSPHERE,
    CLEAR,
    CLOUDS;

    public static WeatherType strToWeatherType(String str) {

        for(WeatherType type: WeatherType.values()) {
            if (str.equals(type.name())) {
                return type;
            }
        }

        return null;
    }
}