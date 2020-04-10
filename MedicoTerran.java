
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MedicoTerran here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MedicoTerran extends Terran
{
    private int curacion;

    /**
     * Act - do whatever the MedicoTerran wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        curarGuerrero();
        curarConstructor();
        curacionDeposito();
        ataqueGuerreroProto();
        ataqueConstructorProto();
        ataqueMedicoProto();
        ataqueGuerreroZerg();
        ataqueConstructorZerg();
        ataqueMedicoZerg();
        noTocarMinaDeGas();
        noTocarMinaCristal();
        
    }    

    //el medico inicia con 120 puntos de vida y los terran en 100, entonces 
    //le damos 20 mas para que los medicos tengas su vida normal
    public MedicoTerran(){
        setEnergia(20);
    }
    
    public void curarConstructor(){
        Actor cCons = this.getOneIntersectingObject(ConstructorProto.class);
        if (cCons != null){
            int cura = (-20);
            //si el constructor tiene una vida inferior a cero este debe de
            //ir al cementerio por que murio, en la (0,0
            if(getEnergia() <= 0){
               setLocation(0 ,0);
            }
            //cura normal
            setEnergia(cura);
        }
    }
    
    public void curarGuerrero(){        
         Actor curar = this.getOneIntersectingObject(GuerreroProto.class);
         if (curar != null){
            int dañoCura = (-20);
            //si el guerrero tiene una vida inferior a cero este debe de
            //ir al cementerio por que murio, en la (0,0)
            if(getEnergia() <= 0){
               setLocation(0 ,0);
            }
            //daño que recibe el medico al curar
            setEnergia(dañoCura);
        }
    }
    
    public void curacionDeposito(){
        Actor cDep = this.getOneIntersectingObject(Deposito.class);
        if (cDep != null){
            int cura = 20;
            if(getEnergia() < 160){
                //cura lo restante que falta para completa la maxima vida 
                if(getEnergia()+20 > 160){
                    int x = (getEnergia()+20) - 160;
                    cura = 20-x;
                }
                //curar los 20 normal
                setEnergia(cura);
            }
        }
    }
    
    public void ataqueGuerreroProto(){
        Actor a = this.getOneIntersectingObject(GuerreroProto.class);
        if (a != null){
            //daño que recibe el medico, cuando medico vs guerrero proto 
            int random = Greenfoot.getRandomNumber(100);
            int daño = (70*random)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueConstructorProto(){
        Actor a = this.getOneIntersectingObject(ConstructorProto.class);
       if (a != null){
           //daño que recibe el medico, cuando medico vs constructor proto
            int random = Greenfoot.getRandomNumber(100);
            int daño = (50*random)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueMedicoProto(){
        Actor a = this.getOneIntersectingObject(MedicoProto.class);
       if (a != null){
           //daño que recibe el medico, cuando medico vs medico proto
            int random = Greenfoot.getRandomNumber(100);
            int daño = (50*random)/100;
            setEnergia(-daño);
        }
    }
    
    public void ataqueGuerreroZerg(){
        Actor a = this.getOneIntersectingObject(GuerreroZerg.class);
        if (a != null){
            //daño que recibe el medico, cuando medico vs guerrero zerg
            int random = Greenfoot.getRandomNumber(100);
            int daño = (70*random)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueConstructorZerg(){
        Actor a = this.getOneIntersectingObject(ConstructorZerg.class);
       if (a != null){
           //daño que recibe el medico, cuando medico vs constructor zerg
            int random = Greenfoot.getRandomNumber(100);
            int daño = (48*random)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueMedicoZerg(){
        Actor a = this.getOneIntersectingObject(MedicoZerg.class);
       if (a != null){
           //daño que recibe el medico, cuando medico vs medico zerg
            int random = Greenfoot.getRandomNumber(100);
            int daño = (48*random)/100;
            setEnergia(-daño);
        }
    }

    public void noTocarMinaDeGas(){
        Actor a = this.getOneIntersectingObject(MinaDeGas.class);
        if (a != null){
            turn(180);
            move(5);
        }
    }

    public void noTocarMinaCristal(){
        Actor a = this.getOneIntersectingObject(MinaCristal.class);
        if (a != null){
            turn(180);
            move(5);
        }
    }
}

