package com.abhijith.sensorapp.sensordataproviders;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Environment;
import android.widget.Toast;

import com.abhijith.sensorapp.bean.MagnetometerDataBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhijith on 07/05/16.
 */
public class MagnetometerDataProvider implements SensorEventListener{

    Context mContext;
    private SensorManager mSensorManager;
    List<MagnetometerDataBean> magnetometerValues;
    private Sensor mMagnetometer;
    MagnetometerDataBean magnetometerDataBean;


    public MagnetometerDataProvider(Context context){
        this.mContext=context;
    }


    public void initMagnetometerDataProvider(){
        mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        mMagnetometer=mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_NORMAL);

        Toast.makeText(mContext,
                "Entered Magnetometer Readings",
                Toast.LENGTH_SHORT).show();

        magnetometerValues=new ArrayList<>();
    }


    public void getMagnetometerData(SensorEvent event){

        magnetometerDataBean.setxMagentometer(String.valueOf(event.values[0]));
        /*magnetometerDataBean.setyMagentometer(String.valueOf(event.values[1]));
        magnetometerDataBean.setzMagentometer(String.valueOf(event.values[2]));
*/
        magnetometerValues.add(magnetometerDataBean);

        writeAccelerometerDataToFile();
    }

    private void writeAccelerometerDataToFile() {

        try {
            writeToFile(magnetometerValues);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        getMagnetometerData(event);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void writeToFile(List<MagnetometerDataBean> sensorData) throws IOException{

        File myFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"MagnetometerData.txt");
        myFile.createNewFile();
        FileOutputStream fOut = new FileOutputStream(myFile);
        OutputStreamWriter myOutWriter =
                new OutputStreamWriter(fOut);
        myOutWriter.append("Entered Magnetometer Readings");
        for(MagnetometerDataBean sData:sensorData) {
            myOutWriter.append(sData+"\n");
        }
        myOutWriter.close();
        fOut.close();
        Toast.makeText(mContext,
                "Done writing SD MagnetometerData.txt",
                Toast.LENGTH_SHORT).show();

    }
}
