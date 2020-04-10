import greenfoot.*;  
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class TerranVSZerg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

  
public class TerranVSZerg extends World
{

    /**
     * Constructor for objects of class TerranVSZerg.
     * 
     */
    ArrayList<ConstructorTerran> lct;
    ArrayList<GuerreroTerran> lgt;
    ArrayList<MedicoTerran> lmt;
    ArrayList<ConstructorZerg> lcz;
    ArrayList<GuerreroZerg> lgz;
    ArrayList<MedicoZerg> lmz;
    List<ConstructorZerg> listCZ;
    List<GuerreroZerg> listGZ;
    List<MedicoZerg> listMZ;
    List<ConstructorTerran> listCT;
    List<GuerreroTerran> listGT;
    List<MedicoTerran> listMT;
    
    public void act() 
    {
        super.act();
        contadorEnergia();
    }
    
    public TerranVSZerg()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         super(1050, 700, 1);
        BaseDeCuracion bc = new BaseDeCuracion();
        addObject(bc, 580, 280);
        Start s11 = new Start();
        addObject(s11,100,100);
        Cementerio c = new Cementerio();
        addObject(c, 0, 0);
        generarZerg();
        generarProtos();
        lct = new ArrayList<ConstructorTerran>(); 
        lcz = new ArrayList<ConstructorZerg>();
        MinaDeGas m1 = new MinaDeGas();
        addObject(m1,900,400);
        Deposito d1 = new Deposito();
        addObject(d1,10,500);
        MinaCristal m2 = new MinaCristal();
        addObject(m2,303,650);        
        Barrera b1 = new Barrera();
        addObject(b1,800,50);
    }
    
    public void contadorEnergia(){
        int xZ=0;
        int pZ=0;
        int kZ=0;
        int xT=0;
        int pT=0;
        int kT=0;
        int totalT;
        int totalZ;
        listCZ = getObjects(ConstructorZerg.class);
        for(ConstructorZerg e : listCZ){
            xZ += e.getEnergia(); 
        }
        listGZ = this.getObjects(GuerreroZerg.class);
         for(GuerreroZerg e : listGZ){
            pZ += e.getEnergia(); 
        }
        listMZ = this.getObjects(MedicoZerg.class);
         for(MedicoZerg e : listMZ){
            kZ += e.getEnergia(); 
        }
        totalZ = kZ+pZ+xZ;
        System.out.print("Energia Zerg: ");
        System.out.println(totalZ);
        listCT = getObjects(ConstructorTerran.class);
        for(ConstructorTerran e : listCT){
            xT += e.getEnergia(); 
        }
        listGT = this.getObjects(GuerreroTerran.class);
         for(GuerreroTerran e : listGT){
            pT += e.getEnergia(); 
        }
        listMT = this.getObjects(MedicoTerran.class);
         for(MedicoTerran e : listMT){
            kT += e.getEnergia(); 
        }
        totalT = kT+pT+xT;
        System.out.print("Energia Terrans: ");
        System.out.println(totalT);
        if((totalZ <= 0) && (totalZ < totalT)){
          Letrero l1 = new Letrero("Ganador Terran");
          addObject(l1, 600,400);
          Letrero l2 = new Letrero("PULSAR START");
          addObject(l2, 550,600);
        }
        if((totalT <= 0) && (totalT < totalZ)){
          Letrero l1 = new Letrero("Ganador Zerg");
          addObject(l1, 600,400);
          Letrero l2 = new Letrero("PULSAR START");
          addObject(l2, 550,600);
        }
    }

    public void generarProtos(){

        int rmt = Greenfoot.getRandomNumber(10);
        int rct = Greenfoot.getRandomNumber(5);
        int rgt = ( 100- (35 +rct + rmt) );
        int i,j,k;

        for(  i=1; i<=(rct); i++){
            ConstructorTerran ct = new ConstructorTerran();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( ct, 1000 + x , 100 + y );
        }

        for( j=1; j<=(rmt); j++){
            MedicoTerran mt = new MedicoTerran();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( mt, 1000 + x , 300 + y );
        }

        for( k=1; k<=5; k++){
            GuerreroTerran gt = new GuerreroTerran();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( gt, 1000 + x , 500 + y );

        }

    }

    public void generarZerg(){

        int rmz = Greenfoot.getRandomNumber(10);
        int rcz = Greenfoot.getRandomNumber(5);
        int rgz = ( 100- (35 + rcz + rmz) );
        int i,j,k;

        for( i=1; i<=(rcz); i++){
            ConstructorZerg ct = new ConstructorZerg();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( ct, 100 + x , 100 + y );   
        }

        for( j=1; j<=(rmz); j++){
            MedicoZerg mt = new MedicoZerg();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( mt, 100 + x , 300 + y );
        }

        for( k=1; k<=5; k++){
            GuerreroZerg gt = new GuerreroZerg();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( gt, 100 + x , 500 + y );
        }

    }
}
