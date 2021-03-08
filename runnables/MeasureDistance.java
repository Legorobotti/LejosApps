package runnables;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import util.DATA;
import sensors.UltraSonicSensor;

public class MeasureDistance implements Runnable{
    UltraSonicSensor uss = new UltraSonicSensor(SensorPort.S1);

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(DATA.shouldRun) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        DATA.distance = uss.getRange();
		}
	}

}