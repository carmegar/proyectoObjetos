
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class MinaDeOro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinaDeOro extends Construcciones
{
    private int cantidadMinaOro;

    /**
     * Act - do whatever the MinaDeOro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        oroTerran();
        oroProto();
    }    

    //iniciliza el roro que tendra la mina de oro
    public MinaDeOro(){
        cantidadMinaOro = (100 + Greenfoot.getRandomNumber(300));
    }

    public int getCantidadMinaOro(){
        return cantidadMinaOro;
    }

    public void setCantidadMinaOro( int cantidadMinaOro ){
        this.cantidadMinaOro -=  cantidadMinaOro;
    }
    
    //oro que tiene las minas de oro
    public void oroProto(){
        Actor cProto = this.getOneIntersectingObject(ConstructorProto.class);        
        if (cProto != null){          
            int x = 35;
            //oro que recoge el constructor proto
            if(getCantidadMinaOro()>0){
                //si el oro que tiene la mina es menor que se necesita entregar al constructor, entrega solo lo que tenga
                if(getCantidadMinaOro()-35<0){
                    int b = ( getCantidadMinaOro()-35 );
                    x = 35 + (b); 
                }
                //entrega normal
                setCantidadMinaOro(x);
            }               
        }
    }

    public void oroTerran(){
        Actor a = this.getOneIntersectingObject(ConstructorTerran.class);
        if (a != null){
            int x = 40;
            //oro que recoge el constructor terran
            if(getCantidadMinaOro()>0){
                //si el oro que tiene la mina es menor que se necesita entregar al constructor, entrega solo lo que tenga
                if(getCantidadMinaOro()-40<0){
                    int b = ( getCantidadMinaOro()-40 );
                    x = 40 + (b); 
                }
                setCantidadMinaOro(x);
            }
        }
    }

    
}
