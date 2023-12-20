import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @author
 * @author
 * @version     1.0
 */
public class Porte {
    private boolean[][] huecos;
    private String id;
    private Nave nave;
    private PuertoEspacial origen;
    private int muelleOrigen;
    private Fecha salida;
    private PuertoEspacial destino;
    private int muelleDestino;
    private Fecha llegada;
    private double precio;
    private ListaEnvios listaEnvios;

    /**
     * TODO: Completa el constructo de la clase
     * 
     * @param id
     * @param nave
     * @param origen
     * @param muelleOrigen
     * @param salida
     * @param destino
     * @param muelleDestino
     * @param llegada
     * @param precio
     */
    public Porte(String id, Nave nave, PuertoEspacial origen, int muelleOrigen, Fecha salida, PuertoEspacial destino, int muelleDestino, Fecha llegada, double precio) {
        this.id = id;
        this.nave = nave;
        this.origen = origen;
        this.muelleOrigen = muelleOrigen;
        this.salida = salida;
        this.destino = destino;
        this.muelleDestino = muelleDestino;
        this.llegada = llegada;
        this.precio = precio;
        huecos = new boolean[nave.getFilas()][nave.getColumnas()];
        listaEnvios = new ListaEnvios(nave.getColumnas()*nave.getFilas());
    }
    public String getID() {
        return id;
    }
    public Nave getNave(){
        return nave;
    }
    public PuertoEspacial getOrigen() {
        return origen;
    }
    public int getMuelleOrigen() {
        return muelleOrigen;
    }
    public Fecha getSalida(){
        return salida;
    }
    public PuertoEspacial getDestino() {
        return destino;
    }
    public int getMuelleDestino() {
        return muelleDestino;
    }
    public Fecha getLlegada() {
        return llegada;
    }
    public double getPrecio() {
        return precio;
    }
    // TODO: Devuelve el número de huecos libres que hay en el porte
    public int numHuecosLibres() {
        int huecosLibres = 0;
        for(int i = 0; i<nave.getFilas(); i++){
            for(int j = 0; j<nave.getColumnas(); j++){
                if(huecos[i][j]==false){
                    huecosLibres++;
                }
            }
        }
        return huecosLibres;
    }
    // TODO: ¿Están llenos todos los huecos?
    public boolean porteLleno() {
        return numHuecosLibres() == 0;
    }
    // TODO: ¿Está ocupado el hueco consultado?
    public boolean huecoOcupado(int fila, int columna) {
        return huecos[fila][columna];
    }
    public Envio buscarEnvio(String localizador) {
        return listaEnvios.buscarEnvio(localizador);
    }


    /**
     * TODO: Devuelve el objeto Envio que corresponde con una fila o columna,
     * @param fila
     * @param columna
     * @return el objeto Envio que corresponde, o null si está libre o se excede en el límite de fila y columna
     */
    public Envio buscarEnvio(int fila, int columna) {
        Envio envio = null;
        boolean envioEncontrado = false;
        int fila2 = 1;
        int columna2 = 1;
        while(fila2 <= fila && envioEncontrado == false){
            while(columna2 <= columna && envioEncontrado == false){
                if(huecos[fila2][columna2]==false){
                    envio = listaEnvios.buscarEnvio(id, fila, columna);
                    envioEncontrado = true;
                }
                columna2++;
            }
            fila2++;
        }
        return envio;
    }


    /**
     * TODO: Método que Si está desocupado el hueco que indica el envio, lo pone ocupado y devuelve true,
     *  si no devuelve false
     * @param envio
     * @return
     */
    public boolean ocuparHueco(Envio envio) {
        if(huecos[envio.getFila() - 1][envio.getColumna() - 1]==true){
            System.out.println("Lo sentimos este hueco está ocupado");
            return false;
        }else {
            huecos[envio.getFila()-1][envio.getColumna()-1] =  true;
            return true;
        }
    }


    /**
     * TODO: A través del localizador del envio, se desocupará el hueco
     * @param localizador
     * @return
     */
    public boolean desocuparHueco(String localizador) {
        listaEnvios.eliminarEnvio(localizador);
        return false;
    }

    /**
     * TODO: Devuelve una cadena con información completa del porte
     * @return ejemplo del formato -> "Porte PM0066 de Gaia Galactic Terminal(GGT) M5 (01/01/2023 08:15:00) a
     *  Cidonia(CID) M1 (01/01/2024 11:00:05) en Planet Express One(EP-245732X) por 13424,56 SSD, huecos libres: 10"
     */
    public String toString() {
        return "Porte "+getID()+" de "+muelleOrigen+"("+origen.getCodigo()+") M"+origen.getMuelles()+
                " ("+getSalida()+") a "+destino.getNombre()+"("+destino.getCodigo()+") M"+destino.getMuelles()
                + " ("+getLlegada()+") en "+nave.toStringSimple()+" por "+getPrecio()+" SSD, huecos libres: "+numHuecosLibres();
    }


    /**
     * TODO: Devuelve una cadena con información abreviada del vuelo
     * @return ejemplo del formato -> "Porte PM0066 de GGT M5 (01/01/2023 08:15:00) a CID M1 (01/01/2024 11:00:05)"
     */
    public String toStringSimple() {
        return "Porte " + getID() + " de " + origen.getNombre() + " M"+origen.getMuelles()+" (" + getSalida() + ") a " + destino.getNombre()
                +" M"+destino.getMuelles()+ " (" + getLlegada() + ") " ;
    }


    /**
     * TODO: Devuelve true si el código origen, destino y fecha son los mismos que el porte
     * @param codigoOrigen
     * @param codigoDestino
     * @param fecha
     * @return
     */
    public boolean coincide(String codigoOrigen, String codigoDestino, Fecha fecha) {
        boolean coincide;
        coincide = Objects.equals(codigoOrigen, origen.getCodigo())&&Objects.equals(codigoDestino,destino.getCodigo())&&(fecha.coincide(salida)|| fecha.coincide(llegada));
        return coincide;
    }


    /**
     * TODO: Muestra la matriz de huecos del porte, ejemplo:
     *        A  B  C
     *      1[ ][ ][ ]
     *      2[X][X][X]
     *      3[ ][ ][ ]
     *      4[ ][X][ ]
     *     10[ ][ ][ ]
     */
    public void imprimirMatrizHuecos() {
        String huecoA="[", huecoB="]", medio, abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
        System.out.print("  ");
        for(int columna = 1; columna<= nave.getColumnas();columna++){
            System.out.printf(" %c",abecedario.charAt(columna-1));
        }
        System.out.print("\n");

        for(int fila=1; fila<=nave.getFilas();fila++){
            if(fila<10){
                System.out.printf(" "+fila);
            }else{
                System.out.print(fila);
            }

        }
    }

    /**
     * TODO: Devuelve true si ha podido escribir en un fichero la lista de envíos del porte, siguiendo las indicaciones
     *  del enunciado
     * @param fichero
     * @return
     */
    public boolean generarListaEnvios(String fichero) {
        PrintWriter pw = null;
        try {

            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }


    /**
     * TODO: Genera un ID de porte. Este consistirá en una cadena de 6 caracteres, de los cuales los dos primeros
     *  serán PM y los 4 siguientes serán números aleatorios.
     *  NOTA: Usar el objeto rand pasado como argumento para la parte aleatoria.
     * @param rand
     * @return ejemplo -> "PM0123"
     */
    public static String generarID(Random rand) {
        return "PM";
    }

    /**
     * TODO: Crea y devuelve un objeto Porte de los datos que selecciona el usuario de puertos espaciales
     *  y naves y la restricción de que no puede estar repetido el identificador, siguiendo las indicaciones
     *  del enunciado.
     *  La función solicita repetidamente los parametros hasta que sean correctos
     * @param teclado
     * @param rand
     * @param puertosEspaciales
     * @param naves
     * @param portes
     * @return
     */
    public static Porte altaPorte(Scanner teclado, Random rand, ListaPuertosEspaciales puertosEspaciales, ListaNaves naves, ListaPortes portes) {

        return null;
    }
}