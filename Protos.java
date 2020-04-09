import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Protos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Protos extends Actor
{

    private int energia;

    /**
     * Act - do whatever the Protos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        noTocarBarrera();
        noTocarDeposito();       
        mover();
        curacionDebaseDeCuracion();
        eliminacion();
        cambiarDireccionProto();
        noTocarMinaC();
    }

    public void cambiarDireccionProto(){
        //ucambiar de direccion sin tocar un borde
        if(Greenfoot.isKeyDown("p")){
            //cambio hacia arriba
            if(Greenfoot.isKeyDown("up")){
                turnTowards(getX(), 0);
            }
            //cambio hacia abajo
            if(Greenfoot.isKeyDown("down")){
                turnTowards(getX(), getWorld().getHeight());
            }
            //cambio hacia la izquierda
            if(Greenfoot.isKeyDown("left")){
                turnTowards(0, getY());
            }
            //cambio hacia la derecha
            if(Greenfoot.isKeyDown("right")){
                turnTowards(getWorld().getWidth(), getY());
            }
        }
    }

    public Protos(){
        //energia inicial de los protos
        energia = 100;
    }

    //movimiento de los protos
    public void mover(){
        int probabilidad = Greenfoot.getRandomNumber(100);
        World m = getWorld();
        move(5);

        //probabilidad de hacer giros cuando toque un extremo
        if( probabilidad ==75){
            turn(Greenfoot.getRandomNumber(360));
        }
 
        //si esta en un borde en la parte x haga un cambio de direccion
        if(getX() >= m.getWidth()-5 || getX()<=5)
        {
            turn(180);
            if(Greenfoot.getRandomNumber(100)<90)
            {
                turn(Greenfoot.getRandomNumber(90-45));
            }
        }

        //si esta en un borde en la parte y haga un cambio de direccion
        if(getY() >= m.getHeight()-5 || getY()<=5)
        {
            turn(180);
            if(Greenfoot.getRandomNumber(100)<90)
            {
                turn(Greenfoot.getRandomNumber(90-45));
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

    //funcion para moverl el el proto a la posicion (0,0) el cual es el cementerio que nos 
    //indica que ha muerto
    public void eliminacion(){
        Actor cementerio = this.getOneIntersectingObject(null);
        if (cementerio != null){
            //si la vida del proto es menor a cero lo mata moviendolo a (0,0)
            if(getEnergia() <= 0){
                setLocation(0 ,0);
            }
        }
    }

    //funcion para protos no tocar barrera
    public void noTocarBarrera(){
        Actor random = this.getOneIntersectingObject(Barrera.class);
        if (random != null){
            turn(180);
            move(5);
        }
    }

    //funcion para protos no tocar deposito
    public void noTocarDeposito(){
        Actor random = this.getOneIntersectingObject(Deposito.class);
        if (random != null){
            turn(180);
            move(5);
        }
    }
    
    public int getEnergia(){
        return energia;
    }

    public void setEnergia( int energia ){
        this.energia +=  energia;
    }
    
    
    public void noTocarMinaC(){
        Actor noTocar = this.getOneIntersectingObject(MinaCristal.class);
        if (noTocar != null){
            turn(180);
            move(5);
        }
    }
}