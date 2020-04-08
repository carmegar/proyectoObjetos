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
    private int cantidadOroTerran;
    private int cantidadGasTerran;
    public void act() 
    {
        super.act();
        curacionMedico();
        curacionDeposito();
        entregarRecurso();
        recogerGas();
        recogerOro();
        ataqueGuerreroProto();
        ataqueConstructorProto();
        ataqueMedicoProto();
    }   

    //inicializa las variables
    public ConstructorTerran(){
        cantidadOroTerran = 0;
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
            SetCantidadOroTerran(0);
        }
    }

    //funcion encargada de recolectar el gas por parte del constructor
    public void recogerGas(){
        Actor recoger = this.getOneIntersectingObject(MinaDeGas.class);
        if (recoger != null){
            SetCantidadGasTerran(50);
        }
    }

    public void recogerOro(){
        Actor recoger = this.getOneIntersectingObject(MinaDeOro.class);
        if (recoger != null){
            int valor = 30;
            MinaDeOro mo = new MinaDeOro();
            // si la mina de oro no tiene las 30 unidades de oro solo dara las que tenga 
            //si no tiene  no entregara nada al constructor
            if(mo.getCantidadMinaOro()>0){ 
                //si la mina de oro tiene menos de 30 d oro, entonces solo entrega lo que tiene
                if(mo.getCantidadMinaOro()-30 <0){
                    int b = valor-(mo.getCantidadMinaOro()-30);
                }
                //recoge los 30 de oro
                SetCantidadOroTerran(valor);
            }
             //si la mina no tiene oro, deja el mismo valor que tenia inicialmente  el constructor
            if(mo.getCantidadMinaOro() == 0){
                SetCantidadOroTerran(getCantidadOroTerran());       
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

    public int getCantidadOroTerran(){
        return cantidadOroTerran;
    }

    public void SetCantidadOroTerran(int cantidadOroTerran){
        this.cantidadOroTerran = cantidadOroTerran;
    }

    public int getCantidadGasTerran(){
        return cantidadGasTerran;
    }

    public void SetCantidadGasTerran(int cantidadGasTerran){
        this.cantidadGasTerran = cantidadGasTerran;
    }

}