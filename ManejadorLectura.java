/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LCDTester;

import static LCDTester.LCDTester.CADENA_FINAL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Marvin Daniel Cely Báez
 */
public class ManejadorLectura {
    /**
     *
     * Metodo que valida el comando leido
     *
     * @param comando tiene la cadena que reprecenta el tamaño de la diagonal
     */
    public static int getEspacioDig(String comando){
        int espacioDig;
        // Valida si es un numero
        if (ImpresorLCD.isNumeric(comando))
                    espacioDig = Integer.parseInt(comando);
                else 
                    throw new IllegalArgumentException("Cadena " + comando
                            + " no es un entero.");
                
        // Valida que el espaciado este entre 0 y 5
        if (espacioDig < 0 || espacioDig > 5)
            throw new IllegalArgumentException("El espacio entre "
                    + "digitos debe estar entre 0 y 5.");
        return espacioDig;
    }
    
     /**
     *
     * Metodo que valida el comando leido
     *
     * @param lector Tiene la consecución de valores de entrada por pantalla
     */
    public static List<String> getListComando(Scanner lector){
        List<String> listaComando = new ArrayList<>();
        String comando;
        // Recibe Comandos hasta que comando == 0,0
        while(true){
            System.out.print("Entrada: ");
            comando = lector.next();
            if (!comando.equalsIgnoreCase(CADENA_FINAL))
                listaComando.add(comando);
            else break;
        }
        return listaComando;
    }
    
    /**
     *
     * Metodo que valida el comando leido
     *
     * @param listaComando contiene la lista de digitos para imprimir
     * @param espacioDig Espacio Entre digitos
     */
    public static void imprimirLCD(List<String> listaComando,int espacioDig){
        ImpresorLCD impresorLCD = new ImpresorLCD();            
        for (String lc : listaComando) {
            impresorLCD.procesar(lc, espacioDig);
        }
    }
}
