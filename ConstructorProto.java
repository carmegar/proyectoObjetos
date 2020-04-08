
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ConstructorProto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConstructorProto extends Protos
{
    private int cantidadOroProto;
    private int cantidadGasProto;
    

    /**
     * Act - do whatever the ConstructorProto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        curacionMedico();
        curacionDeposito();
        entregarRecurso();
        recogerOro();
   
    }    

    public ConstructorProto(){
        cantidadOroProto = 0;
        
    }

    public void curacionMedico(){
        Actor a = this.getOneIntersectingObject(MedicoProto.class);
        if (a != null){
            int aumentoCura = 15;
            if(getEnergia() < 160){
                if(getEnergia()+15 > 160){
                    int x = (getEnergia()+15) - 160;
                    aumentoCura = 15-x;
                }
                setEnergia(aumentoCura);
            }
        }
    }

    public void curacionDeposito(){
        Actor a = this.getOneIntersectingObject(Deposito.class);
        if (a != null){
            int aumentoCura = 25;
            if(getEnergia() < 160){
                if(getEnergia()+25 > 160){
                    int x = (getEnergia()+25) - 160;
                    aumentoCura = 25-x;
                }
                setEnergia(aumentoCura);
            }

        }
    }

    public void entregarRecurso(){
        Actor a = this.getOneIntersectingObject(Deposito.class);
        if (a != null){
            setCantidadOroProto(0);
        }
    }

   
    public void recogerOro(){
        Actor a = this.getOneIntersectingObject(MinaDeOro.class);
        
        if (a != null){
            int xMina = a.getX();
            int yMina = a.getY();
            int x = 30;
            MinaDeOro mo = new MinaDeOro();
            // si la mina de oro no tiene las 30 unidades de oro solo dara las que tenga 
            //si no tiene  no entregara nada al constructor
            if(mo.getCantidadMinaOro()>0){ 
                //if(getUnidadesOro() )
                if(mo.getCantidadMinaOro()-30 <0){
                    int c = x-(mo.getCantidadMinaOro()-30);
                }
                setCantidadOroProto(x);
            }            
            if(mo.getCantidadMinaOro() == 0){
                setCantidadOroProto(getCantidadOroProto());       
            }

        }

    }

    public void recogerOro1(){
        Actor a = this.getOneIntersectingObject(MinaDeOro.class);
        if (a != null){
            int xMina = a.getX();
            int yMina = a.getY();
            int x = 30;
            MinaDeOro mo = new MinaDeOro();
            // si la mina de oro no tiene las 30 unidades de oro solo dara las que tenga
            //hasta estar en 0
            //si no tiene no entrega al constructor
            if(mo.getCantidadMinaOro()>0){ 
               
                if(mo.getCantidadMinaOro()-30 <0){
                    int b = x-(mo.getCantidadMinaOro()-30);
                }
                setCantidadOroProto(x);
            }            
            if(mo.getCantidadMinaOro() == 0){
                setCantidadOroProto(getCantidadOroProto());       
            }
        }
    }

    

    public int getCantidadOroProto(){
        return cantidadOroProto;
    }

    public void setCantidadOroProto(int cantidadsOroProto){
        this.cantidadOroProto = cantidadOroProto;
    }

    

}
