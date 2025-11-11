/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.t;

import java.util.Scanner;

/**
 *
 * @author Julen
 */
public class PruebaT {

    
    public static void main(String[] args) {
       int[] array = {5,2,3,4};
       Scanner scanner = new Scanner(System.in);
       UtilitatsArrays.mostraArray(array);
       UtilitatsArrays.sumaArray(array);
      
       System.out.println(UtilitatsArrays.maximArray(array));
       System.out.println(UtilitatsArrays.minArray(array));
       System.out.println("Introduce valores para generar un array");
      
       //array = UtilitatsArrays.generaArray(longitud, min, max);
       UtilitatsArrays.mostraArray(array);
       scanner.close();
    }
    
}
