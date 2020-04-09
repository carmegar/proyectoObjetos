import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class BaseDeCuracion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BaseDeCuracion extends Construcciones
{
    private int vidaBase;
    /**
     * Act - do whatever the BaseDeCuracion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        constructorZerg();
        medicoZerg();
        guerreroZerg();
        constructorProto();
        medicoProto();
        guerreroProto();
        constructorTerran();
        medicoTerran();
        guerreroTerran();
    } 
    
    public BaseDeCuracion(){
        //puede curar a 20 personajes
        vidaBase = 20;
    }
    
    public void constructorZerg(){
        Actor Zerg = this.getOneIntersectingObject(ConstructorZerg.class);        
         if (Zerg != null){
         //por cada zerg que toque quita un punto de curacion a la base
         setVidaBase(getVidaBase()-1);
        }
    }

    public void medicoZerg(){
        Actor Zerg = this.getOneIntersectingObject(MedicoZerg.class);        
         if (Zerg != null){
         //por cada Zerg que toque quita un punto de curacion a la base
         setVidaBase(getVidaBase()-1);
        }
    }    
    
    public void guerreroZerg(){
        Actor Zerg = this.getOneIntersectingObject(GuerreroZerg.class);        
         if (Zerg != null){
         //por cada Zerg que toque quita un punto de curacion a la base
         setVidaBase(getVidaBase()-1);
        }
    }
    
    public void constructorTerran(){
        Actor Terran = this.getOneIntersectingObject(ConstructorZerg.class);        
         if (Terran != null){
         //por cada terran que toque quita un punto de curacion a la base
         setVidaBase(getVidaBase()-1);
        }
    }
    
    public void medicoTerran(){
        Actor Terran = this.getOneIntersectingObject(MedicoZerg.class);        
         if (Terran != null){
         //por cada terran que toque quita un punto de curacion a la base
         setVidaBase(getVidaBase()-1);
        }
    }
    
    public void guerreroTerran(){
        Actor Terran = this.getOneIntersectingObject(GuerreroZerg.class);        
         if (Terran != null){
         //por cada terran que toque quita un punto de curacion a la base
         setVidaBase(getVidaBase()-1);
        }
    }
    
     public void constructorProto(){
        Actor Proto = this.getOneIntersectingObject(ConstructorProto.class);        
         if (Proto != null){
         //por cada proto que toque quita un punto de curacion a la base
         setVidaBase(getVidaBase()-1);
        }
    }
    
    public void medicoProto(){
        Actor Proto = this.getOneIntersectingObject(MedicoProto.class);        
         if (Proto != null){
         //por cada proto que toque quita un punto de curacion a la base
         setVidaBase(getVidaBase()-1);
        }
    }
    
    public void guerreroProto(){
        Actor Proto = this.getOneIntersectingObject(GuerreroProto.class);        
         if (Proto != null){
         //por cada proto que toque quita un punto de curacion a la base
         setVidaBase(getVidaBase()-1);
        }
    }
    
    public int getVidaBase(){
        return vidaBase;
    }

    public void setVidaBase(int vidaBase){
        this.vidaBase = vidaBase;
    }
    
}
