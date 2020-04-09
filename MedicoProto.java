import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MedicoProto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MedicoProto extends Protos
{
    /**
     * Act - do whatever the MedicoProto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        curarConstructor();
        curarGuerrero();
        curacionDeposito();
        ataqueGuerreroTerran();
        ataqueConstructorTerran();
        ataqueMedicoTerran();
        ataqueGuerreroZerg();
        ataqueConstructorZerg();
        ataqueMedicoZerg();
        noTocarMinaGas();
    } 

    //el medico inicia con 120 puntos de vida y los protos en 100, entonces 
    //le damos 20 mas para que los medicos tengas su vida normal
    public MedicoProto(){
        setEnergia(20);
    }

    //daño que recibe el medico cuando cura el constructor
    public void curarConstructor(){
        Actor curar = this.getOneIntersectingObject(ConstructorProto.class);
        if (curar != null){
            int dañoCura = (-20);
            //saber si el medico muere al curar
            if(getEnergia() <= 0){
                setLocation(0 ,0);
            }
            setEnergia(dañoCura);
        }
    }
    
    //daño que recibe el medico cuando cura al guerrero
    public void curarGuerrero(){
        Actor curar = this.getOneIntersectingObject(GuerreroProto.class);
        if (curar != null){
            int dañoCura = (-20);
            //saber si el medico muere al curar
            if(getEnergia() <= 0){
                setLocation(0 ,0);
            }
            //cura normal
            setEnergia(dañoCura);
        }
    }
    //funcion para curar el deposito por parte del medico
    public void curacionDeposito(){
        Actor a = this.getOneIntersectingObject(Deposito.class);
        if (a != null){
            int cura = 20;
            //cura solo el valor restante para la maxima vidad del deposito
            if(getEnergia() < 160){
                if(getEnergia()+25 > 160){
                    int x = (getEnergia()+20) - 160;
                    cura = 20-x;
                 //cura normal 
                 setEnergia(cura);
                }
            }
        }
    }
    //ataque de guerrero terran a medico proto
    public void ataqueGuerreroTerran(){
        Actor Aguerrero = this.getOneIntersectingObject(GuerreroTerran.class);
        if (Aguerrero != null){
            int random = Greenfoot.getRandomNumber(100);
            int daño = (70*random)/100;
            setEnergia(-daño);
        }
    }
    //ataque de contructor terran a medico proto  
    public void ataqueConstructorTerran(){
        Actor Aconst = this.getOneIntersectingObject(ConstructorTerran.class);
        if (Aconst != null){
            int random = Greenfoot.getRandomNumber(100);
            int daño = (70*random)/100;
            setEnergia(-daño);
        }
    }
    //ataque de medico terran a medico proto
    public void ataqueMedicoTerran(){
        Actor Amedico = this.getOneIntersectingObject(MedicoTerran.class);
        if (Amedico != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (70*valor)/100;
            setEnergia(-daño);
        }
    }
    
    //ataque de guerrero Zerg a medico proto
    public void ataqueGuerreroZerg(){
        Actor Aguerrero = this.getOneIntersectingObject(GuerreroZerg.class);
        if (Aguerrero != null){
            int random = Greenfoot.getRandomNumber(100);
            int daño = (70*random)/100;
            setEnergia(-daño);
        }
    }
    //ataque de contructor zerg a medico proto  
    public void ataqueConstructorZerg(){
        Actor Aconst = this.getOneIntersectingObject(ConstructorZerg.class);
        if (Aconst != null){
            int random = Greenfoot.getRandomNumber(100);
            int daño = (48*random)/100;
            setEnergia(-daño);
        }
    }
    //ataque de medico zerg a medico proto
    public void ataqueMedicoZerg(){
        Actor Amedico = this.getOneIntersectingObject(MedicoZerg.class);
        if (Amedico != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (48*valor)/100;
            setEnergia(-daño);
        }
    }
    
    //funcion para no tocar las minas de gas
    public void noTocarMinaGas(){
        Actor noTocar = this.getOneIntersectingObject(MinaDeGas.class);
        if (noTocar != null){
            turn(180);
            move(5);
        }
    }
}
