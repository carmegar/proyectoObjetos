import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NuevaPartida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NuevaPartida extends World
{
       

    /**
     * Constructor for objects of class NuevaPartida.
     * 
     */
    public NuevaPartida()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 600, 1);  
         NuevaPardidaPVT s1 = new NuevaPardidaPVT();
          addObject(s1,450,250);          
          NuevaPartidaPVZ s2 = new NuevaPartidaPVZ();
          addObject(s2,600,250);
          NuevaPartidaTVZ s3 = new NuevaPartidaTVZ();
          addObject(s3,750,250);
          Salir1 s11 = new Salir1();
          addObject(s11,600,450);
          Creditos c1 = new Creditos();
          addObject(c1,600,350);

          
    }
}
