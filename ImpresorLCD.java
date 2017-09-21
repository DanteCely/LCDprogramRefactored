package LCDTester;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImpresorLCD {

    // Puntos fijos
    private final int[] pf1;
    private final int[] pf2;
    private final int[] pf3;
    private final int[] pf4;
    private final int[] pf5;
    private String[][] matrizImpr;

    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";

    // TODO code application logic here
    //String entrada = JOptionPane.showInputDialog("Digite el numero");
    private int size;

    // Calcula el numero de filasDig
    private int filasDig;
    private int columDig;
    private int totalFilas;
    private int totalColum;

    public ImpresorLCD() {
        // Inicializa variables
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
    }

    /**
     *
     * Metodo encargado de añadir una linea a la matriz de Impresion
     *
     * @param matriz Matriz Impresion
     * @param punto Punto Pivote
     * @param posFija Posicion Fija
     * @param size Tamaño Segmento
     * @param caracter Caracter Segmento
     */
    private void adicionarLinea(String[][] matriz, int[] punto, String posFija,
            int size, String caracter) {

        if (posFija.equalsIgnoreCase(POSICION_X)) {
            for (int y = 1; y <= size; y++) {
                int valor = punto[1] + y;
                matriz[punto[0]][valor] = caracter;
            }
        } else {
            for (int i = 1; i <= size; i++) {
                int valor = punto[0] + i;
                matriz[valor][punto[1]] = caracter;
            }
        }
    }

    /**
     *
     * Metodo encargado de un segmento a la matriz de Impresion
     *
     * @param segmento Segmento a adicionar
     */
    private void adicionarSegmento(int segmento) {

        switch (segmento) {
            case 1:
                adicionarLinea(this.matrizImpr, this.pf1, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 2:
                adicionarLinea(this.matrizImpr, this.pf2, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 3:
                adicionarLinea(this.matrizImpr, this.pf5, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 4:
                adicionarLinea(this.matrizImpr, this.pf4, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 5:
                adicionarLinea(this.matrizImpr, this.pf1, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 6:
                adicionarLinea(this.matrizImpr, this.pf2, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 7:
                adicionarLinea(this.matrizImpr, this.pf3, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }

    /**
     *
     * Metodo encargado de definir los segmentos que componen un digito y a
     * partir de los segmentos adicionar la representacion del digito a la
     * matriz
     *
     * @param numero Digito
     */
    private void adicionarDigito(int numero) {

        // Establece los segmentos de cada numero
        List<Integer> segList = new ArrayList<>();

        switch (numero) {
            case 1:
                segList.add(3);
                segList.add(4);
                break;
            case 2:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                break;
            case 3:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 4:
                segList.add(1);
                segList.add(6);
                segList.add(3);
                segList.add(4);
                break;
            case 5:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 6:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                segList.add(4);
                break;
            case 7:
                segList.add(5);
                segList.add(3);
                segList.add(4);
                break;
            case 8:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 9:
                segList.add(1);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 0:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(7);
                break;
            default:
                break;
        }
        
        for (Integer i : segList) {
            adicionarSegmento(i);
        }
    }

    /**
     *
     * Metodo encargado de inicializar la Matriz segun filas, columnas y 
     * el valor
     *
     * @param filas de la matriz
     * @param columnas de la matriz
     * @param valor para cada casilla de la matriz
     */
    private String[][] inicializarMatriz(int filas,int columnas,String valor){
        String[][] mat = new String[filas][columnas];;
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                mat[i][j] = valor;
            }
        }
        return mat;
    }
    
    /**
     *
     * Metodo encargado de calcular filas y columnas
     *
     * @param size Tamaño Segmento Digitos
     * @param numeroImp Numero a Imprimir
     * @param espacio Espacio Entre digitos
     */
    private void calcFilCol(int size, String numeroImp, int espacio){
        
        this.size = size;

        // Calcula el numero de filas cada digito
        this.filasDig = (2 * this.size) + 3;

        // Calcula el numero de columna de cada digito
        this.columDig = this.size + 2;

        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        this.totalFilas = this.filasDig;

        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        this.totalColum = (this.columDig * numeroImp.length())
                + (espacio * numeroImp.length());
    }
    
    /**
     *
     * Metodo encargado de validar y añadir digitos
     *
     * @param digitos Tamaño Segmento Digitos
     * @param espacio Numero a Imprimir
     */
    private void addDigitos(char[] digitos, int espacio){
        
        int pivotX = 0;
        
        for (char digito : digitos) {

            //Valida que el caracter sea un digito
            if (!Character.isDigit(digito))
                throw new IllegalArgumentException("Caracter " + digito
                        + " no es un digito");

            int numero = Integer.parseInt(String.valueOf(digito));

            //Calcula puntos fijos
            this.pf1[0] = 0;
            this.pf1[1] = 0 + pivotX;

            this.pf2[0] = (this.filasDig / 2);
            this.pf2[1] = 0 + pivotX;

            this.pf3[0] = (this.filasDig - 1);
            this.pf3[1] = 0 + pivotX;

            this.pf4[0] = (this.columDig - 1);
            this.pf4[1] = (this.filasDig / 2) + pivotX;

            this.pf5[0] = 0;
            this.pf5[1] = (this.columDig - 1) + pivotX;

            pivotX = pivotX + this.columDig + espacio;

            adicionarDigito(numero);
        }
    }
    
     /**
     *
     * Metodo encargado de imprimir la matriz
     *
     */
    private void imprimirMatriz(){
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                System.out.print(this.matrizImpr[i][j]);
            }
            System.out.println();
        }
    }
    
    /**
     *
     * Metodo encargado de imprimir un numero
     *
     * @param size Tamaño Segmento Digitos
     * @param numeroImp Numero a Imprimir
     * @param espacio Espacio Entre digitos
     */
    private void imprimirNumero(int size, String numeroImp, int espacio) {

        //Calcula filas, columnas de la matriz
        calcFilCol(size, numeroImp, espacio);

        // Inicializa matriz
        this.matrizImpr = inicializarMatriz(this.totalFilas,this.totalColum," ");        

        // crea el arreglo de digitos
        addDigitos(numeroImp.toCharArray(), espacio);  
   
        // Imprime matriz
        imprimirMatriz();        
    }

    /**
     *
     * Metodo encargado de procesar la entrada que contiene el size del segmento
     * de los digitos y los digitos a imprimir
     *
     * @param comando Entrada que contiene el size del segmento de los digito y
     * el numero a imprimir
     * @param espacioDig Espacio Entre digitos
     */
    public void procesar(String comando, int espacioDig) {
        
        if (!comando.contains(","))
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene caracter ,");        
        // Hace el split de la cadena
        String[] parametros = comando.split(",");
        
        // Realiza la impresion del número
        imprimirNumero( getTamaño(parametros,comando), parametros[1], espacioDig);

    }
    
    /**
     *
     * Metodo encargado de validar la Entrada de los parametros y retorna el
     * tamaño del número en el display
     *
     * @param comando Entrada que contiene el size del segmento de los digito y
     * el numero a imprimir
     * @param espacioDig Espacio Entre digitos
     */
    static int getTamaño(String[] parametros, String comando) {
        int tam;
        // Valida la cantidad de parametros
        if(parametros.length != 2){
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene los parametros requeridos");
        }
        
        //Valida que el parametro size sea un numérico
        if (isNumeric(parametros[0]))
            tam = Integer.parseInt(parametros[0]);
        else
            throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                    + "] no es un numero");
        
        // Valida que el size este entre 1 y 10
        if (tam < 1 || tam > 10)
            throw new IllegalArgumentException("El parametro size [" + tam
                    + "] debe estar entre 1 y 10");
        return tam;
    }

    /**
     *
     * Metodo encargado de validar si una cadena es numerica
     *
     * @param cadena Cadena
     */
    static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
