
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class MinaCristal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinaCristal extends Construcciones
{
    private int cantidadCristal;

    /**
     * Act - do whatever the MinaCristal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        cristalTerran();
        cristalProto();
        cristalZerg();
    }    

    //iniciliza el crista que tendra la mina
    public MinaCristal(){
        cantidadCristal = (100 + Greenfoot.getRandomNumber(300));
    }

    public int getCantidadCristal(){
        return cantidadCristal;
    }

    public void setCantidadCristal( int cantidadCristal ){
        this.cantidadCristal -=  cantidadCristal;
    }
    
    //repartiendo el cristal de la mina
    public void cristalProto(){
        Actor cProto = this.getOneIntersectingObject(ConstructorProto.class);        
        if (cProto != null){          
            int x = Greenfoot.getRandomNumber(35);
            //cristal que recoge el constructor proto
            if(getCantidadCristal()>0){
                //si el cristal que tiene la mina es menor que se necesita entregar al constructor, entrega solo lo que tenga
                if(getCantidadCristal()-x<0){
                    int b = ( getCantidadCristal()-x );
                    x = x + (b); 
                }
                //entrega normal
                setCantidadCristal(x);
            }               
        }
    }

    public void cristalTerran(){
        Actor a = this.getOneIntersectingObject(ConstructorTerran.class);
        if (a != null){
            int x = Greenfoot.getRandomNumber(35);
            //cristal que recoge el constructor terran
            if(getCantidadCristal()>0){
                //si el cristal que tiene la mina es menor que se necesita entregar al constructor, entrega solo lo que tenga
                if(getCantidadCristal()-x<0){
                    int b = ( getCantidadCristal()-x );
                    x = x + (b); 
                }
                setCantidadCristal(x);
            }
        }
    }
    
    public void cristalZerg(){
        Actor a = this.getOneIntersectingObject(ConstructorZerg.class);
        if (a != null){
            int x = Greenfoot.getRandomNumber(35);
            //cristal que recoge el constructor zerg
            if(getCantidadCristal()>0){
                //si el cristal que tiene la mina es menor que se necesita entregar al constructor, entrega solo lo que tenga
                if(getCantidadCristal()-x<0){
                    int b = ( getCantidadCristal()-x );
                    x = x + (b); 
                }
                setCantidadCristal(x);
            }
        }
    }

    
}
