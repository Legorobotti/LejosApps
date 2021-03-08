package app;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;
import runnables.MeasureDistance;
import runnables.RunMotor;
import runnables.SeeColor;
import util.DATA;

public class KiertoTesti {

	public static void main(String[] args) {
		RunMotor runMotor=new RunMotor();
		MeasureDistance measureDistance=new MeasureDistance();
		SeeColor seeColor=new SeeColor();
		
		Thread motor=new Thread(runMotor);
		Thread distance=new Thread(measureDistance);
		Thread color=new Thread(seeColor);
		
        System.out.println("Drive Forward\nuntil see black\n");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);     // flash green led and
        Sound.beepSequenceUp();   // make sound when ready.

        Button.waitForAnyPress();
         
        motor.start();
        distance.start();
        color.start();
        runMotor.startMotor();
        
        //while (DATA.shouldRun) {
            //if (DATA.colorID == "Black") {
            	//break;
            //} //else {
                System.out.println("Press any key to STOP");
                Button.waitForAnyPress();
                runMotor.stopMotor();
            //}
        //}

        runMotor.stopMotor();
	}

}
