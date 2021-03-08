package app;

import library.*;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;


public class UltraSonicDemo
{
    public static void main(String[] args)
    {
        float                range;
        UltraSonicSensor     uss = new UltraSonicSensor(SensorPort.S3);
        
        System.out.println("UltraSonic Demo");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);    // v�l�ytt�� vihre�� valoa
        Sound.beepSequenceUp();    // pit�� ��nen, kun valmista
      

        Button.waitForAnyPress();
        
        range = uss.getRange();

        Lcd.print(7, "range=");

        // ajaa, kunnes l�yt�� objektin 25 sentin sis�ll�
        
        while (range > .25)
        {
            Lcd.clear(7, 7, 10);
            Lcd.print(7, 7, "%.3f", range);
            Delay.msDelay(500);

            range = uss.getRange();
        }
        
        // vapauttaa resurssit
        uss.close();
        
        Sound.beepSequence();    // valmis

        Lcd.clear(7, 7, 10);
        Lcd.print(7, 7, "%.3f", range);

        Button.waitForAnyPress();
    }
}
