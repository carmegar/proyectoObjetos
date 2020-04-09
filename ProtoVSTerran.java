import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

import java.io.FileReader;
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
    List<ConstructorTerran> listCT;
    
    public ProtoVSTerran()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(1050, 700, 1);
        BaseDeCuracion bc = new BaseDeCuracion();
        addObject(bc, 580, 280);
        StartPVT s12 = new StartPVT();
        addObject(s12,100,100);
        Cementerio c = new Cementerio();
        addObject(c, 0, 0);
        MinaDeGas m1 = new MinaDeGas();
        addObject(m1,800,400);
        Deposito d1 = new Deposito();
        addObject(d1,400,500);
        Barrera b1 = new Barrera();
        addObject(b1,800,50);
            generarTerran();
            generarProtos();
            lcp = new ArrayList<ConstructorProto>();
            lct = new ArrayList<ConstructorTerran>();
            
        MinaCristal m2 = new MinaCristal();
        addObject(m2,600,600);        
    }
    
    public boolean revisaArchivo(){
        String linea = "";
        int cntL = 0;
        int c;
        try {
            FileReader reader = new FileReader("pvz.txt");
            while ((c = reader.read()) != -1) {
                if(c == 10){
                    // Analiza linea
                    cntL++;
                    System.out.println(linea);
                    
                }
                if((c != 10) && (c != 13)){
                    linea = linea + (char)c;
                }
            }
            if(cntL == 1){
                System.out.println("Inicia de cero el mapa");
                return false;
            }
            System.out.println(linea);
            System.out.println(c);
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public void contadorEnergia(){
        listCP = this.getObjects(ConstructorProto.class);
        listCT = this.getObjects(ConstructorTerran.class);
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
