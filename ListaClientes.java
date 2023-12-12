import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @author
 * @author
 * @version     1.0
 */
public class ListaClientes {
    private Cliente[] clientes;

    /**
     * TODO: Constructor de la clase para inicializar la lista a una capacidad determinada
     *
     * @param capacidad
     */
    public ListaClientes(int capacidad) {
        //Hecho
        this.clientes = new Cliente[capacidad];
        //Hasta aquí
    }
    // TODO: Devuelve el número de clientes que hay en la lista de clientes
    public int getOcupacion() {
        //Hecho
        return clientes.length;
        //Hasta aquí
    }
    // TODO: ¿Está llena la lista de clientes?
    public boolean estaLlena() {
        //Hecho
        boolean llena = false;
        for(int i=0; i<clientes.length; i++){
            if(clientes[i] != null){
                llena = true;
            }else{
                llena = false;
            }
        }
        return llena;
        //hasta aquí
    }
	// TODO: Devuelve el cliente dada el indice
    public Cliente getCliente(int i) {
        //Hecho
        Scanner teclado = new Scanner(System.in);
        i = teclado.nextInt();
        return clientes[i];
        //Hasta aquí
    }
    // TODO: Inserta el cliente en la lista de clientes
    public boolean insertarCliente(Cliente cliente) {
        //Hecho
        clientes[clientes.length-1] = cliente;
        for(int i = clientes.length-2;i >= 0;i--){
            clientes[i+1] = clientes[i];
        }
        clientes[0] = cliente;
        for(int i=0; i< clientes.length;i++){
            System.out.println(clientes[i]);
        }
        return false;
        //Hasta aquí
    }
    // TODO: Devuelve el cliente que coincida con el email, o null en caso de no encontrarlo
    public Cliente buscarClienteEmail(String email) {

    }

    /**
     * TODO: Método para seleccionar un Cliente existente a partir de su email, usando el mensaje pasado como argumento
     *  para la solicitud y, siguiendo el orden y los textos mostrados en el enunciado.
     *  La función debe solicitar repetidamente hasta que se introduzca un email correcto
     * @param teclado
     * @param mensaje
     * @return
     */
    public Cliente seleccionarCliente(Scanner teclado, String mensaje) {
        Cliente cliente = null;

        return cliente;
    }

    /**
     * TODO: Método para guardar la lista de clientes en un fichero .csv, sobreescribiendo la información del mismo
     *  fichero
     * @param fichero
     * @return
     */
    public boolean escribirClientesCsv(String fichero) {


        try {



        } catch (FileNotFoundException e) {
            return false;
        } finally {

        }
        return true;
    }

    /**
     * TODO: Genera una lista de Clientes a partir del fichero CSV, usando los límites especificados como argumentos
     *  para la capacidad de la lista y el número de billetes máximo por pasajero
     * @param fichero
     * @param capacidad
     * @param maxEnviosPorCliente
     * @return lista de clientes
     */
    public static ListaClientes leerClientesCsv(String fichero, int capacidad, int maxEnviosPorCliente) {

        try {

        } catch (FileNotFoundException e) {
            return null;
        } finally {

        }
        return listaClientes;
    }
}