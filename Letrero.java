import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
import greenfoot.Font;

/**
 * Write a description of class Letrero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Letrero extends Actor
{

    /**
     * Act - do whatever the Letrero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      DibujarLetrero();
     }    

     GreenfootImage imagen;
     String mensaje;

    public Letrero( String mensaje)
    {
        mensaje = mensaje;
        imagen = new GreenfootImage(255, 155);
        imagen.setColor(new Color(200,200,0,224));
        imagen.setFont(new Font("Verdana", 24));
        DibujarLetrero();
    }

    public void DibujarLetrero()
    {
        imagen.clear();
        imagen.drawString(mensaje , 20, 20);
        setImage(imagen);
    }
}
