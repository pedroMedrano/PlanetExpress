import java.util.Objects;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @author Taller de Programación
 * @version     1.0
 */
public class Cliente {
    private final ListaEnvios listaEnvios;
    private final String nombre;
    private final String apellidos;
    private final String email;

    /**
     * Constructor of the class
     *
     * @param nombre Nombre del cliente
     * @param apellidos Apellidos del cliente
     * @param email Email del cliente
     * @param maxEnvios Número máximo de envíos que puede tener el cliente
     */
    public Cliente(String nombre, String apellidos, String email, int maxEnvios) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.listaEnvios = new ListaEnvios(maxEnvios);
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getEmail() {
        return email;
    }
    // TODO: Texto que debe generar: Zapp Brannigan, zapp.brannigan@dop.gov
    public String toString() {
        //Hecho
        return nombre+" "+apellidos+", "+email;
        //Hasta aquí
    }
    // TODO: Devuelve un booleano que indica si se ha alcanzado el número máximo de envíos
    public boolean maxEnviosAlcanzado() {

    }
    // TODO: Devuelve un envío en función de su posición
    public Envio getEnvio(int i) {
        return listaEnvios.getEnvio(i);
    }
    public ListaEnvios getListaEnvios() {
        return listaEnvios;
    }
    // TODO: Añade un envío al cliente
    public boolean aniadirEnvio(Envio envio) {
        return listaEnvios.insertarEnvio(envio);
    }
    public Envio buscarEnvio(String localizador) {
        return listaEnvios.buscarEnvio(localizador);
    }
    // TODO: Elimina el envío de la lista de envíos del pasajero
    public boolean cancelarEnvio(String localizador) {
        return listaEnvios.eliminarEnvio(localizador);
    }
    public void listarEnvios() {
        listaEnvios.listarEnvios();
    }
    // Encapsula la funcionalidad seleccionarEnvio de ListaEnvios
    public Envio seleccionarEnvio(Scanner teclado, String mensaje) {
        return listaEnvios.seleccionarEnvio(teclado, mensaje);
    }


    /**
     * TODO: Método estático para crear un nuevo cliente "no repetido", se pide por teclado los datos necesarios
     * al usuario en el orden y con los textos indicados en los ejemplos de ejecución del enunciado
     * La función tiene que solicitar repetidamente los parámetros hasta que sean correctos
     * @param teclado
     * @param clientes
     * @param maxEnvios
     * @return Cliente
     */
    public static Cliente altaCliente(Scanner teclado, ListaClientes clientes, int maxEnvios) {
        String nombre;
        String apellidos;
        String email;
        teclado.nextLine();
        System.out.print("Inserte su nombre: ");
        nombre = teclado.nextLine();
        System.out.print("Inserte sus apellidos: ");
        apellidos = teclado.nextLine();
        do{
            System.out.print("Introduzca el email: ");
            email = teclado.nextLine();
            if(correctoEmail(email)==true){
                System.out.println("Email incorrecto.");
            }else if(clientes.buscarClienteEmail(email) != null){
                System.out.println("El email ya existe");
            }
        }while(correctoEmail(email) || clientes.buscarClienteEmail(email) !=null);

        Cliente cliente = new Cliente(nombre,apellidos,email,maxEnvios);
        clientes.insertarCliente(cliente);

        return new Cliente(nombre, apellidos, email, maxEnvios);
    }


    /**
     * TODO: Metodo para comprobar que el formato de email introducido sea correcto
     * @param email
     * @return
     */
    public static boolean correctoEmail(String email) {
        if(email.contains("@")==false){
            return true;
        }else {
            String[] usuario = email.split("@");
            if(Objects.equals(usuario[1],"dop.gov")==false){
                return false;
            }else if(usuario[0].startsWith(".")||usuario[0].endsWith(".")){
                return false;
            }else{
                return
            }
        }
        return false;
    }
}
