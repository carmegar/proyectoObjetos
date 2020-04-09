import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inicio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inicio extends World
{
            GreenfootImage image;


    /**
     * Constructor for objects of class Inicio.
     * 
     */
    public Inicio()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 600, 1); 
          //Greenfoot.setWorld(new NuevaPartida());
          //NuevaPartida s1 = new NuevaPartida();
          //addObject(s1,520,300);
          Greenfoot.setWorld(new NuevaPartida());
          
    }
}
