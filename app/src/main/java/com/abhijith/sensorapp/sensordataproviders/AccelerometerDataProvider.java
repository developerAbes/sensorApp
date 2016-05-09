package com.abhijith.sensorapp.sensordataproviders;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Environment;
import android.provider.SyncStateContract;
import android.widget.Toast;

import com.abhijith.sensorapp.bean.AccelerometerDataBean;
import com.abhijith.sensorapp.common.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhijith on 07/05/16.
 */
public class AccelerometerDataProvider implements SensorEventListener{

    Context mContext;
    private SensorManager mSensorManager;
    List<AccelerometerDataBean> accelerometerValues;
    private Sensor mAccelerometer;
    AccelerometerDataBean accelerometerDataBean;


    public AccelerometerDataProvider(Context context){
        this.mContext=context;
    }


    public void initAccelerometerProvider(){

        mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);


        Toast.makeText(mContext,
                "Done writing SD 'mysdfile.txt'",
                Toast.LENGTH_SHORT).show();

        accelerometerValues=new ArrayList<>();
    }


    public void getAccelerometerData(SensorEvent event){

            accelerometerDataBean.setxAcceleration(String.valueOf(event.values[0]));
            accelerometerDataBean.setyAcceleration(String.valueOf(event.values[1]));
            accelerometerDataBean.setzAcceleration(String.valueOf(event.values[2]));

            accelerometerValues.add(accelerometerDataBean);


            writeAccelerometerDataToFile();
    }

    private void writeAccelerometerDataToFile() {

        try {
            writeToFile(accelerometerValues);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        long lastSaved = System.currentTimeMillis();

        // getAccelerometerData(event);
        if ((System.currentTimeMillis() - lastSaved) > Constants.ACCELERATION_FILTER_DATA_DEFAULT_TIME) {
            lastSaved = System.currentTimeMillis();
            getAccelerometerData(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void writeToFile(List<AccelerometerDataBean> sensorData) throws IOException{

        File myFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/AccelerometerData.txt");
        myFile.createNewFile();
        FileOutputStream fOut = new FileOutputStream(myFile);
        OutputStreamWriter myOutWriter =
                new OutputStreamWriter(fOut);
        for(AccelerometerDataBean sData:sensorData) {
            myOutWriter.append(sData+"\n");
        }
        myOutWriter.close();
        fOut.close();
        Toast.makeText(mContext,
                "Done writing SD 'AccelerometerData.txt'",
                Toast.LENGTH_SHORT).show();

    }
}
