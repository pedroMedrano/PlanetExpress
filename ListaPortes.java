import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @author Daniel García Martínez bu0275
 * @author Pedro Medrano Sánchez bu0433
 * @version     1.0
 */
public class ListaPortes {
    private Porte[] portes;
    /**
     * TODO: Constructor de la clase para inicializar la lista a una capacidad determinada
     *
     * @param capacidad
     */
    public ListaPortes(int capacidad) {
        //Hecho
        this.portes = new Porte[capacidad];
        //Hasta aquí
    }
    // TODO: Devuelve el número de portes que hay en la lista
    public int getOcupacion() {
        //Hecho
        return portes.length;
        //Hasta aquí
    }
    // TODO: ¿Está llena la lista?
    public boolean estaLlena() {
        //Hecho
        Porte aux = new Porte();
        for(int i=0;i<portes.length-1;i++){//ORDENAR
            for(int j=0;j<portes.length-1;j++){
                if(portes[j]==null&&portes[j+1]!=null){
                    aux = portes[j+1];
                    portes[j+1] = portes[j];
                    portes[j] = aux;
                    j=0;
                }
            }
        }

        boolean llena = false;
        for(int i=0; i<portes.length; i++){
            if(portes[i] != null){
                llena = true;
            }else{
                llena = false;
            }
        }
        return llena;
        //Hasta aquí
    }

	//TODO: devuelve un porte dado un indice
    public Porte getPorte(int i) {
        return portes[i];
    }


    /**
     * TODO: Devuelve true si puede insertar el porte
     * @param porte
     * @return false en caso de estar llena la lista o de error
     */
    public boolean insertarPorte(Porte porte) {
        //Hecho
        portes[portes.length-1] = porte;
        for(int i = portes.length-2;i >= 0;i--){
            portes[i+1] = portes[i];
        }
        portes[0] = porte;
        for(int i=0; i< portes.length;i++){
            System.out.println(portes[i]);
        }
        return false;
        //Hasta aquí
    }


    /**
     * TODO: Devuelve el objeto Porte que tenga el identificador igual al parámetro id
     * @param id
     * @return el objeto Porte que encontramos o null si no existe
     */
    public Porte buscarPorte(String id) {
        //Hecho
        Porte[] aux = portes;
        for(int i=0;i<portes.length;i++){
            if(portes[i].getID()==id){
                aux[0] = portes[i];
            }else{
                aux[0]=null;
            }
        }
        return aux[0];
        //Hasta aquí
    }

    /**
     * TODO: Devuelve un nuevo objeto ListaPortes conteniendo los Portes que vayan de un puerto espacial a otro
     *  en una determinada fecha
     * @param codigoOrigen
     * @param codigoDestino
     * @param fecha
     * @return
     */
    public ListaPortes buscarPortes(String codigoOrigen, String codigoDestino, Fecha fecha) {
        //Hecho
        Porte[] aux = portes;
        for(int i=0;i<portes.length;i++){
            if(portes[i].getOrigen()==codigoOrigen&&portes[i].getDestino()==codigoDestino&&portes[i].getSalida()==fecha){
                aux[0] = portes[i];
            }else{
                aux[0]=null;
            }
        }
        return aux[0];
        //Hasta aquí

        return listaPortes;
    }

    /**
     * TODO: Muestra por pantalla los Portes siguiendo el formato de los ejemplos del enunciado
     */
    public void listarPortes() {

    }


    /**
     * TODO: Permite seleccionar un Porte existente a partir de su ID, usando el mensaje pasado como argumento para
     *  la solicitud y siguiendo el orden y los textos mostrados en el enunciado, y usando la cadena cancelar para
     *  salir devolviendo null.
     *  La función solicita repetidamente hasta que se introduzca un ID correcto
     * @param teclado
     * @param mensaje
     * @param cancelar
     * @return
     */
    public Porte seleccionarPorte(Scanner teclado, String mensaje, String cancelar) {
        listarPortes();
        Porte porte = null;

        return porte;
    }

    /**
     * TODO: Ha de escribir la lista de Portes en la ruta y nombre del fichero pasado como parámetro.
     *  Si existe el fichero, SE SOBREESCRIBE, si no existe se crea.
     * @param fichero
     * @return
     */
    public boolean escribirPortesCsv(String fichero) {
        try {

            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    /**
     * TODO: Genera una lista de Portes a partir del fichero CSV, usando los límites especificados como argumentos para
     *  la capacidad de la lista
     * @param fichero
     * @param capacidad
     * @param puertosEspaciales
     * @param naves
     * @return
     */
    public static ListaPortes leerPortesCsv(String fichero, int capacidad, ListaPuertosEspaciales puertosEspaciales, ListaNaves naves) {
        ListaPortes listaPortes = new ListaPortes(capacidad);
        try {

        } catch (Exception e) {
            return null;
        }
        return listaPortes;
    }
}
