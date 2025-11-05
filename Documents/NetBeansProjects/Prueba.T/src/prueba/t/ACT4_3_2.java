/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.t;

import java.util.Scanner;
import prueba.t.UtilitatsMatrius;
import prueba.t.UtilitatsArrays;

/**
 *
 * @author Julen
 */
public class ACT4_3_2 {

    
    public static void main(String[] args) {
       int numAlumnos = 5;
       int min = 0;
       int max = 10;
       
       String[] alumnos = UtilitatsArrays.generaArrayAlumnes(numAlumnos);
       
       int [][] notes = UtilitatsMatrius.generaMatriu(numAlumnos, min, max);
       
       for (int i = 0; i < alumnos.length; ++i){
        System.out.print(alumnos[i] + ":");
        UtilitatsArrays.mostraArray(notes[i]);
        UtilitatsArrays.mitjanaArrays(notes[i]);
       }
    }
    
}
