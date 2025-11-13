/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT4_6;
import prueba.t.UtilitatsConsola;
import prueba.t.UtilitatsArrays;
import prueba.t.UtilitatsMatrius;
import java.util.Scanner;

/**
 *
 * @author Julen
 */
public class ACT4_6_V1 {
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_CUC = 1;
    static final int SIMBOL_FULLA = 9;
    static final int NTAULER = UtilitatsConsola.llegirSencer("Introdueixi la mida del tauler: ");
    static final int NFULLES = UtilitatsConsola.llegirSencer("Numero de fulles: ");
    //CONTROLES:
    
    static final int M_ARRIBA = 8;
    static final int M_ABAJO = 2;
    static final int M_DERECHA = 6;
    static final int M_IZQUIERDA = 4;
    static final int SALIR = 0;
    
   public static void main(String[] args){
        
       
        int accio;
        int [][] tauler = new int[NTAULER][NTAULER];
        //COA DE CUC Y SU POSICIO:
        //NUMERO DE COAS POSIBLES,POSICIONES Y DIRRECION
        int [][] coa = new int [5][3];
        
        // CUC[0] = FILA, CUC[1] = COLUMNA
        int [] cuc = UtilitatsArrays.generaArray(2, 0, NTAULER-1);
        
        emplenaTauler(tauler,cuc);
        do {
            accio = UtilitatsConsola.llegirSencer("Accio a realitzar(2,4,6,8,0): ");

            cambiaPosicio(tauler,cuc,accio,coa);

            // Mostra el tauler
            UtilitatsArrays.mostraArray(cuc);
            UtilitatsMatrius.mostrarMatriu(tauler);
        } while (accio != 0);

   } 
    public static void emplenaTauler(int[][] tauler, int[] cuc){
       int[] fulla;
       tauler[cuc[0]][cuc[1]] = SIMBOL_CUC;
       System.out.println(cuc[0] + " " + cuc[1]);
       int nfulles = 0;
       while (nfulles <= NFULLES) {
           
           fulla = UtilitatsArrays.generaArray(2,0,NTAULER - 1);
           if (tauler[fulla[0]][fulla[1]] == SIMBOL_BUIT) {
              tauler[fulla[0]][fulla[1]] = SIMBOL_FULLA;
              nfulles++;
            }
        }
       /*
       for (int i = 0; i < NFULLES; ++i){
           fulla = UtilitatsArrays.generaArray(2, 0, NTAULER-1);
           if (tauler[fulla[0]][fulla[1]] != 0){
               i--;
               System.out.println("hay que probar con otra cosa");
           } else {tauler[fulla[0]][fulla[1]] = 9;}
       }
       */ 
    }
    public static void cambiaPosicio(int[][] tauler, int[] cuc, int accio, int [][]coa){
        
        //ELIMINO LA POSICION ACTUAL DE CUC
        tauler[cuc[0]][cuc[1]] = SIMBOL_BUIT;
        
        int fila = cuc[0]; int columna = cuc[1];
        int lastRow = 0;
        int lastColumn = 0;
        
        //LOGICA DE CAMIBOS:
        switch (accio){
            case M_ARRIBA:
                if (cuc[0] == 0)
                    cuc[0] = NTAULER - 1;
                else
                    cuc[0]--;
                break;
            case M_ABAJO:
                if (cuc[0] == NTAULER - 1)
                    cuc[0] = 0;
                else
                    cuc[0]++;
                break;
            case M_DERECHA:
                if (cuc[1] == NTAULER - 1)
                    cuc[1] = 0;
                else
                    cuc[1]++;
                break;
            case M_IZQUIERDA:
                if (cuc[1] == 0)
                    cuc[1] = NTAULER - 1;
                else
                    cuc[1]--;
                break;
        }
        
        
        //APLICAR CAMBIOS:
        if (tauler[cuc[0]][cuc[1]] == SIMBOL_FULLA){
            
            for (int i = 1; i < coa.length; i++){
                System.out.println("FULLA I NUMBER:" + i + " Valores: " + fila + " " + columna);
                if (i == 1){
                      
                        coa[i][0] = fila;
                        coa[i][1] = columna;
                        
                        //DECIMOS QUE EXISTE ESTA COA
                        if (coa[i][2] == 0){
                          coa[i][2] = 1;
                          break;
                        }
                    } else{
                       
                        coa[i][0] = coa[i - 1][0];
                        coa[i][1] = coa[i - 1][1];
                        //DECIMOS QUE EXISTE ESTA COA
                        if (coa[i][2] == 0){
                            coa[i][2] = 1;
                            
                            // Verificamos La siguente Cola para no añadir mas colas
                            if (coa[i + 1][2] == 0)
                                break;
                        }
                        
                        
                }  
            }
            
        } else if (tauler[cuc[0]][cuc[1]] == SIMBOL_BUIT){
            
            for (int i = 1; i < coa.length; i++){
                System.out.println("BUIT I NUMBER:" + i);
                if (i == 1){
                    if (coa[i][2] == 1) {
                        coa[i][0] = fila;
                        coa[i][1] = columna; 
                    }
                } else if (coa[i][2] == 1) {
                    coa[i][0] = coa[i - 1][0];
                    coa[i][1] = coa[i - 1][1];
                }
            }
        }
        lastRow = fila;
        lastColumn = columna;
        UtilitatsMatrius.mostrarMatriu(coa);
        tauler[cuc[0]][cuc[1]] = SIMBOL_CUC;
        
    }
}
