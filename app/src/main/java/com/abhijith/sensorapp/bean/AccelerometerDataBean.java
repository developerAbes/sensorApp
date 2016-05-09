package com.abhijith.sensorapp.bean;

/**
 * Created by abhijith on 08/05/16.
 */
public class AccelerometerDataBean {

    public String xAcceleration;
    public String yAcceleration ;
    public String zAcceleration ;

    public AccelerometerDataBean(String xAcceleration, String yAcceleration, String zAcceleration) {
        this.xAcceleration = xAcceleration;
        this.yAcceleration = yAcceleration;
        this.zAcceleration = zAcceleration;
    }

    public String getxAcceleration() {
        return xAcceleration;
    }

    public void setxAcceleration(String xAcceleration) {
        this.xAcceleration = xAcceleration;
    }

    public String getyAcceleration() {
        return yAcceleration;
    }

    public void setyAcceleration(String yAcceleration) {
        this.yAcceleration = yAcceleration;
    }

    public String getzAcceleration() {
        return zAcceleration;
    }

    public void setzAcceleration(String zAcceleration) {
        this.zAcceleration = zAcceleration;
    }

    @Override
    public String toString() {
        return xAcceleration+","+yAcceleration+","+zAcceleration;

    }
}
