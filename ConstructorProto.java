
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ConstructorProto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConstructorProto extends Protos
{
    private int cantidadCristalProto;
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
        recogerGas();
        recogerCristal();
        ataqueGuerreroTerran();
        noTocarBaseCuraion();
        ataqueConstructorTerran();
        ataqueMedicoTerran();
        ataqueGuerreroZerg();
        ataqueConstructorZerg();
        ataqueMedicoZerg();
    }    

    //inicializa las variables 
    public ConstructorProto(){
        cantidadCristalProto = 0;
        cantidadGasProto = 0;
    }
    
    //funcion para la curacion que recibe el contrustor por parte de su medico
    public void curacionMedico(){
        Actor cmedico = this.getOneIntersectingObject(MedicoProto.class);
        if (cmedico != null){
            int cura = 15;
            //curacion del medico si el guerrero esta lastimado
            if(getEnergia() < 160){
               //cura solo la vida faltante para su maxima, si su vida
               //de mayor de 85
                if(getEnergia()+15 > 160){
                    int x = (getEnergia()+15) - 160;
                    cura = 15-x;
                }
                //curar normal
                setEnergia(cura);
            }
        }
    }

    //funcion para la curacion que recibe el contrustor por parte de su deposito
    public void curacionDeposito(){
        Actor cdeposito = this.getOneIntersectingObject(Deposito.class);
        if (cdeposito != null){
            int cura = 20;
            //curacion del medico si el guerrero esta lastimado
            if(getEnergia() < 160){
                //cura solo la vida faltante para su maxima, si su vida
                if(getEnergia()+25 > 160){
                    int x = (getEnergia()+20) - 160;
                    cura = 20-x;
                }
                //curar normal
                setEnergia(cura);
            }
        }
    }

    //funcion para que el contructor entregue recursos obtenidos
    public void entregarRecurso(){
        Actor entregar = this.getOneIntersectingObject(Deposito.class);
        if (entregar != null){
            SetCantidadC(0);
        }
    }

    //funcion para que el contructor recolecte el gas y lo convierta en energia
    public void recogerGas(){
        Actor recogerG = this.getOneIntersectingObject(MinaDeGas.class);
        if (recogerG != null){
            setCantidadGasProto(25);            
        }
    }
    
    public void recogerCristal(){
        Actor recoger = this.getOneIntersectingObject(MinaCristal.class);
        if (recoger != null){
            int valor = 30;
            MinaCristal mo = new MinaCristal();
            // si la mina de oro no tiene las 30 unidades de oro solo dara las que tenga 
            //si no tiene  no entregara nada al constructor
            if(mo.getCantidadC()>0){ 
                //si la mina de oro tiene menos de 30 d oro, entonces solo entrega lo que tiene
                if(mo.getCantidadC()-30 <0){
                    int b = valor-(mo.getCantidadC()-30);
                }
                //recoge los 30 de oro
                SetCantidadC(valor);
            }
             //si la mina no tiene oro, deja el mismo valor que tenia inicialmente  el constructor
            if(mo.getCantidadC() == 0){
                SetCantidadC(getCantidadC());       
            }
        }
    }
    
    public int getCantidadC(){
        return cantidadCristalProto;
    }
    
    public void SetCantidadC(int cant){
        this.cantidadCristalProto = cant;
    }

    public void ataqueGuerreroTerran(){
        Actor Aguerrero = this.getOneIntersectingObject(GuerreroTerran.class);
        //daño que recibe el contructor, cuando se enfrenta contra guerrero terran
         if (Aguerrero != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (70*valor)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueConstructorTerran(){
        Actor Aconstr = this.getOneIntersectingObject(ConstructorTerran.class);
        //daño que recibe el contructor, cuando se enfrenta contra constructor terran
         if (Aconstr != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (50*valor)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueMedicoTerran(){
        Actor Amedico = this.getOneIntersectingObject(MedicoTerran.class);
        //daño que recibe el contructor, cuando se enfrenta contra medico terran
         if (Amedico != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (50*valor)/100;
            setEnergia(-daño);
        }
    }
    
    public void ataqueGuerreroZerg(){
        Actor Aguerrero = this.getOneIntersectingObject(GuerreroZerg.class);
        //daño que recibe el contructor, cuando se enfrenta contra guerrero zerg
         if (Aguerrero != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (70*valor)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueConstructorZerg(){
        Actor Aconstr = this.getOneIntersectingObject(ConstructorZerg.class);
        //daño que recibe el contructor, cuando se enfrenta contra constructor zerg
         if (Aconstr != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (48*valor)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueMedicoZerg(){
        Actor Amedico = this.getOneIntersectingObject(MedicoZerg.class);
        //daño que recibe el contructor, cuando se enfrenta contra medico zerg
         if (Amedico != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (48*valor)/100;
            setEnergia(-daño);
        }
    }
    
    //funcion para protos no base de curacion
    public void noTocarBaseCuraion(){
        Actor random = this.getOneIntersectingObject(BaseDeCuracion.class);
        if (random != null){
            turn(180);
            move(5);
        }
    }

    public int getCantidadGasProto(){
        return cantidadGasProto;
    }

    public void setCantidadGasProto(int cantidadGasProto){
        this.cantidadGasProto = cantidadGasProto;
    }

}
