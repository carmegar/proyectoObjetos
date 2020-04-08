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
    private int recursoTerran;
    
    /**
     * Act - do whatever the Deposito wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        guardadoProto();
        guardadoTerran();
    }   

    //inicializa el valor qie tiene el deposito al iniciar la partida
    public Deposito(){
        recursoProto = 0;
        recursoTerran = 0;
    }
    
    public int getRecursoProto(){
        return recursoProto;
    }

    public void setRecursoProto( int recursoProto ){
        this.recursoProto +=  recursoProto;
    }
  
    public int getRecursoTerran(){
        return recursoTerran;
    }

    public void setRecursoTerran( int recursoTerran ){
        this.recursoTerran +=  recursoTerran;
    }

    //funcion para colectar la entrega del proto
    public void guardadoProto(){
        Actor guardado = this.getOneIntersectingObject(ConstructorProto.class);       
        if (guardado != null){
            setRecursoProto(30);
        }
    }

    //funcion para colectar la entrega delterran
    public void guardadoTerran(){
        Actor guardado= this.getOneIntersectingObject(ConstructorTerran.class);
        if(guardado != null){
            setRecursoTerran(30);
        }
    }
    
}
