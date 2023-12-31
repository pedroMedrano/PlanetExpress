import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @author Daniel García Martínez bu0275
 * @author Pedro Medrano Sánchez bu0433
 * @version     1.0
 */
public class Envio {

    private String localizador;
    private Porte porte;
    private Cliente cliente;
    private int fila;
    private int columna;
    private double precio;

    /**
     * Constructor of the class
     *
     * @param localizador
     * @param porte
     * @param cliente
     * @param fila
     * @param columna
     * @param precio
     */
    public Envio(String localizador, Porte porte, Cliente cliente, int fila, int columna, double precio) {
        this.localizador = localizador;
        this.porte = porte;
        this.cliente = cliente;
        this.fila = fila;
        this.columna = columna;
        this.precio = precio;
    }
    public String getLocalizador() {
        return localizador;
    }
    public Porte getPorte() {
        return porte;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    // TODO: Ejemplos: "1A" para el hueco con fila 1 y columna 1, "3D" para el hueco con fila 3 y columna 4
    public String getHueco() {
        return "";
    }
    public double getPrecio() {
        return precio;
    }
    //TODO: Texto que debe generar: Envío PM1111AAAABBBBC para Porte PM0066 de GGT M5 (01/01/2023 08:15:00) a CID M1 (01/01/2024 11:00:05) en hueco 6C por 13424,56 SSD
    public String toString() {
        return "Envío "+getLocalizador()+ " para porte "+ porte.toString()+ " de "

    }
    // TODO: Cancela este envío, eliminándolo de la lista de envíos del porte y del cliente correspondiente
    public boolean cancelar() {

    }

    /**
     * TODO: Método para imprimir la información de este envío en un fichero que respecta el formato descrito en el
     *  enunciado
     * @param fichero
     * @return Devuelve la información con el siguiente formato como ejemplo ->
     *     -----------------------------------------------------
     *     --------- Factura del envío PM1111AAAABBBBC ---------
     *     -----------------------------------------------------
     *     Porte: PM0066
     *     Origen: Gaia Galactic Terminal (GGT) M5
     *     Destino: Cidonia (CID) M1
     *     Salida: 01/01/2023 08:15:00
     *     Llegada: 01/01/2024 11:00:05
     *     Cliente: Zapp Brannigan, zapp.brannigan@dop.gov
     *     Hueco: 6C
     *     Precio: 13424,56 SSD
     */
    public boolean generarFactura(String fichero) {
        PrintWriter salida =null;
        boolean escrito = true;
        try {
            salida = new PrintWriter(fichero);
            salida.printf("""
                    -----------------------------------------------------
                    ----------- Factura del envío PM1111AAAABBBBC -------
                    -----------------------------------------------------
                    
                    Porte: %s
                    Destino: %s (%s) T%s
                    Salida: %s
                    Llegada: %s
                    Cliente: %s %s, %s
                    Hueco: %s
                    Precio: %.2f€""",
                    this.localizador,porte.getID(),porte.getOrigen().getNombre(),porte.getOrigen().getCodigo(),porte.getMuelleOrigen(),
                    porte.getDestino(),porte.getDestino().getCodigo(),porte.getMuelleDestino(),porte.getSalida(),porte.getLlegada(),
                    cliente.getNombre(),cliente.getApellidos(),cliente.getEmail(),getHueco(),getPrecio());





            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            escrito =false;
            return false;
        }
    }



    /**
     *	TODO: Genera un localizador de envío. Este consistirá en una cadena de 15 caracteres, de los cuales los seis
	 *   primeros será el ID del porte asociado y los 9 siguientes serán letras mayúsculas aleatorias. Ejemplo: PM0123ABCD
     *   NOTA: Usar el objeto rand pasado como argumento para la parte aleatoria.
     * @param rand
     * @param idPorte
     * @return
     */
    public static String generarLocalizador(Random rand, String idPorte) {
        String localizador = idPorte,caracteres="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        char caracter;
        int num;
        for(int i=1;i<=4;i++){
            num = rand.nextInt(9);
            localizador+=num;
        }
        for (int j=1;j<=4;j++){
            caracter= caracteres.charAt(rand.nextInt(caracteres.length()));
            localizador+=caracter;
        }
        return localizador;
    }


    /**
     * TODO: Método para crear un nuevo envío para un porte y cliente específico, pidiendo por teclado los datos
     *  necesarios al usuario en el orden y con los textos indicados en los ejemplos de ejecución del enunciado
     *  La función solicita repetidamente los parámetros hasta que sean correctos
     * @param teclado
     * @param rand
     * @param porte
     * @param cliente
     * @return Envio para el porte y cliente especificados
     */
    public static Envio altaEnvio(Scanner teclado, Random rand, Porte porte, Cliente cliente) {
        String localizador;
        int fila, columna;
        double precio;
        Envio envio;

        localizador=generarLocalizador(rand,porte.getID());





        return  ;
    }
}