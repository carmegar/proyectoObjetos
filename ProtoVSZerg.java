import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    List<ConstructorZerg> listCZ;
    
    public ProtoVSZerg()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         super(1050, 700, 1);
        BaseDeCuracion bc = new BaseDeCuracion();
        addObject(bc, 580, 280);
        StartPVZ s10 = new StartPVZ();
        addObject(s10,100,100);
        Cementerio c = new Cementerio();
        addObject(c, 0, 0);
        MinaDeGas m1 = new MinaDeGas();
        addObject(m1,800,400);
        Deposito d1 = new Deposito();
        addObject(d1,400,500);
        Barrera b1 = new Barrera();
        addObject(b1,800,50);
        if(revisaArchivo() == false){
            generarZerg();
            generarProtos();
            lcp = new ArrayList<ConstructorProto>();
            lcz = new ArrayList<ConstructorZerg>();
        }
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
        listCZ = this.getObjects(ConstructorZerg.class);
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
