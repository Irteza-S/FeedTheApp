package com.polytech.nuitinfo.ftp.weather.model;

public class WeatherCondition {

    private Integer     ID;
    private String type;
    private String      description;
    private String      icon;
    private float       pressure;
    private float       humidity;

    public Integer getID() {
        return ID;
    }

    public void setID( Integer ID ) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon( String icon ) {
        this.icon = icon;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure( float pressure ) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity( float humidity ) {
        this.humidity = humidity;
    }
}
