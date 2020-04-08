import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Terran here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Terran extends Actor
{

    private int energia;
 

    /**
     * Act - do whatever the Terran wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        noTocarBaseCuraion();
        noTocarBarrera();
        noTocarDeposito();
        noTocarMinaDeGas();
        noTocarMinaDeOro();
        curacionDebaseDeCuracion();
        eliminacion();
        mover();
        cambiarDireccionProto();
    } 
    
    public void cambiarDireccionProto(){
        //up,down,left,right
        if(Greenfoot.isKeyDown("t")){
            if(Greenfoot.isKeyDown("up")){
                turnTowards(getX(), 0);
            }

            if(Greenfoot.isKeyDown("down")){
                turnTowards(getX(), getWorld().getHeight());
            }

            if(Greenfoot.isKeyDown("left")){
                turnTowards(0, getY());
            }

            if(Greenfoot.isKeyDown("right")){
                turnTowards(getWorld().getWidth(), getY());
            }
        }
    }
    
    public void eliminacion(){
        Actor a = this.getOneIntersectingObject(null);
        if (a != null){

            if(getEnergia() <= 0){
                setLocation(0 ,0);

            }
        }
    }

    public void curacionDebaseDeCuracion(){
        Actor a = this.getOneIntersectingObject(BaseDeCuracion.class);

        if (a != null){
            int aumentoCura = 20;

            if(getEnergia() < 160){

                if(getEnergia()+20 > 160){
                    int x = (getEnergia()+20) - 160;
                    aumentoCura = 20-x;
                }

                setEnergia(aumentoCura);
            }

        }
    }

    public Terran(){
        energia = 100;
    }

    public void mover(){
        int probabilidad = Greenfoot.getRandomNumber(100);

        World m = getWorld();
        move(5);
        if( probabilidad ==75){
            turn(Greenfoot.getRandomNumber(360));
        }

        if(getX() >= m.getWidth()-5 || getX()<=5)
        {
            turn(180);
            if(Greenfoot.getRandomNumber(100)<90)
            {
                turn(Greenfoot.getRandomNumber(90-45));
            }
        }

        if(getY() >= m.getHeight()-5 || getY()<=5)
        {
            turn(180);
            if(Greenfoot.getRandomNumber(100)<90)
            {
                turn(Greenfoot.getRandomNumber(90-45));
            }
        }

    }

    
    
    
    public void noTocarBaseCuraion(){
        Actor a = this.getOneIntersectingObject(BaseDeCuracion.class);
        if (a != null){
            turn(180);
            move(5);
        }
    }

    public void noTocarBarrera(){
        Actor a = this.getOneIntersectingObject(Barrera.class);
        if (a != null){
            turn(180);
            move(5);
        }
    }

    public void noTocarDeposito(){
        Actor a = this.getOneIntersectingObject(Deposito.class);
        if (a != null){
            turn(180);
            move(5);
        }
    }

    public void noTocarMinaDeGas(){
        Actor a = this.getOneIntersectingObject(MinaDeGas.class);
        if (a != null){
            turn(180);
            move(5);
        }
    }

    public void noTocarMinaDeOro(){
        Actor a = this.getOneIntersectingObject(MinaDeOro.class);
        if (a != null){
            turn(180);
            move(5);
        }
    }

    public int getEnergia(){
        return energia;
    }

    public void setEnergia( int energia ){
        this.energia += energia;
    }
}
