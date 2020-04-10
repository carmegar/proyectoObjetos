import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GuerreroProto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuerreroProto extends Protos
{
    /**
     * Act - do whatever the GuerreroProto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        curacionMedico();
        curacionDeposito();
        ataqueGuerreroTerran();
        ataqueConstructorTerran();
        ataqueMedicoTerran();
        ataqueGuerreroZerg();
        ataqueConstructorZerg();
        ataqueMedicoZerg();
        noTocarMinaDeGas();
        noTocarMinaCristal();
        noTocarBaseCuraion();
    } 
    

    //curacion por parte de su medico
    public void curacionMedico(){
        Actor cmedico = this.getOneIntersectingObject(MedicoProto.class);
        if (cmedico != null){
            int cura = 20;
            if(getEnergia() < 160){
                //se cura la parte que falta para lograr la maxima vida del medico
                if(getEnergia()+20 > 160){
                    int x = (getEnergia()+15) - 160;
                    cura = 20-x;
                }
                setEnergia(cura);
            }
        }
    }
 
     //curacion por parte de su deposito
    public void curacionDeposito(){
        Actor cdeposito = this.getOneIntersectingObject(Deposito.class);
        if (cdeposito != null){
            int cura = 25;
            if(getEnergia() < 160){
                if(getEnergia()+25 > 160){
                    int valor = (getEnergia()+25) - 160;
                    cura = 25-valor;
                }
                setEnergia(cura);
            }
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
   //
    public void ataqueGuerreroZerg(){
        Actor Aguerrero = this.getOneIntersectingObject(GuerreroZerg.class);
        // daño que recibe el guerrero, cuando guerrero zerg vs guerrero proto
        if (Aguerrero != null){
          int random = Greenfoot.getRandomNumber(100);
          int daño = (40*random)/100;
          setEnergia(-daño);
        }
    }
    
    public void ataqueConstructorZerg(){
        Actor a = this.getOneIntersectingObject(ConstructorZerg.class);
        // daño que recibe el guerrero, cuando constructor zerg vs guerrero proto
        if (a != null){
          int x = Greenfoot.getRandomNumber(100);
          int daño = (28*x)/100;
          setEnergia(-daño);
        }
    }
    
    public void ataqueMedicoZerg(){
        Actor a = this.getOneIntersectingObject(MedicoZerg.class);
        // daño que recibe el guerrero, cuando medico Zerg vs guerrero proto
        if (a != null){
          int x = Greenfoot.getRandomNumber(100);
          int daño = (28*x)/100;
          setEnergia(-daño);
        }
    }
    //funcion para que los guerreros proto no toquen las minas de gas
    public void noTocarMinaDeGas(){
        Actor noTocar = this.getOneIntersectingObject(MinaDeGas.class);
        if (noTocar != null){
            turn(180);
            move(5);
        }
    }
   
    //funcion para que los guerreros proto no toquen las minas de oro
    public void noTocarMinaCristal(){
        Actor noTocar = this.getOneIntersectingObject(MinaCristal.class);
        if (noTocar != null){
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
