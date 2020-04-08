
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
        recogerGas();
        recogerOro();
        ataqueGuerreroTerran();
        ataqueConstructorTerran();
        ataqueMedicoTerran();
    }    

    //inicializa las variables 
    public ConstructorProto(){
        cantidadOroProto = 0;
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
            int cura = 25;
            //curacion del medico si el guerrero esta lastimado
            if(getEnergia() < 160){
                //cura solo la vida faltante para su maxima, si su vida
               //de mayor de 85
                if(getEnergia()+25 > 160){
                    int x = (getEnergia()+25) - 160;
                    cura = 25-x;
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
            setCantidadOroProto(0);
        }
    }

    //funcion para que el contructor recolecte el gas
    public void recogerGas(){
        Actor recogerG = this.getOneIntersectingObject(MinaDeGas.class);
        if (recogerG != null){
            setCantidadGasProto(50);            
        }
    }

    //funcion para que el constrcutor recolecte el oro
    public void recogerOro(){
        Actor recogerO = this.getOneIntersectingObject(MinaDeOro.class);        
        if (recogerO != null){
            int xMina = recogerO.getX();
            int yMina = recogerO.getY();
            int valor = 30;
            MinaDeOro mo = new MinaDeOro();
            // si la mina de oro no tiene las 30 unidades de oro solo dara 
            //las que tenga,si no tiene  no entregara nada al constructor
            if(mo.getCantidadMinaOro()>0){ 
                //revisa que tenga las 30 unidades de oro, si no las tiene que de las que tenga en el momento
                if(mo.getCantidadMinaOro()-30 <0){
                    int resultado = valor-(mo.getCantidadMinaOro()-30);
                }
                //recoger normal
                setCantidadOroProto(valor);
            } 
            //si la mina no tiene nada, deja los valores de recursos que tenia el constructor
            if(mo.getCantidadMinaOro() == 0){
                setCantidadOroProto(getCantidadOroProto());       
            }

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

    public int getCantidadOroProto(){
        return cantidadOroProto;
    }

    public void setCantidadOroProto(int cantidadsOroProto){
        this.cantidadOroProto = cantidadOroProto;
    }

    public int getCantidadGasProto(){
        return cantidadGasProto;
    }

    public void setCantidadGasProto(int cantidadGasProto){
        this.cantidadGasProto = cantidadGasProto;
    }

}
