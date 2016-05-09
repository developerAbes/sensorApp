package com.abhijith.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.abhijith.sensorapp.sensordataproviders.AccelerometerDataProvider;
import com.abhijith.sensorapp.sensordataproviders.MagnetometerDataProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AccelerometerDataProvider accelerometerDataProvider;
    MagnetometerDataProvider magnetometerDataProvider;
    private SensorManager mSensorManager;
    private  Sensor mMagnetometer;

    Button trigger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometerDataProvider=new AccelerometerDataProvider(this);
        magnetometerDataProvider=new MagnetometerDataProvider(this);

        trigger= (Button) findViewById(R.id.btn_trigger);

        trigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    magnetometerDataProvider.initMagnetometerDataProvider();                }

        });

    }

}
