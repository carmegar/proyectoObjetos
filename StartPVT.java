import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Write a description of class StartPVT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartPVT extends Botones
{
    /**
     * Act - do whatever the StartPVT wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            try {
                FileWriter writer = new FileWriter("pvt.txt");
                writer.write("Datos del encuentro Protos vs Terran");
                writer.write("\n\n");
                writer.write("Energia\tX\tY\n");
                writer.write("********************************\n");
                writer.write("Protos\n");
                writer.write("********************************\n");
                
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Greenfoot.setWorld(new NuevaPartida());
        }    
    }    
}
