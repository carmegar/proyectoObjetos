import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Credito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credito extends World
{

    /**
     * Constructor for objects of class Credito.
     * 
     */
    public Credito()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 

        Letrero l1 = new Letrero("Desarrolladores:");
        addObject(l1, 200,200);
        Letrero l2 = new Letrero( "estu 1 ");
        addObject(l2, 200,275);
        Letrero l3 = new Letrero( "estu 2");
        addObject(l3, 200,350);
        Letrero l4 = new Letrero( "estu 3");
        addObject(l4, 200,450);
        Salir s1 = new Salir();
        addObject(s1, 222, 555);
    }
}
