
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
        oroProto();
    }    

    public MinaDeOro(){
        cantidadMinaOro = (100 + Greenfoot.getRandomNumber(300));
    }

    //oro de las minas
    public void oroProto(){
        Actor cProto = this.getOneIntersectingObject(ConstructorProto.class);
        
        if (cProto != null){          
            int x = 35;
            if(getCantidadMinaOro()>0){
                if(getCantidadMinaOro()-35<0){
                    int b = ( getCantidadMinaOro()-35 );
                    x = 35 + (b); 
                }
                setcantidadMinaOro(x);
            }               
        }
    }

  
    public int getCantidadMinaOro(){
        return cantidadMinaOro;
    }

    public void setcantidadMinaOro( int cantidadMinaOro ){
        this.cantidadMinaOro -=  cantidadMinaOro;
    }
}
