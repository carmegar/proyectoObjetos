import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cementerio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cementerio extends Construcciones
{
    /**
     * Act - do whatever the Cementerio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       muerte();
    }  
    
    public void muerte(){
        Actor muerte = this.getOneIntersectingObject(null);
        //si algun objeto toca el cementerio quiere decir que su vida o utilidad ya es inutil en la partida
        //por lo tanto se elimina dem mapa
        if (muerte != null){            
            getWorld().removeObject(muerte);           
        }
    }
}
