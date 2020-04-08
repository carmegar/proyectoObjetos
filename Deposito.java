import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Deposito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deposito extends Construcciones
{
    private int recursoProto;
    
    /**
     * Act - do whatever the Deposito wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        guardadoProto();
        
    }   

    public Deposito(){
        recursoProto = 0;
    }

    public void guardadoProto(){
        Actor guardado = this.getOneIntersectingObject(ConstructorProto.class);       
        if (guardado != null){
            setRecursoProto(30);
        }
    }

    public int getRecursoProto(){
        return recursoProto;
    }

    public void setRecursoProto( int recursoProto ){
        this.recursoProto +=  recursoProto;
    }

   
   
    
}
