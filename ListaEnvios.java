import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @author
 * @author
 * @version     1.0
 */
public class ListaEnvios {
    private Envio[] envios;
    /**
     * TODO: Constructor de la clase para inicializar la lista a una capacidad determinada
     *
     * @param capacidad
     */
    public ListaEnvios(int capacidad) {
		//Hecho
		this.envios = new Envio[capacidad];
        //Hasta aquí
    }
    // TODO: Devuelve el número de envíos que hay en la lista
    public int getOcupacion() {
        //Hecho
        return envios.length;
        //Hasta aquí
    }
    // TODO: ¿Está llena la lista de envíos?
    public boolean estaLlena() {
        //Hecho
        Envio aux = new Envio("a",Porte porte = new Porte());
        for(int i=0;i<envios.length-1;i++){//ORDENAR
            for(int j=0;j<envios.length-1;j++){
                if(envios[j]==null&&envios[j+1]!=null){
                    aux = envios[j+1];
                    envios[j+1] = envios[j];
                    envios[j] = aux;
                    j=0;
                }
            }
        }

        boolean llena = false;
        for(int i=0; i<envios.length; i++){
            if(envios[i] != null){
                llena = true;
            }else{
                llena = false;
            }
        }
        return llena;
        //Hasta aquí
    }
	//TODO: Devuelve el envio dado un indice
    public Envio getEnvio(int i) {
        return envios[i];
    }

    /**
     * TODO: insertamos un nuevo envío en la lista
     * @param envio
     * @return true en caso de que se añada correctamente, false en caso de lista llena o error
     */
    public boolean insertarEnvio(Envio envio) {
        //Hecho
        envios[envios.length-1] = envio;
        for(int i = envios.length-2;i >= 0;i--){
            envios[i+1] = envios[i];
        }
        envios[0] = envio;
        for(int i=0; i< envios.length;i++){
            System.out.println(envios[i]);
        }
        return false;
        //Hasta aquí
    }

    /**
     * TODO: Buscamos el envio a partir del localizador pasado como parámetro
     * @param localizador
     * @return el envio que encontramos o null si no existe
     */
    public Envio buscarEnvio(String localizador) {
        //Hecho
        Envio[] aux = envios;
        for(int i=0;i<envios.length;i++){
            if(envios[i].getLocalizador()==localizador){
                aux[0] = envios[i];
            }else{
                aux[0]=null;
            }
        }
        return aux[0];
        //Hasta aquí
    }

    /**
     * TODO: Buscamos el envio a partir del idPorte, fila y columna pasados como parámetros
     * @param idPorte
     * @param fila
     * @param columna
     * @return el envio que encontramos o null si no existe
     */
    public Envio buscarEnvio(String idPorte, int fila, int columna) {


        return null;
    }

    /**
     * TODO: Eliminamos un envio a través del localizador pasado por parámetro
     * @param localizador
     * @return True si se ha borrado correctamente, false en cualquier otro caso
     */
    public boolean eliminarEnvio (String localizador) {

        return false;
    }

    /**
     * TODO: Muestra por pantalla los Envios de la lista, con el formato que aparece
     * en el enunciado
     */
    public void listarEnvios() {

    }

    /**
     * TODO: Permite seleccionar un Envio existente a partir de su localizador, usando el mensaje pasado como argumento
     *  para la solicitud y siguiendo el orden y los textos mostrados en el enunciado.
     *  La función solicita repetidamente hasta que se introduzca un localizador correcto
     * @param teclado
     * @param mensaje
     * @return
     */
    public Envio seleccionarEnvio(Scanner teclado, String mensaje) {
        Envio envio = null;


        return envio;
    }



    /**
     * TODO: Añade los Envios al final de un fichero CSV, SIN SOBREESCRIBIR la información
     * @param fichero
     * @return
     */
    public boolean aniadirEnviosCsv(String fichero) {
        boolean correcto = true;
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fichero);
            for(int i = 0; i < )

            return true;
        } catch (Exception e) {
            return false;
        } finally {

        }
    }

    /**
     * TODO: Lee los Envios del fichero CSV y los añade a las listas de sus respectivos Portes y Clientes
     * @param ficheroEnvios
     * @param portes
     * @param clientes
     */
    public static void leerEnviosCsv(String ficheroEnvios, ListaPortes portes, ListaClientes clientes) {
        Scanner sc = null;
        try {

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero de envíos");
        } finally {

        }
    }
}
