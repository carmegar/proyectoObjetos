import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ConstructorZerg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConstructorZerg extends Zerg
{
    private int cantidadOroZerg;
    private int cantidadGasZerg;
    public void act() 
    {
        super.act();
        curacionMedico();
        curacionDeposito();
        entregarRecurso();
        recogerGas();
        ataqueGuerreroProto();
        ataqueConstructorProto();
        ataqueMedicoProto();
        ataqueGuerreroTerran();
        ataqueConstructorTerran();
        ataqueMedicoTerran();
        noTocarBaseCuraion();
    }   

    //inicializa las variables
    public ConstructorZerg(){
        cantidadOroZerg = 0;
        cantidadGasZerg = 0;
    }

    //curacion que recibe el constructor por parte del medico
    public void curacionMedico(){
        Actor curacion = this.getOneIntersectingObject(MedicoTerran.class);
        if (curacion != null){
            int cura = 25;
            //confirma que tiene daño
            if(getEnergia() < 160){
                //cura solo la cantidad que falta para lacanzar su vida maxima, si su bida es mayor de 80
                if(getEnergia()+25 > 160){
                    int x = (getEnergia()+25) - 160;
                    cura = 25-x;
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
                if(getEnergia()+15 > 160){
                    int valorC = (getEnergia()+20) - 160;
                    cura = 20-valorC;
                }
                //cura normal
                setEnergia(cura);
            }
        }
    }

    //funcion para que el constructor entreguelos recursos recolectados
    //al entregar el recurso su valr de cargue pasa a ser 0
    public void entregarRecurso(){
        Actor entregar = this.getOneIntersectingObject(Deposito.class);
        if (entregar != null){
            SetCantidadOroZerg(0);
        }
    }

    //funcion encargada de recolectar el gas por parte del constructor
    public void recogerGas(){
        Actor recoger = this.getOneIntersectingObject(MinaDeGas.class);
        if (recoger != null){
            SetCantidadGasZerg(50);
        }
    }

    public void ataqueGuerreroProto(){
        Actor Aguerrero = this.getOneIntersectingObject(GuerreroProto.class);
        //daño que recibe el contructor, cuando se enfrenta contra el guerrero proto
        if (Aguerrero != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (60*valor)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueConstructorProto(){
        Actor Aconstr = this.getOneIntersectingObject(ConstructorProto.class);
        //daño que recibe el contructor, cuando se enfrenta contra el construtor proto
        if (Aconstr != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (72*valor)/100;
            setEnergia(-daño);
        }
    }

    public void ataqueMedicoProto(){
        Actor Amedico = this.getOneIntersectingObject(MedicoTerran.class);
        //daño que recibe el contructor, cuando se enfrenta contra el construtor proto
        if (Amedico != null){
            int valor = Greenfoot.getRandomNumber(100);
            int daño = (72*valor)/100;
            setEnergia(-daño);
        }
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
    
    //funcion para protos no base de curacion
    public void noTocarBaseCuraion(){
        Actor random = this.getOneIntersectingObject(BaseDeCuracion.class);
        if (random != null){
            turn(180);
            move(5);
        }
    }
    
    public int getCantidadOroZerg(){
        return cantidadOroZerg;
    }

    public void SetCantidadOroZerg(int cantidadOroZerg){
        this.cantidadOroZerg = cantidadOroZerg;
    }

    public int getCantidadGasZerg(){
        return cantidadGasZerg;
    }

    public void SetCantidadGasZerg(int cantidadGasZerg){
        this.cantidadGasZerg = cantidadGasZerg;
    }  
}
