package com.polytech.nuitinfo.ftp.weather.model;

public class Location {

    private float longitude;
    private float latitude;
    private long sunset;
    private long sunrise;
    private String country;
    private String city;

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float locationLongitude) {
        this.longitude = locationLongitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float locationLatitude) {
        this.latitude = locationLatitude;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset( long sunset ) {
        this.sunset = sunset;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise( long sunrise ) {
        this.sunrise = sunrise;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }
}