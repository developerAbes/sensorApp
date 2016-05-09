package com.abhijith.sensorapp.bean;

/**
 * Created by abhijith on 08/05/16.
 */
public class MagnetometerDataBean  {

    public String xMagentometer;
    public String yMagentometer;
    public String zMagentometer;

    public MagnetometerDataBean(String xMagentometer, String yMagentometer, String zMagentometer) {
        this.xMagentometer = xMagentometer;
        this.yMagentometer = yMagentometer;
        this.zMagentometer = zMagentometer;
    }

    public String getxMagentometer() {
        return xMagentometer;
    }

    public void setxMagentometer(String xMagentometer) {
        this.xMagentometer = xMagentometer;
    }

    public String getyMagentometer() {
        return yMagentometer;
    }

    public void setyMagentometer(String yMagentometer) {
        this.yMagentometer = yMagentometer;
    }

    public String getzMagentometer() {
        return zMagentometer;
    }

    public void setzMagentometer(String zMagentometer) {
        this.zMagentometer = zMagentometer;
    }

    @Override
    public String toString() {
        return xMagentometer+","+yMagentometer+","+zMagentometer;

    }

}
