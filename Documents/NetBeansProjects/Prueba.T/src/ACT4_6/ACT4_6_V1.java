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
    
   public static void main(String[] args){
        
       
        
        int [][] tauler = new int[NTAULER][NTAULER];
        int [] cuc = UtilitatsArrays.generaArray(2, 0, NTAULER-1);
        
        emplenaTauler(tauler,cuc);
        
        UtilitatsArrays.mostraArray(cuc);
        UtilitatsMatrius.mostrarMatriu(tauler);
   } 
   public static void emplenaTauler(int[][] tauler, int[] cuc){
       int[] fulla;
       tauler[cuc[0]][cuc[1]] = SIMBOL_CUC;
       for (int i = 0; i < NFULLES; ++i){
           fulla = UtilitatsArrays.generaArray(2, 0, NTAULER-1);
           if (tauler[fulla[0]][fulla[1]] != 0){
               i--;
               System.out.println("hay que probar con otra cosa");
           } else {tauler[fulla[0]][fulla[1]] = 9;}
       }
       
       
   }
}
