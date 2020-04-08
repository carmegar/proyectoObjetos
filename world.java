import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class world here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class world extends World
{

    /**
     * Constructor for objects of class world.
     * 
     */

    ArrayList<ConstructorProto> lcp;
    ArrayList<GuerreroProto> lgp;
    ArrayList<MedicoProto> lmp;
    ArrayList<ConstructorTerran> lct;
    ArrayList<GuerreroTerran> lgt;
    ArrayList<MedicoTerran> lmt;
    List<ConstructorProto> listCP;
    List<GuerreroProto> listGP;
    List<MedicoProto> listMP;
    List<ConstructorTerran> listCT;
    List<GuerreroTerran> listGT;
    List<MedicoTerran> listMT;
    

    
    public world()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 700, 1);
        BaseDeCuracion bc = new BaseDeCuracion();
        addObject(bc, 580, 280);
        Cementerio c = new Cementerio();
        addObject(c, 0, 0);
        generarTerran();
        generarProtos();
        lcp = new ArrayList<ConstructorProto>();
        

        contadorEnergiaProto();
        contadorEnergiaTerran();

    }
    
   
    public void contadorEnergiaProto(){
        int x= 0;
        listCP = this.getObjects(ConstructorProto.class);
        for(ConstructorProto e : listCP){
            x += e.getEnergia(); 
        }
        int p=0;
        listGP = this.getObjects(GuerreroProto.class);
         for(GuerreroProto e : listGP){
            p += e.getEnergia(); 
        }
        int k=0;
        listMP = this.getObjects(MedicoProto.class);
         for(MedicoProto e : listMP){
            k += e.getEnergia(); 
        }
        int t= (k+p+x)/100;
        
        
    }
    
    public void contadorEnergiaTerran(){
        int x= 0;
        listCT = this.getObjects(ConstructorTerran.class);
        for(ConstructorTerran e : listCT){
            x += e.getEnergia(); 
        }
        int p=0;
        listGT = this.getObjects(GuerreroTerran.class);
         for(GuerreroTerran e : listGT){
            p += e.getEnergia(); 
        }
        int k=0;
        listMT = this.getObjects(MedicoTerran.class);
         for(MedicoTerran e : listMT){
            k += e.getEnergia(); 
        }

    }

    public void generarProtos(){
        int rmp = Greenfoot.getRandomNumber(10);
        int rcp = Greenfoot.getRandomNumber(5);
        int rgp = ( 100- (35 +rcp + rmp) );
        int i,j,k;

        for(  i=1; i<=(rcp); i++){
            ConstructorProto cp = new ConstructorProto();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( cp, 1000 + x , 100 + y );
        }

        for( j=1; j<=(rmp); j++){
            MedicoProto mp = new MedicoProto();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( mp, 1000 + x , 300 + y );
        }

        for( k=1; k<=5; k++){
            GuerreroProto gp = new GuerreroProto();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( gp, 1000 + x , 500 + y );

        }

    }

    public void generarTerran(){

        int rmt = Greenfoot.getRandomNumber(10);
        int rct = Greenfoot.getRandomNumber(5);
        int rgt = ( 100- (35 + rct + rmt) );
        int i,j,k;

        for( i=1; i<=(rct); i++){
            ConstructorTerran ct = new ConstructorTerran();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( ct, 100 + x , 100 + y );   
        }

        for( j=1; j<=(rmt); j++){
            MedicoTerran mt = new MedicoTerran();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( mt, 100 + x , 300 + y );
        }

        for( k=1; k<=5; k++){
            GuerreroTerran gt = new GuerreroTerran();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( gt, 100 + x , 500 + y );
        }

    }

}
