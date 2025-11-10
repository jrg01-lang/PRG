/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.t;

import java.util.Scanner;
import prueba.t.UtilitatsMatrius;
import prueba.t.UtilitatsArrays;
import prueba.t.UtilitatsConsola;

/**
 *
 * @author Julen
 */
public class ACT4_3_2 {
    public static final String ROJO = "\u001B[31m";
    
    public static final String RESET = "\u001B[0m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String CIAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";
    public static final String FONDO_NEGRO = "\u001B[40m";
    public static final String FONDO_ROJO = "\u001B[41m";
    public static final String FONDO_VERDE = "\u001B[42m";
    public static final String FONDO_AZUL = "\u001B[44m";
    public static void ChangeNames(String[] alumnos) {
        System.out.println("");
        for (int i = 0; i < alumnos.length; i++) {
            System.out.print(MORADO);
            System.out.println(i + ". " + alumnos[i]);
        }
        int resposta = UtilitatsConsola.llegirSencer("Select a Option\n");
        
    }
    public static void gestionarMenu(String[] alumnos, int[][] notes ) {
        UtilitatsConsola.calvera();
        System.out.println( FONDO_NEGRO + MORADO + "MENU CHEATER v1.0.0 BY SkUlldROPPER102\n");
        System.out.println( FONDO_NEGRO + CIAN + "1. CHANGE NOTES");
        System.out.println( FONDO_NEGRO + CIAN + "2. CHANGE NAMES");
        System.out.println( FONDO_NEGRO + VERDE + "3. EXIT \n");
        
        int resposta = UtilitatsConsola.llegirSencer("Select a Option\n");
        if (resposta == 3){
          System.out.println("CLOSING...");
        } else if (resposta == 2) {
            ChangeNames(alumnos);
        } else if (resposta == 1) {
            ChangeNames(alumnos);
        }
    }
    
    public static void main(String[] args) {
      
       int numAlumnos = 3;
       int min = 0;
       int max = 10;
       
       String[] alumnos = UtilitatsArrays.generaArrayAlumnes(numAlumnos);
       
       int [][] notes = UtilitatsMatrius.generaMatriu(numAlumnos, min, max);
       
       for (int i = 0; i < alumnos.length; ++i){
        System.out.print(alumnos[i] + ":");
        UtilitatsArrays.mostraArray(notes[i]);
        UtilitatsArrays.mitjanaArrays(notes[i]);
       }
       String resposta = UtilitatsConsola.llegirCadena("Quieres Hacer Trampa?");
       if (resposta.equalsIgnoreCase("si")){
           gestionarMenu(alumnos, notes);
       } 
    }
    
}
