package app;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;
import library.*;

public class KiertoTesti {

	public static void main(String[] args) {		
		UltraSonicSensor ultra = new UltraSonicSensor(SensorPort.S1);
		
		System.out.println("Go around an obstacle\n");
	    System.out.println("Press any key to start");
	       
	    Button.LEDPattern(4);    // flash green led and 
	    Sound.beepSequenceUp();  // make sound when ready.

	    Button.waitForAnyPress();
	    
	    UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	    UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
	    
	    motorA.setPower(50);
	    motorB.setPower(50);
	    
	    while (Button.ESCAPE.isUp()) 
	       {	           
	           // watch for obstacle.
	           if (ultra.getRange() < .05)
	           {
	        	   vaistoliike(motorA, motorB);
	           }
	           
	           Delay.msDelay(50);
	    }
	       
	       // stop motors with brakes on.
	    motorA.stop();
	    motorB.stop();

	       // free up resources.
	    motorA.close();
	    motorB.close();
	    ultra.close();
	       
	    Sound.beepSequence(); // we are done.

	}
	
	public static void vaistoliike(UnregulatedMotor motorA, UnregulatedMotor motorB) {
 	   motorA.stop();
 	   motorB.stop();

        // Turn to the right about 90 degrees
        motorA.forward();
        motorB.backward();
        
        Delay.msDelay(750);
        
        motorA.stop();
        motorB.stop();
        
        // Go around the obstacle
        motorA.setPower(30);
        motorB.setPower(70);
        
        motorA.forward();
        motorB.forward();
        
        Delay.msDelay(2000);
        
        motorA.stop();
        motorB.stop();
        
        // Turn to the right about 90 degrees
        motorA.forward();
        motorB.backward();
        
        Delay.msDelay(750);
        
        motorA.stop();
        motorB.stop();
        
	}

}
