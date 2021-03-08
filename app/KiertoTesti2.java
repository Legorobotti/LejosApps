package app;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;
import runnables.MeasureDistance;
import runnables.RunMotor;

public class KiertoTesti2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunMotor runMotor=new RunMotor();
		MeasureDistance measureDistance=new MeasureDistance();
		
		Thread motor=new Thread(runMotor);
		Thread distance=new Thread(measureDistance);
		
        System.out.println("Drive Forward\nand Backward\n");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);     // flash green led and
        Sound.beepSequenceUp();   // make sound when ready.

        Button.waitForAnyPress();
        
        
        motor.start();
        distance.start();
        runMotor.startMotor();
        
        System.out.println("Press any key to STOP");
        Button.waitForAnyPress();
        runMotor.stopMotor();
	}

}