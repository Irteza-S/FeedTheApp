package com.polytech.nuitinfo.ftp.weather.model;

import android.support.annotation.Nullable;

public class Weather {

    private Location location;

    private WeatherCondition condition;

    private Temperature temperature;
    private Wind wind;
    @Nullable
    private Rain rain;

    @Nullable
    private Snow  snow;
    private Clouds clouds;
    private byte[] icon;

    public Weather() {
        location = new Location();
        condition = new WeatherCondition();
        temperature = new Temperature();
        wind = new Wind();
        clouds = new Clouds();
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation( Location location ) {
        this.location = location;
    }

    public WeatherCondition getCondition() {
        return condition;
    }

    public void setCondition( WeatherCondition condition ) {
        this.condition = condition;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature( Temperature temperature ) {
        this.temperature = temperature;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind( Wind wind ) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain( Rain rain ) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow( Snow snow ) {
        this.snow = snow;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds( Clouds clouds ) {
        this.clouds = clouds;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon( byte[] icon ) {
        this.icon = icon;
    }
}