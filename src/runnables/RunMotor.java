package runnables;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import util.DATA;

public class RunMotor implements Runnable{
    UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
    UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);

	@Override
	public void run() {
		while (DATA.shouldRun) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (DATA.distance<0.1) {
				vaistoliike(motorA, motorB);
			}
			else {
				DATA.directionA=1;
				DATA.directionB=1;
				motorA.forward();
				motorB.forward();
			}
			
		}
	}
	public void startMotor() {
    	motorA.setPower(50);
    	motorB.setPower(50);
	}
	public void stopMotor() {
		DATA.shouldRun=false;
	}
	
	public void vaistoliike(UnregulatedMotor motorA, UnregulatedMotor motorB) {
	 	   motorA.stop();
	 	   motorB.stop();

	        // Turn to the right about 90 degrees
			DATA.directionA=1;
			DATA.directionB=-1;
	        motorA.forward();
	        motorB.backward();
	        
	        Delay.msDelay(600);
	        
	        motorA.stop();
	        motorB.stop();
	        
	        // Go around the obstacle
	        motorA.setPower(40);
	        motorB.setPower(70);
	        
			DATA.directionA=1;
			DATA.directionB=1;
	        motorA.forward();
	        motorB.forward();
	        
	        Delay.msDelay(5000);
	        
	        motorA.stop();
	        motorB.stop();
	        
	        // Set both motors back to 50
	        motorA.setPower(50);
	        motorB.setPower(50);
	        
	        // Turn to the right about 90 degrees
			DATA.directionA=1;
			DATA.directionB=-1;
	        motorA.forward();
	        motorB.backward();
	        
	        Delay.msDelay(600);
	        
	        motorA.stop();
	        motorB.stop();
	}

}
