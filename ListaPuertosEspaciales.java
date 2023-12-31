import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @author Daniel García Martínez bu0275
 * @author Pedro Medrano Sánchezbu0433
 * @version     1.0
 */
public class ListaPuertosEspaciales {
    private PuertoEspacial[] lista;

    /**
     * TODO: Constructor de la clase para inicializar la lista a una capacidad determinada
     *
     * @param capacidad
     */
    public ListaPuertosEspaciales(int capacidad) {
        //Hecho
        this.lista = new PuertoEspacial[capacidad];
		//Hasta aquí
    }
    // TODO: Devuelve el número de puertos espaciales que hay en la lista
    public int getOcupacion() {
        return lista.length;
    }
    // TODO: ¿Está llena la lista?
    public boolean estaLlena() {
        //Hecho
        PuertoEspacial aux = new PuertoEspacial("a","a",0,0,0,0);
        for(int i=0;i<lista.length-1;i++){//ORDENAR
            for(int j=0;j<lista.length-1;j++){
                if(lista[j]==null&&lista[j+1]!=null){
                    aux = lista[j+1];
                    lista[j+1] = lista[j];
                    lista[j] = aux;
                    j=0;
                }
            }
        }

        boolean llena = false;
        for(int i=0; i<lista.length; i++){
            if(lista[i] != null){
                llena = true;
            }else{
                llena = false;
            }
        }
        return llena;
        //Hasta aquí
    }
	// TODO: Devuelve un puerto espacial dado un indice
    public PuertoEspacial getPuertoEspacial(int i) {
        //Hecho
        return lista[i];
        //hasta aquí
    }

    /**
     * TODO: insertamos un Puerto espacial nuevo en la lista
     * @param puertoEspacial
     * @return true en caso de que se añada correctamente, false en caso de lista llena o error
     */
    public boolean insertarPuertoEspacial(PuertoEspacial puertoEspacial) {
        //Hecho
        lista[lista.length-1] = puertoEspacial;
        for(int i = lista.length-2;i >= 0;i--){
            lista[i+1] = lista[i];
        }
        lista[0] = puertoEspacial;
        for(int i=0; i< lista.length;i++){
            System.out.println(lista[i]);
        }
        return false;
        //Hasta aquí
    }

    /**
     * TODO: Buscamos un Puerto espacial a partir del codigo pasado como parámetro
     * @param codigo
     * @return Puerto espacial que encontramos o null si no existe
     */
    public PuertoEspacial buscarPuertoEspacial(String codigo) {
        //Hecho
        PuertoEspacial[] aux = lista;
        for(int i=0;i<lista.length;i++){
            if(lista[i].getCodigo()==codigo){
                aux[0] = lista[i];
            }else{
                aux[0]=null;
            }
        }
        return aux[0];
        //Hasta aquí
    }

    /**
     * TODO: Permite seleccionar un puerto espacial existente a partir de su código, usando el mensaje pasado como
     *  argumento para la solicitud y siguiendo el orden y los textos mostrados en el enunciado.
     *  La función solicita repetidamente el código hasta que se introduzca uno correcto
     * @param teclado
     * @param mensaje
     * @return
     */
    public PuertoEspacial seleccionarPuertoEspacial(Scanner teclado, String mensaje) {
        PuertoEspacial puertoEspacial = null;


        return puertoEspacial;
    }

    /**
     * TODO: Genera un fichero CSV con la lista de puertos espaciales, SOBREESCRIBIENDOLO
     * @param nombre
     * @return
     */
    public boolean escribirPuertosEspacialesCsv(String nombre) {
        PrintWriter pw = null;
        try {

            return true;
        } catch (Exception e) {
            return false;
        } finally {

        }
    }


    /**
     * TODO: Genera una lista de PuertosEspaciales a partir del fichero CSV, usando el argumento como capacidad máxima
     *  de la lista
     * @param fichero
     * @param capacidad
     * @return
     */
    public static ListaPuertosEspaciales leerPuertosEspacialesCsv(String fichero, int capacidad) {
        ListaPuertosEspaciales listaPuertosEspaciales = new ListaPuertosEspaciales(capacidad);
        Scanner sc = null;
        try {

        } catch (Exception e) {
            return null;
        } finally {

        }
        return listaPuertosEspaciales;
    }
}
