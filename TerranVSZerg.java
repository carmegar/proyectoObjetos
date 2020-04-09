import greenfoot.*;  
import java.util.ArrayList;
import java.util.List;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    List<ConstructorTerran> listCT;
    List<ConstructorZerg> listCZ;
    
    public TerranVSZerg()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         super(1050, 700, 1);
        BaseDeCuracion bc = new BaseDeCuracion();
        addObject(bc, 580, 280);
        StartTVZ s11 = new StartTVZ();
        addObject(s11,100,100);
        Cementerio c = new Cementerio();
        addObject(c, 0, 0);
        MinaDeGas m1 = new MinaDeGas();
        addObject(m1,800,400);
        Deposito d1 = new Deposito();
        addObject(d1,400,500);
        Barrera b1 = new Barrera();
        addObject(b1,800,50);
        
            generarZerg();
            generarProtos();
            lct = new ArrayList<ConstructorTerran>(); 
            lcz = new ArrayList<ConstructorZerg>();
            
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
        listCT = this.getObjects(ConstructorTerran.class); 
        listCZ = this.getObjects(ConstructorZerg.class);
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
