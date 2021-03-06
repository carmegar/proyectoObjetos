import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ConstructorTerran here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConstructorTerran extends Terran
{
    /**
     * Act - do whatever the ConstructorTerran wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int cantidadCristalTerran;
    private int cantidadGasTerran;
    public void act() 
    {
        super.act();
        curacionMedico();
        curacionDeposito();
        entregarRecurso();
        recogerGas();
        recogerCristal();
        ataqueGuerreroProto();
        ataqueConstructorProto();
        ataqueMedicoProto();
        ataqueGuerreroZerg();
        ataqueConstructorZerg();
        ataqueMedicoZerg();
        noTocarBaseCuraion();;
    }   

    //inicializa las variables
    public ConstructorTerran(){
        cantidadCristalTerran = 0;
        cantidadGasTerran = 0;
    }

    //curacion que recibe el constructor por parte del medico
    public void curacionMedico(){
        Actor curacion = this.getOneIntersectingObject(MedicoTerran.class);
        if (curacion != null){
            int cura = 20;
            //confirma que tiene daño
            if(getEnergia() < 160){
                //cura solo la cantidad que falta para lacanzar su vida maxima, si su bida es mayor de 80
                if(getEnergia()+20 > 160){
                    int x = (getEnergia()+20) - 160;
                    cura = 20-x;
                }
                //cura normal
                setEnergia(cura);
            }
        }
    }

    //curacion que recibe el constructor por parte del medico
    public void curacionDeposito(){
        Actor curacion = this.getOneIntersectingObject(Deposito.class);
        if (curacion != null){
            int cura = 20;
            //confirma que tiene daño
            if(getEnergia() < 160){
                //cura solo la cantidad que falta para lacanzar su vida maxima, si su bida es mayor de 80
                if(getEnergia()+20 > 160){
                    int valorC = (getEnergia()+20) - 160;
                    cura = 20-valorC;
                }
                //cura normal
                setEnergia(cura);
            }
        }
    }

    //funcion para que el constructor entreguelos recursos recolectados
    public void entregarRecurso(){
        Actor entregar = this.getOneIntersectingObject(Deposito.class);
        if (entregar != null){
            SetCantidadCristal(0);
        }
    }

    //funcion encargada de recolectar el gas por parte del constructor
    public void recogerGas(){
        Actor recoger = this.getOneIntersectingObject(MinaDeGas.class);
        if (recoger != null){
            SetCantidadGasTerran(50);
        }
    }

    public void recogerCristal(){
        Actor recoger = this.getOneIntersectingObject(MinaCristal.class);
        if (recoger != null){
            int valor = 30;
            MinaCristal mo = new MinaCristal();
            // si la mina de oro no tiene las 30 unidades de oro solo dara las que tenga 
            //si no tiene  no entregara nada al constructor
            if(mo.getCantidadCristal()>0){ 
                //si la mina de oro tiene menos de 30 d oro, entonces solo entrega lo que tiene
                if(mo.getCantidadCristal()-30 <0){
                    int b = valor-(mo.getCantidadCristal()-30);
                }
                //recoge los 30 de oro
                SetCantidadCristal(valor);
            }
             //si la mina no tiene oro, deja el mismo valor que tenia inicialmente  el constructor
            if(mo.getCantidadCristal() == 0){
                SetCantidadCristal(getCantidadCristal());       
            }
        }
    }

    public void ataqueGuerreroProto(){
        Actor Aguerrero = this.getOneIntersectingObject(GuerreroProto.class);
        //daño que recibe el contructor, cuando se enfrenta contra el guerrero proto
        if (Aguerrero != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (70*valor)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueConstructorProto(){
        Actor Aconstr = this.getOneIntersectingObject(ConstructorProto.class);
        //daño que recibe el contructor, cuando se enfrenta contra el construtor proto
        if (Aconstr != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (50*valor)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueMedicoProto(){
        Actor Amedico = this.getOneIntersectingObject(MedicoTerran.class);
        //daño que recibe el contructor, cuando se enfrenta contra el construtor proto
        if (Amedico != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (50*valor)/100;
            setEnergia(-daño);
        }
    }
    
    public void ataqueGuerreroZerg(){
        Actor Aguerrero = this.getOneIntersectingObject(GuerreroZerg.class);
        //daño que recibe el contructor, cuando se enfrenta contra el guerrero Zerg
        if (Aguerrero != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (70*valor)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueConstructorZerg(){
        Actor Aconstr = this.getOneIntersectingObject(ConstructorZerg.class);
        //daño que recibe el contructor, cuando se enfrenta contra el construtor Zerg
         if (Aconstr != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (48*valor)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueMedicoZerg(){
        Actor Amedico = this.getOneIntersectingObject(MedicoZerg.class);
        //daño que recibe el contructor, cuando se enfrenta contra el construtor Zerg
        if (Amedico != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (48*valor)/100;
            setEnergia(-daño);
        }
     }
     
     public void noTocarBaseCuraion(){
        Actor a = this.getOneIntersectingObject(BaseDeCuracion.class);
        if (a != null){
            turn(180);
            move(5);
        }
    }

    public int getCantidadCristal(){
        return cantidadCristalTerran;
    }

    public void SetCantidadCristal(int cantidadCristalTerran){
        this.cantidadCristalTerran = cantidadCristalTerran;
    }

    public int getCantidadGasTerran(){
        return cantidadGasTerran;
    }

    public void SetCantidadGasTerran(int cantidadGasTerran){
        this.cantidadGasTerran = cantidadGasTerran;
    }

}