import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.FileWriter;
import java.io.IOException;
/**
 * Write a description of class StartTVZ here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartTVZ extends Botones
{
    /**
     * Act - do whatever the StartTVZ wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            try {
                FileWriter writer = new FileWriter("TVZ.txt", true);
                writer.write("Datos del encuentro Terran vs Zerg");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Greenfoot.setWorld(new NuevaPartida());
        }    
    }    
}
