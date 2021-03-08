package app;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;
import lejos.utility.Delay;
import sensors.ColorSensor;
import library.Lcd;

public class ColorDemo
{
    public static void main(String[] args)
    {
        ColorSensor    color = new ColorSensor(SensorPort.S3);

        System.out.println("Color Demo");
        Lcd.print(2, "Press to start");
        
        Button.LEDPattern(4);    // v‰l‰ytt‰‰ vihre‰‰
        Sound.beepSequenceUp();    // pit‰‰ ‰‰nen, kun valmis

        Button.waitForAnyPress();
        Button.LEDPattern(0);
        
        // ajaa, kunnes takaisin-nappia painettu
        
        while (Button.ESCAPE.isUp())
        {
            Lcd.clear(4);
            Lcd.print(4, "ambient=%.3f", color.getAmbient());
            Delay.msDelay(250);
        }

        Delay.msDelay(1000);

        color.setRedMode();
        color.setFloodLight(Color.RED);
        color.setFloodLight(true);
        
        while (Button.ESCAPE.isUp())
        {
            Lcd.clear(5);
            Lcd.print(5, "red=%.3f", color.getRed());
            Delay.msDelay(250);
        }

        Delay.msDelay(1000);

        color.setRGBMode();
        color.setFloodLight(Color.WHITE);
        
        Color rgb;
        
        while (Button.ESCAPE.isUp())
        {
            rgb = color.getColor();
            
            Lcd.clear(6);
            Lcd.print(6, "r=%d g=%d b=%d", rgb.getRed(), rgb.getGreen(), rgb.getBlue());
            Delay.msDelay(250);
        }

        Delay.msDelay(1000);

        color.setColorIdMode();
        color.setFloodLight(false);
        
        while (Button.ESCAPE.isUp())
        {
            Lcd.clear(7);
            Lcd.print(7, "id=%s", ColorSensor.colorName(color.getColorID()));
            Delay.msDelay(250);
        }

        // vapauttaa resurssit
        color.close();
        
        Sound.beepSequence();    // valmis

        Button.LEDPattern(4);
        Button.waitForAnyPress();
    }

}
