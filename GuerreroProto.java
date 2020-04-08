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
        
    } 

    public void curacionMedico(){
        Actor a = this.getOneIntersectingObject(MedicoProto.class);

        if (a != null){
            int aumentoCura = 15;

            if(getEnergia() < 160){

                if(getEnergia()+15 > 160){
                    int x = (getEnergia()+15) - 160;
                    aumentoCura = 15-x;
                }

                setEnergia(aumentoCura);
            }
        }
    }
    
    
    
     public void curacionDeposito(){
        Actor a = this.getOneIntersectingObject(Deposito.class);

        if (a != null){
            int aumentoCura = 25;

            if(getEnergia() < 160){

                if(getEnergia()+25 > 160){
                    int x = (getEnergia()+25) - 160;
                    aumentoCura = 25-x;
                }

                setEnergia(aumentoCura);
            }

        }
     }
 

    public void noTocarMinaDeOro(){
        Actor a = this.getOneIntersectingObject(MinaDeOro.class);
        if (a != null){
            turn(180);
            move(5);
        }
    }

 
}
