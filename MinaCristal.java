
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class MinaDeOro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinaCristal extends Construcciones
{
    private int cantidadC;

    /**
     * Act - do whatever the MinaDeOro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        cristalTerran();
        cristalProto();
    }    

    //iniciliza el roro que tendra la mina de oro
    public MinaCristal(){
        cantidadC = (100 + Greenfoot.getRandomNumber(300));
    }

    public int getCantidadC(){
        return cantidadC;
    }

    public void setCantidadC( int cantidadC ){
        this.cantidadC -=  cantidadC;
    }
    
    //oro que tiene las minas de oro
    public void cristalProto(){
        Actor cProto = this.getOneIntersectingObject(ConstructorProto.class);        
        if (cProto != null){          
            int x = 35;
            //oro que recoge el constructor proto
            if(getCantidadC()>0){
                //si el oro que tiene la mina es menor que se necesita entregar al constructor, entrega solo lo que tenga
                if(getCantidadC()-35<0){
                    int b = ( getCantidadC()-35 );
                    x = 35 + (b); 
                }
                //entrega normal
                setCantidadC(x);
            }               
        }
    }

    public void cristalTerran(){
        Actor a = this.getOneIntersectingObject(ConstructorTerran.class);
        if (a != null){
            int x = 40;
            //oro que recoge el constructor terran
            if(getCantidadC()>0){
                //si el oro que tiene la mina es menor que se necesita entregar al constructor, entrega solo lo que tenga
                if(getCantidadC()-40<0){
                    int b = ( getCantidadC()-40 );
                    x = 40 + (b); 
                }
                setCantidadC(x);
            }
        }
    }

    
}
