package com.in28minutes.microservices.limits_service.bean;

public class Limits {

    private int mininimum;
    private int maximum;
    public Limits() {

    }

    public int getMininimum() {
        return mininimum;
    }

    public void setMininimum(int mininimum) {
        this.mininimum = mininimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public Limits(int mininimum, int maximum) {
        this.mininimum = mininimum;
        this.maximum = maximum;
    }

}
