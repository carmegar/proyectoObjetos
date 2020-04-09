import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GuerreroZerg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuerreroZerg extends Zerg
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
        ataqueGuerreroTerran();
        ataqueConstructorTerran();
        ataqueMedicoTerran();
        noTocarBaseCuraion();
        noTocarMinaDeGas();
    }    

    //funcion para la curacion que recive el guerrero por parte de su medico 
    public void curacionMedico(){
        Actor curacion = this.getOneIntersectingObject(MedicoTerran.class);
        if (curacion != null){
            int cura = 25;
            //confirma si el guerrero tiene daño
            if(getEnergia() < 160){
                 //revisa si las vida es mayor de 140, para curar lo que falta para completar su maxima vida
                if(getEnergia()+25 > 160){
                    int velor = (getEnergia()+25) - 160;
                    cura = 25-velor;
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
                if(getEnergia()+15 > 160){
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
          int daño = (60*valor)/100;
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

    public void ataqueGuerreroTerran(){
        Actor Aguerrero = this.getOneIntersectingObject(GuerreroTerran.class);
        // daño que recibe el guerrero, cuando guerrero terran vs guerrero proto
        if (Aguerrero != null){
          int random = Greenfoot.getRandomNumber(100);
          int daño = (45*random)/100;
          setEnergia(-daño);
        }
    }
    
    public void ataqueConstructorTerran(){
        Actor a = this.getOneIntersectingObject(ConstructorTerran.class);
        // daño que recibe el guerrero, cuando constructor terran vs guerrero proto
        if (a != null){
          int x = Greenfoot.getRandomNumber(100);
          int daño = (30*x)/100;
          setEnergia(-daño);
        }
    }
    
    public void ataqueMedicoTerran(){
        Actor a = this.getOneIntersectingObject(MedicoTerran.class);
        // daño que recibe el guerrero, cuando medico terran vs guerrero proto
        if (a != null){
          int x = Greenfoot.getRandomNumber(100);
          int daño = (30*x)/100;
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
    
    //funcion para protos no base de curacion
    public void noTocarBaseCuraion(){
        Actor random = this.getOneIntersectingObject(BaseDeCuracion.class);
        if (random != null){
            turn(180);
            move(5);
        }
    }
}
