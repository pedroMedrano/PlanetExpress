import jdk.nashorn.internal.runtime.ECMAException;

import java.io.*;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @author Daniel García Martínez bu0275
 * @author Pedro Medano Sánchez bu0433
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
        Envio envio = null;
        for(int i =0;i<=envios.length;i++){
            if(envios[i].getFila() == fila && envios[i].getColumna()==columna && envios[i].getLocalizador().startsWith(idPorte)){
                envio = envios[i];
                i = envios.length;
            }
        }
        return envio;
    }

    /**
     * TODO: Eliminamos un envio a través del localizador pasado por parámetro
     * @param localizador
     * @return True si se ha borrado correctamente, false en cualquier otro caso
     */
    public boolean eliminarEnvio (String localizador) {
        boolean eliminar = false;
        for(int i =0; i<=envios.length;i++){
            if(envios[i].getLocalizador()==localizador){
                envios[i]=null;
                eliminar = true;
            }
        }

        return eliminar;
    }

    /**
     * TODO: Muestra por pantalla los Envios de la lista, con el formato que aparece
     * en el enunciado
     */
    public void listarEnvios() {
        for(int i =1;i<= envios.length;i++){
            System.out.println(i+". "+envios[i-1].toString());
        }
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
        String localizador;
        do{
            System.out.println(mensaje);
            localizador = teclado.next();
            if(this.buscarEnvio(localizador) ==null){
                System.out.println("Envío no encontrado.");
            }
        }while (this.buscarEnvio(localizador)==null);
        return this.buscarEnvio(localizador);
    }



    /**
     * TODO: Añade los Envios al final de un fichero CSV, SIN SOBREESCRIBIR la información
     * @param fichero
     * @return
     */
    public boolean aniadirEnviosCsv(String fichero) {
        PrintWriter pw = null;
        boolean correcto = true;
        Scanner sc = null;
        try {
            pw = new PrintWriter(fichero);
            sc = new Scanner(new FileReader(fichero));
            while (sc.hasNextLine()){
                sc.hasNextLine();
            }
            for (int i =0; i<getOcupacion()-1;i++){
                pw.printf("%s;%s;%s;%s;%d;2f\n",envios[i].getLocalizador(),envios[i].getCliente().toString(),envios[i].getFila(),envios[i].getColumna(),envios[i].getPrecio());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            correcto=false;
        } finally {
            if(pw !=null){
                pw.close();;
            }
            else if(sc !=null){
                sc.close();
            }
        }
        return correcto;
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
            sc= new Scanner(new FileReader(ficheroEnvios));
            while(sc.hasNext()){
                String[] linea =sc.nextLine().split(";");
                String localizador = linea[0];
                Porte porte = portes.buscarPorte(linea[1]);
                Cliente cliente = clientes.buscarClienteEmail(linea[2]);
                int filas = Integer.parseInt(linea[3]);
                int columnas = Integer.parseInt(linea[4]);
                double precio = Double.parseDouble(linea[5]);

                Envio envio = new Envio(localizador,porte,cliente,filas,columnas,precio);
                cliente.aniadirEnvio(envio);
                porte.ocuparHueco(envio);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if(sc !=null){
                try{
                    sc.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());

                }
            }

        }
    }
}
