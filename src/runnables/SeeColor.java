package runnables;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import util.DATA;
import sensors.ColorSensor;
import lejos.robotics.Color;

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
			color.setRedMode();
			color.setFloodLight(Color.RED);
			color.setFloodLight(true);
			DATA.ambientViimeksi = DATA.ambient;
			DATA.ambient = color.getRed();
			
		}
	}

}
