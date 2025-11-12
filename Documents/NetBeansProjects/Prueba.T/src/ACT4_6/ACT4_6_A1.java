package ACT4_6;

import prueba.t.UtilitatsArrays;
import prueba.t.UtilitatsConsola;
import java.util.ArrayList;
import ACT4_6.CucUtils;


 /**
  * Crea una classe que inicialitzi una matriu quadrada,
  * A continuació gestiona el joc del cuc.
  *     SIMBOL_FULLA --> fulla
  *     SIMBOL_BUIT  --> res
  *     des de 1 fins a (FULLA-1) --> part del cuc
  */

public class ACT4_6_A1 {
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String CIAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";
    public static final String FONDO_NEGRO = "\u001B[40m";
    public static final String FONDO_MORADO = "\u001B[45m";
    public static final String FONDO_VERDE = "\u001B[42m";
    public static final String FONDO_AZUL = "\u001B[44m";
    static int NTAULER;
    static int NFULLES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_FULLA = 99;
    static final int SIMBOL_CUC = 1;
    static final int SIMBOL_CAPCUC = 2;
    static int[][] tauler;
    static ArrayList<int[]> cuc = new ArrayList<>(); // [[m,n][k,l]...[a,b]] --> [a,b] és el cap, [m,n] és la cua 
    public static volatile int accio = 8;

    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NFULLES=UtilitatsConsola.llegirSencer("Nombre de fulles: ");
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        boolean condicionCumplida = false;
        System.out.println("Te sortira una ventana  ha de estar oberta per registrar els moviments");
        int contador = 10;
        CucUtils ventana = new CucUtils();
       
        // Bucle que se ejecuta cada 1000 ms
        while (!condicionCumplida) {
            System.out.println("Preparate: " + contador);
            if (contador == 0) {  // se detiene al llegar a 0
                condicionCumplida = true;
            }

            contador--;
            
            // Pausa de un segundo
            task.wait(1000);
        }
        emplenaTauler(tauler, cuc);
        mostrarTauler(tauler, cuc);
        do {
            task.wait(500);
            
            
            if (cambiaPosicio(tauler, cuc, accio))
                
                    if (cuc.size() == (NTAULER*NTAULER) - NFULLES) {
                        System.out.println("YOU WIN !!!");
                        accio = 0;
                    }
                else {
                    System.out.println("YOU LOSE !!!");
                    accio = 0;
                    break;
                }
            
            task.wait(500);
        } while (accio != 0);
    }
    
    public static void emplenaTauler(int[][] tauler, ArrayList<int[]> cuc) {
        final int MINIM = 0, MAXIM = tauler.length-1;
        int[] fulla;
        int[] posCuc = UtilitatsArrays.generaArray(2,0, tauler.length-1);

        // Genera posició Inicial cuc
        cuc.add(posCuc);
        
        // Situa cuc en el tauler
        pintaCuc(tauler,cuc);
        
        // Genera posició de cada fulla i situa en el tauler
        for (int i=0; i<NFULLES; i++) {
            afegeixFulla(tauler);
        }
    }
    
    public static void afegeixFulla(int[][] tauler) {
        int[] fulla;  // posicio nova fulla
        boolean okfulla = true;
        
        do {
            fulla  = UtilitatsArrays.generaArray(2,0, NTAULER-1); // genera posició de la fulla
            if (tauler[fulla[0]][fulla[1]] == SIMBOL_BUIT) { // situa la fulla al tauler si la posició està  buida
                tauler[fulla[0]][fulla[1]] = SIMBOL_FULLA;
                okfulla = false;
            }
        } while (okfulla);
    }
    
    public static boolean cambiaPosicio(int[][] tauler, ArrayList<int[]> cuc, int accio) {
        boolean esTropitja = false;
        int mida = tauler.length;
        int[] posCucCap = new int[] { cuc.get(cuc.size()-1)[0],
                                      cuc.get(cuc.size()-1)[1] }; // posició actual del cap és la darrera posició de l'arraylist
        int[] posCucCua = new int[] { cuc.get(0)[0],
                                      cuc.get(0)[1] };  // posició actual de la cua és la primera posició de l'arraylist
        
        switch (accio) {
            case 4 -> // ESQ
                posCucCap[1] = (posCucCap[1] == 0 ? mida-1 : posCucCap[1]-1); 
            case 6  -> // DRETA
                posCucCap[1] = (posCucCap[1] == mida-1 ? 0 : posCucCap[1]+1); 
            case 8  -> // ALT
                posCucCap[0] = (posCucCap[0] == 0 ? mida-1 : posCucCap[0]-1); 
            case 2 -> //BAIX
                posCucCap[0] = (posCucCap[0] == mida-1 ? 0 : posCucCap[0]+1); 
        }
        
        // re-escriure el cuc
        switch (tauler[posCucCap[0]][posCucCap[1]]) {
            case SIMBOL_FULLA -> { // cuc menja fulla
                cuc.add(posCucCap); // afegim posCuc a cuc
                afegeixFulla(tauler); // nova fulla
            }
            case SIMBOL_BUIT -> { // cuc es mou
                cuc.add(posCucCap); // afegim posCuc a cuc
                cuc.remove(0);  // eliminam cua a cuc
                tauler[posCucCua[0]][posCucCua[1]] = SIMBOL_BUIT;
            }
            default -> // cuc es tropitja
                esTropitja = true;
            
        }
        pintaCuc(tauler,cuc);
        return esTropitja;
    }
    
    public static void pintaCuc(int[][] tauler, ArrayList<int[]> cuc){
        int i=0;
        for (int[] pos : cuc) {
            tauler[pos[0]][pos[1]] = (i==cuc.size()-1 ? SIMBOL_CAPCUC: SIMBOL_CUC);
            i++;
        }
        
    }
 
    public static void mostrarTauler(int[][] tauler, ArrayList<int[]> cuc) {
    new Thread(() -> {
        try {
            do {
                Thread.sleep(100);  
                String car = "";
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + "Puntuació: " + cuc.size() +  " | W:ALT, A:ESQUERRA, D:DRETA, S:BAIX; 0:SORTIR: " + accio);
                for (int i = 0; i < tauler.length; i++) {
                    System.out.print('|');
                    for (int j = 0; j < tauler[i].length; j++) {
                        switch (tauler[i][j]) {
                            case SIMBOL_BUIT -> car = FONDO_MORADO + "   " + FONDO_NEGRO;
                            case SIMBOL_FULLA -> car = FONDO_AZUL + " * " + FONDO_NEGRO;
                            case SIMBOL_CAPCUC -> car = FONDO_VERDE + " O " + FONDO_NEGRO;
                            case SIMBOL_CUC -> car = FONDO_VERDE + " . " + FONDO_NEGRO;
                        }
                        System.out.print(car);
                    }
                    System.out.println("|");
                }
                synchronized(cuc) {
                    pintaCuc(tauler, cuc);
                }
            } while (accio != 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } }).start(); // Aquí arranca el hilo!
    }
    
}