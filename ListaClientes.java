import java.io.FileNotFoundException;
import java.io.FileReader;
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
        this.clientes = new Cliente[capacidad];
    }
    // TODO: Devuelve el número de clientes que hay en la lista de clientes
    public int getOcupacion() {
        int ocupado=0;
        for(int i=0;i< clientes.length;i++){
            if(clientes[i]!=null){
                ocupado++;
            }
        }
        return ocupado;
    }
    // TODO: ¿Está llena la lista de clientes?
    public boolean estaLlena() {
        return getOcupacion()>=clientes.length;
    }
	// TODO: Devuelve el cliente dada el indice
    public Cliente getCliente(int i) {
        return clientes[i];
    }
    // TODO: Inserta el cliente en la lista de clientes
    public boolean insertarCliente(Cliente cliente) {
        if(estaLlena()==false){
            clientes[getOcupacion()] = cliente;
            return true;
        }else{
            System.out.println("Sintiendolo mucho el envio está completo.");
            return false;
        }
    }
    // TODO: Devuelve el cliente que coincida con el email, o null en caso de no encontrarlo
    public Cliente buscarClienteEmail(String email) {
        Cliente[] aux = clientes;
        for(int i=0;i<clientes.length;i++){
            if(clientes[i].getEmail()==email){
                aux[0] = clientes[i];
            }else{
                aux[0]=null;
            }
        }
        return aux[0];
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
        boolean aux=true;
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fichero);
            for (int i=0; i<getOcupacion()-1;i++){
                pw.print(clientes[i].getNombre()+";"+clientes[i].getApellidos()+";"+clientes[i].getEmail());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            aux = false;
        } finally {
            try{
                if(pw != null){
                    pw.close();
                }else{
                    aux = false;
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                aux = false;
            }
        }
        return aux;
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
        ListaClientes listaClientes = new ListaClientes(capacidad);
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(fichero));
            while(sc.hasNext()){
                String[] linea = sc.nextLine().split(";");
                String nombre = linea[0];
                String apellidos = linea[1];
                String email = linea[2];
                listaClientes.insertarCliente(new Cliente(nombre,apellidos,email,maxEnviosPorCliente));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (sc != null){
                try{
                    sc.close();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return listaClientes;
    }
}