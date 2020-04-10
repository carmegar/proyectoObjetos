import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Write a description of class ProtoVSTerran here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProtoVSTerran extends World
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
    
    MouseInfo mouseInfo;
    
    public void act() 
    {
        super.act();
        contadorEnergia();
        if (Greenfoot.mouseClicked(this)) {
            mouseInfo = Greenfoot.getMouseInfo();
            int x = mouseInfo.getX();
            int y = mouseInfo.getY();
            if((x >= 22) && (x <= 182) && (y >= 55) && (y <= 130)){
                System.out.println("Escribe archivo");
                escribirArchivo();
            }
        }
    }
    
    public void escribirArchivo()
    {
        try {
                FileWriter writer = new FileWriter("pvt.txt");
                writer.write("Datos del encuentro Protos vs Terran");
                writer.write("\n\n");
                writer.write("Energia\tX\tY\n");
                writer.write("********************************\n");
                writer.write("Protos\n");
                writer.write("********************************\n");
                
                listCP = this.getObjects(ConstructorProto.class);
        for(ConstructorProto e : listCP){
            writer.write(e.getEnergia());
            writer.write("\t");
            writer.write(e.getX());
            writer.write("\t");
            writer.write(e.getY());
            writer.write("\n");
        }
        listGP = this.getObjects(GuerreroProto.class);
         for(GuerreroProto e : listGP){
            writer.write(e.getEnergia());
            writer.write("\t");
            writer.write(e.getX());
            writer.write("\t");
            writer.write(e.getY());
            writer.write("\n");
        }
        listMP = this.getObjects(MedicoProto.class);
         for(MedicoProto e : listMP){
            writer.write(e.getEnergia());
            writer.write("\t");
            writer.write(e.getX());
            writer.write("\t");
            writer.write(e.getY());
            writer.write("\n");
        }
        writer.close();
        
                writer.write("********************************\n");
                writer.write("Terran\n");
                writer.write("********************************\n");
                
                listCP = this.getObjects(ConstructorProto.class);
                
                
        listCP = this.getObjects(ConstructorProto.class);
        for(ConstructorProto e : listCP){
            writer.write(e.getEnergia());
            writer.write("\t");
            writer.write(e.getX());
            writer.write("\t");
            writer.write(e.getY());
            writer.write("\n");
        }
        listGP = this.getObjects(GuerreroProto.class);
         for(GuerreroProto e : listGP){
            writer.write(e.getEnergia());
            writer.write("\t");
            writer.write(e.getX());
            writer.write("\t");
            writer.write(e.getY());
            writer.write("\n");
        }
        listMP = this.getObjects(MedicoProto.class);
         for(MedicoProto e : listMP){
            writer.write(e.getEnergia());
            writer.write("\t");
            writer.write(e.getX());
            writer.write("\t");
            writer.write(e.getY());
            writer.write("\n");
        }
        writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    
    public ProtoVSTerran()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 700, 1);
        //organiar a gusto, aca se generan los objetos
        BaseDeCuracion bc = new BaseDeCuracion();
        //se ubican en el mapa, esto funciona para todos los objetos de tipo act()
        addObject(bc, 580, 280);
        StartPVT s12 = new StartPVT();
        addObject(s12,100,100);
        Cementerio c = new Cementerio();
        addObject(c, 0, 0);
        MinaDeGas m1 = new MinaDeGas();
        addObject(m1,900,400);
        Deposito d1 = new Deposito();
        addObject(d1,10,500);
        MinaCristal m2 = new MinaCristal();
        addObject(m2,303,650);        
        Barrera b1 = new Barrera();
        addObject(b1,800,50);
        generarTerran();
        generarProtos();
        lcp = new ArrayList<ConstructorProto>();
        lct = new ArrayList<ConstructorTerran>();
    }
    
    public void contadorEnergia(){
        int xT=0;
        int pT=0;
        int kT=0;
        int xP=0;
        int pP=0;
        int kP=0;
        int totalT;
        int totalP;
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
        if((totalT <= 0) && (totalT < totalP)){
          Letrero l1 = new Letrero("Ganador Proto");
          addObject(l1, 600,400);
          Letrero l2 = new Letrero("PULSAR START");
          addObject(l2, 550,600);
        }
        if((totalP <= 0) && (totalP < totalT)){
          Letrero l1 = new Letrero("Ganador Terran");
          addObject(l1, 600,400);
          Letrero l2 = new Letrero("PULSAR START");
          addObject(l2, 550,600);
        }
    }
    
    public void contadorEnergiaTerran(){
        int x= 0;
        listCT = getObjects(ConstructorTerran.class);
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
        int total;
        total = k+p+x;
        System.out.print("Energia Terrans: ");
        System.out.println(total);
        if(total <= 0){
          Letrero l1 = new Letrero("Ganador Proto");
          addObject(l1, 600,400);
          Letrero l2 = new Letrero("PULSAR BOTON DE START, para volver");
          addObject(l2, 550,600);
        }
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
        int total;
        total = k+p+x;
        System.out.print("Energia Protos: ");
        System.out.println(total);
        
        if(total <= 0){
          Letrero l1 = new Letrero("Ganador Terran");
          addObject(l1, 600,400);
          Letrero l2 = new Letrero("PULSAR BOTON DE START, para volver");
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
