import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @author
 * @author
 * @version     1.0
 */
public class ListaNaves {
    private Nave[] naves;

    /**
     * TODO: Constructor de la clase para inicializar la lista a una capacidad determinada
     *
     * @param capacidad
     */
    public ListaNaves(int capacidad) {
        //Hecho
        this.naves = new Nave[capacidad];
        //Hasta aquí
    }
    // TODO: Devuelve el número de naves que hay en la lista
    public int getOcupacion() {
        //Hecho
        return naves.length;
        //Hasta aquí
    }
    // TODO: ¿Está llena la lista de naves?
    public boolean estaLlena() {
        //Hecho
        Nave aux = new Nave("a","a","a",0,0,0);
        for(int i=0;i<naves.length-1;i++){//ORDENAR
            for(int j=0;j<naves.length-1;j++){
                if(naves[j]==null&&naves[j+1]!=null){
                    aux = naves[j+1];
                    naves[j+1] = naves[j];
                    naves[j] = aux;
                    j=0;
                }
            }
        }

        boolean llena = false;
        for(int i=0; i<naves.length; i++){
            if(naves[i] != null){
                llena = true;
            }else{
                llena = false;
            }
        }
        return llena;
        //Hasta aquí
    }
	// TODO: Devuelve nave dado un indice
    public Nave getNave(int posicion) {
        //Hecho
        return naves[posicion];
        //Hasta aquí
    }

    /**
     * TODO: insertamos una nueva nave en la lista
     * @param nave
     * @return true en caso de que se añada correctamente, false en caso de lista llena o error
     */
    public boolean insertarNave(Nave nave) {
        //Hecho
        naves[naves.length-1] = nave;
        for(int i = naves.length-2;i >= 0;i--){
            naves[i+1] = naves[i];
        }
        naves[0] = nave;
        for(int i=0; i< naves.length;i++){
            System.out.println(naves[i]);
        }
        return false;
        //Hasta aquí
    }
    /**
     * TODO: Buscamos la nave a partir de la matricula pasada como parámetro
     * @param matricula
     * @return la nave que encontramos o null si no existe
     */
    public Nave buscarNave(String matricula) {
        //Hecho
        Nave[] aux = naves;
        for(int i=0;i<naves.length;i++){
            if(naves[i].getMatricula()==matricula){
                aux[0] = naves[i];
            }else{
                aux[0]=null;
            }
        }
        return aux[0];
        //Hasta aquí
    }
    // TODO: Muestra por pantalla las naves de la lista con el formato indicado en el enunciado
    public void mostrarNaves() {

    }



    /**
     * TODO: Permite seleccionar una nave existente a partir de su matrícula, y comprueba si dispone de un alcance
     *  mayor o igual que el pasado como argumento, usando el mensaje pasado como argumento para la solicitud y
     *  siguiendo el orden y los textos mostrados en el enunciado.
     *  La función solicita repetidamente la matrícula de la nave hasta que se introduzca una con alcance suficiente
     * @param teclado
     * @param mensaje
     * @param alcance
     * @return
     */
    public Nave seleccionarNave(Scanner teclado, String mensaje, double alcance) {
        Nave nave = null;


        return nave;
    }


    /**
     * TODO: Genera un fichero CSV con la lista de Naves, SOBREESCRIBIÉNDOLO
     * @param nombre
     * @return
     */
    public boolean escribirNavesCsv(String nombre) {
        PrintWriter pw = null;
        try {

            return true;
        } catch (Exception e) {
            return false;
        } finally {

        }
    }


    /**
     * TODO: Genera una lista de naves a partir del fichero CSV, usando el argumento como capacidad máxima de la lista
     * @param fichero
     * @param capacidad
     * @return
     */
    public static ListaNaves leerNavesCsv(String fichero, int capacidad) {
        ListaNaves listaNaves = new ListaNaves(capacidad);
        Scanner sc = null;
        try {

        } catch (Exception e) {
            return null;
        } finally {

        }
        return listaNaves;
    }
}
