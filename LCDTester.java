package LCDTester;

import java.util.List;
import java.util.Scanner;

public class LCDTester {
    
    static final String CADENA_FINAL = "0,0";

    public static void main(String[] args) {
        
        try (Scanner lector = new Scanner(System.in)) {
            System.out.print("Espacio entre Digitos (0 a 5): ");
            
            // Establece los segmentos de cada numero
            int espacioDig = ManejadorLectura.getEspacioDig(lector.next());                
            List<String> listaComando = ManejadorLectura.getListComando(lector);   
            ManejadorLectura.imprimirLCD(listaComando,espacioDig);            
            
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

}
