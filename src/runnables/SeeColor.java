package runnables;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import util.DATA;
import sensors.ColorSensor;

public class SeeColor implements Runnable{
	ColorSensor    color = new ColorSensor(SensorPort.S3);
	
	@Override
	public void run() {
		while(DATA.shouldRun) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//color.setColorIdMode();
			//color.setFloodLight(false);
	        //DATA.colorID = ColorSensor.colorName(color.getColorID());
	        //System.out.println(DATA.colorID);
			DATA.ambient = color.getAmbient();
			//System.out.println(DATA.ambient);
		}
	}

}
