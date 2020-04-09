import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.FileWriter;
import java.io.IOException;
/**
 * Write a description of class StartPVZ here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartPVZ extends Botones
{
    /**
     * Act - do whatever the StartPVZ wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            try {
                FileWriter writer = new FileWriter("PVZ.txt", true);
                writer.write("Datos del encuentro Protos vs Zerg");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Greenfoot.setWorld(new NuevaPartida());
        }    
    }    
}
