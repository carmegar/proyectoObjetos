import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NuevaPardida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NuevaPardida extends Botones
{
    /**
     * Act - do whatever the NuevaPardida wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //boton de pulsacion para iniciar nueva partida
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new world());
        }       
    }    
}
