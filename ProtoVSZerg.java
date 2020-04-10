import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class ProtoVSZerg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProtoVSZerg extends World
{

    /**
     * Constructor for objects of class ProtoVSZerg.
     * 
     */
    ArrayList<ConstructorProto> lcp;
    ArrayList<GuerreroProto> lgp;
    ArrayList<MedicoProto> lmp;
    ArrayList<ConstructorZerg> lcz;
    ArrayList<GuerreroZerg> lgz;
    ArrayList<MedicoZerg> lmz;
    List<ConstructorProto> listCP;
    List<GuerreroProto> listGP;
    List<MedicoProto> listMP;
    List<ConstructorZerg> listCZ;
    List<GuerreroZerg> listGZ;
    List<MedicoZerg> listMZ;
    
    public void act() 
    {
        super.act();
        contadorEnergia();
    }
    
    public ProtoVSZerg()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         super(1050, 700, 1);
        BaseDeCuracion bc = new BaseDeCuracion();
        addObject(bc, 580, 280);
        Start s10 = new Start();
        addObject(s10,100,100);
        Cementerio c = new Cementerio();
        addObject(c, 0, 0);
        generarZerg();
        generarProtos();
        lcp = new ArrayList<ConstructorProto>();
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
        int xP=0;
        int pP=0;
        int kP=0;
        int totalZ;
        int totalP;
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
        listCP = this.getObjects(ConstructorProto.class);
        for(ConstructorProto e : listCP){
            xP += e.getEnergia(); 
        }
        listGP = this.getObjects(GuerreroProto.class);
         for(GuerreroProto e : listGP){
            pP += e.getEnergia(); 
        }
        listMP = this.getObjects(MedicoProto.class);
         for(MedicoProto e : listMP){
            kP += e.getEnergia(); 
        }
        totalP = kP+pP+xP;
        System.out.print("Energia Protos: ");
        System.out.println(totalP);
        if((totalZ <= 0) && (totalZ < totalP)){
          Letrero l1 = new Letrero("Ganador Proto");
          addObject(l1, 600,400);
          Letrero l2 = new Letrero("PULSAR START");
          addObject(l2, 550,600);
        }
        if((totalP <= 0) && (totalP < totalZ)){
          Letrero l1 = new Letrero("Ganador Zerg");
          addObject(l1, 600,400);
          Letrero l2 = new Letrero("PULSAR START");
          addObject(l2, 550,600);
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

    public void generarZerg(){

        int rmz = Greenfoot.getRandomNumber(10);
        int rcz = Greenfoot.getRandomNumber(5);
        int rgz = ( 100- (35 + rcz + rmz) );
        int i,j,k;

        for( i=1; i<=(rcz); i++){
            ConstructorZerg cz = new ConstructorZerg();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( cz, 100 + x , 100 + y );   
        }

        for( j=1; j<=(rmz); j++){
            MedicoZerg mz = new MedicoZerg();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( mz, 100 + x , 300 + y );
        }

        for( k=1; k<=5; k++){
            GuerreroZerg gz = new GuerreroZerg();
            int x = Greenfoot.getRandomNumber(100);
            int y = Greenfoot.getRandomNumber(100);
            addObject( gz, 100 + x , 500 + y );
        }

    }

}
