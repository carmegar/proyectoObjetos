import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GuerreroTerran here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuerreroTerran extends Terran
{
    /**
     * Act - do whatever the GuerreroTerran wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        curacionMedico();
        curacionDeposito();
        ataqueGuerreroProto();
        ataqueConstructorProto();
        ataqueMedicoProto();
        ataqueGuerreroZerg();
        ataqueConstructorZerg();
        ataqueMedicoZerg();
        noTocarMinaDeGas();
        noTocarMinaCristal();
        noTocarBaseCuraion();
    }    

    //funcion para la curacion que recive el guerrero por parte de su medico 
    public void curacionMedico(){
        Actor curacion = this.getOneIntersectingObject(MedicoTerran.class);
        if (curacion != null){
            int cura = 20;
            //confirma si elguerrero tiene daño
            if(getEnergia() < 160){
                 //revisa si las vida es mayor de 140, para curar lo que falta para completar su maxima vida
                if(getEnergia()+20 > 160){
                    int velor = (getEnergia()+20) - 160;
                    cura = 20-velor;
                }
                //cura normal
                setEnergia(cura);
            }   
        }
    }
    
     //funcion para la curacion que recive el guerrero por parte de su medico
    public void curacionDeposito(){
        Actor curacion = this.getOneIntersectingObject(Deposito.class);
        if (curacion != null){
            int cura = 20;
            //confima si el guerrero tiene daño
            if(getEnergia() < 160){
                //revisa si las vida es mayor de 140, para curar lo que falta para completar su maxima vida
                if(getEnergia()+20 > 160){
                    int xvelor = (getEnergia()+20) - 160;
                   cura = 20-xvelor;
                }
                //cura normal
                setEnergia(cura);
            }
        }
    }
    
    public void ataqueGuerreroProto(){
        Actor Aguerrero = this.getOneIntersectingObject(GuerreroTerran.class);
        //calcula daño que recive el guerrero terran, cuando se enfrenta contra el guerrero de proto
        if (Aguerrero != null){
          int valor = Greenfoot.getRandomNumber(100);
          int daño = (55*valor)/100;
          setEnergia(-daño);
        }
    }
    
    public void ataqueConstructorProto(){
        Actor Aconstr = this.getOneIntersectingObject(ConstructorProto.class);
        //calcula daño que recive el guerrero terran, cuando se enfrenta contra el cosntructor de proto
        if (Aconstr != null){
          int valor = Greenfoot.getRandomNumber(100);
           int daño = (30*valor)/100;
         setEnergia(-daño);
        }
    }
    
    public void ataqueMedicoProto(){
        Actor Amedico = this.getOneIntersectingObject(MedicoProto.class);
        //calcula daño que recive el guerrero terran, cuando se enfrenta contra el medico de proto
        if (Amedico != null){
          int valor = Greenfoot.getRandomNumber(100);
          int daño = (30*valor)/100;
          setEnergia(-daño);
        }
    }

    public void ataqueGuerreroZerg(){
        Actor Aguerrero = this.getOneIntersectingObject(GuerreroZerg.class);
        //calcula daño que recive el guerrero terran, cuando se enfrenta contra el guerrero de Zerg
        if (Aguerrero != null){
          int valor = Greenfoot.getRandomNumber(100);
          int daño = (40*valor)/100;
          setEnergia(-daño);
        }
    }
    
    public void ataqueConstructorZerg(){
        Actor Aconstr = this.getOneIntersectingObject(ConstructorZerg.class);
        //calcula daño que recive el guerrero terran, cuando se enfrenta contra el cosntructor de zerg
        if (Aconstr != null){
          int valor = Greenfoot.getRandomNumber(100);
           int daño = (28*valor)/100;
         setEnergia(-daño);
        }
    }
    
    public void ataqueMedicoZerg(){
        Actor Amedico = this.getOneIntersectingObject(MedicoZerg.class);
        //calcula daño que recive el guerrero terran, cuando se enfrenta contra el medico de zerg
        if (Amedico != null){
          int valor = Greenfoot.getRandomNumber(100);
          int daño = (28*valor)/100;
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
    //funcion para protos no base de curacion
    public void noTocarBaseCuraion(){
        Actor random = this.getOneIntersectingObject(BaseDeCuracion.class);
        if (random != null){
            turn(180);
            move(5);
        }
    }
}

