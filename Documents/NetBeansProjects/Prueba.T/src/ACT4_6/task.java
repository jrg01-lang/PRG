/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT4_6;

/**
 *
 * @author Julen
 */
public class task {
    public static final String FONDO_VERDE = "\u001B[42m";
    public static final String FONDO_NEGRO = "\u001B[40m";
    public static void clear() {
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
    }
    public static void wait(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            // Si alguien interrumpe el hilo, simplemente lo ignoramos o lo manejamos
            Thread.currentThread().interrupt(); // buena práctica
        }
    }
}
