package com.polytech.nuitinfo.ftp.weather.model;

public class Temperature {

    private float value;
    private float min;
    private float max;

    public float getValue() {
        return value;
    }

    public void setValue( Float value ) {
        this.value = value;
    }

    public float getMin() {
        return min;
    }

    public void setMin( Float min ) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax( Float max ) {
        this.max = max;
    }
}