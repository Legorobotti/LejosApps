package runnables;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import util.DATA;
import lejos.utility.Delay;

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
				System.out.println("V‰istˆliike!");
				vaistoliike(motorA, motorB);
			}
			else {
				if (DATA.ambient - DATA.ambientViimeksi < -0.05) {
					System.out.println("K‰‰nnyn vasemmalle!");
					vasemmalle(motorA, motorB);
				} 
				else if (DATA.ambient - DATA.ambientViimeksi > 0.05) {
					System.out.println("K‰‰nnyn oikealle!");
					oikealle(motorA, motorB);
				} else {
					
					System.out.println("Eteenp‰in sanoi mummo lumessa!");
					DATA.directionA=1;
					DATA.directionB=1;
					motorA.forward();
					motorB.forward();
				}

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
		DATA.vaistoliike = true;
		
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
        
        //Delay.msDelay(2500);
        
        // Look for dark
        while (DATA.vaistoliike) {
	        if (DATA.ambient == 0.5) {
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
		        
		        DATA.vaistoliike = false;
	        }
        }

        motorA.stop();
        motorB.stop();
	}
	
	public void vasemmalle(UnregulatedMotor motorA, UnregulatedMotor motorB) {
		motorA.stop();
        motorB.stop();
		DATA.directionA=0;
		DATA.directionB=1;
        //motorA.forward();
        motorB.forward();
        
        Delay.msDelay(100);
        
        motorA.stop();
        motorB.stop();
	}
	
	public void oikealle(UnregulatedMotor motorA, UnregulatedMotor motorB) {
		motorA.stop();
        motorB.stop();
		DATA.directionA=1;
		DATA.directionB=0;
        motorA.forward();
        //motorB.forward();
        
        Delay.msDelay(100);
        
        motorA.stop();
        motorB.stop();
	}

}
