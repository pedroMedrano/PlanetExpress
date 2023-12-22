import java.util.Scanner;

/**
 * Description of the class
 *
 * @author
 * @author
 * @version     1.0
 */
public class Utilidades {

    /**
     * TODO: Solicita un número repetidamente hasta que se introduzca uno correcto (dentro de los límites)
     * @param teclado
     * @param mensaje
     * @param minimo
     * @param maximo
     * @return int numero
     */
    public static int leerNumero(Scanner teclado, String mensaje, int minimo, int maximo) {
        //Hecho
        int numero;
        do{
            System.out.println(mensaje);
            numero = teclado.nextInt();
        }while (numero>maximo||numero<minimo);
        return numero;
    }

    /**
     * TODO: Solicita un número repetidamente hasta que se introduzca uno correcto (dentro de los límites)
     * @param teclado
     * @param mensaje
     * @param minimo
     * @param maximo
     * @return long numero
     */
    public static long leerNumero(Scanner teclado, String mensaje, long minimo, long maximo) {
        //Hecho
        long numero;
        do{
            System.out.println(mensaje);
            numero = teclado.nextInt();
        }while (numero>maximo||numero<minimo);
        return numero;
        //Hasta aquí
    }

    /**
     * TODO: Solicita un número repetidamente hasta que se introduzca uno correcto (dentro de los límites)
     * @param teclado
     * @param mensaje
     * @param minimo
     * @param maximo
     * @return double numero
     */
    public static double leerNumero(Scanner teclado, String mensaje, double minimo, double maximo) {
        double numero;
        do{
            System.out.println(mensaje);
            numero = teclado.nextInt();
        }while(numero>maximo||numero<minimo);
        return numero;
    }

    /**
     * TODO: TODO: Solicita una letra repetidamente hasta que se introduzca uno correcto (dentro de los límites)
     * @param teclado
     * @param mensaje
     * @param minimo
     * @param maximo
     * @return char letra
     */
    public static char leerLetra(Scanner teclado, String mensaje, char minimo, char maximo) {
        char letra;
        do{
            System.out.println(mensaje);
            letra = teclado.next().charAt(0);
        }while(letra>maximo||letra<minimo);
        return letra;
    }


    /**
     * TODO: Solicita una fecha repetidamente hasta que se introduzca una correcta
     * @param teclado
     * @param mensaje
     * @return Fecha
     */
    public static Fecha leerFecha(Scanner teclado, String mensaje) {
        int dia;
        int mes;
        int anio;
        do{
            System.out.println(mensaje);
            dia = leerNumero(teclado,"Introducir día: ",1,31);
            teclado.nextLine();
            mes = leerNumero(teclado,"Introducir mes: ",1,12);
            teclado.nextLine();
            anio = leerNumero(teclado,"Introducir año: ",1900,2100);
            if(Fecha.comprobarFecha(dia,mes,anio)==false){
                System.out.println("La fecha es incorrecta.");
            }
        }while(Fecha.comprobarFecha(dia,mes,anio));

        return new Fecha(dia, mes, anio);
    }


    /**
     * TODO: Solicita una fecha y hora repetidamente hasta que se introduzcan unas correctas
     * @param teclado
     * @param mensaje
     * @return Fecha
     */
    public static Fecha leerFechaHora(Scanner teclado, String mensaje) {
        int dia;
        int mes;
        int anio;
        int hora;
        int minuto;
        int segundo;
        do{
            System.out.println(mensaje);
            dia = leerNumero(teclado,"Introducir día: ",1,31);
            teclado.nextLine();
            mes = leerNumero(teclado,"Introducir mes: ",1,12);
            teclado.nextLine();
            anio = leerNumero(teclado,"Introducir año: ",1900,2100);
            teclado.nextLine();
            hora = leerNumero(teclado,"Introducir hora: ",0,23);
            teclado.nextLine();
            minuto = leerNumero(teclado,"Introducir minuto: ",0,59);
            teclado.nextLine();
            segundo = leerNumero(teclado,"Introducir segundo: ",0,59);
            if(Fecha.comprobarFecha(dia,mes,anio)==false||Fecha.comprobarHora(hora,minuto,segundo)==false){
                System.out.println("La fecha o la hora son incorrectas.");
            }
        }while(Fecha.comprobarFecha(dia,mes,anio)==false||Fecha.comprobarHora(hora,minuto,segundo)==false);

        return new Fecha(dia, mes, anio, hora, minuto, segundo);
    }

    /**
     * TODO: Imprime por pantalla el String pasado por parámetro
     * @param teclado
     * @param s
     * @return
     */
    public static String leerCadena(Scanner teclado, String s) {
        System.out.print(s);
        return teclado.next();
    }
}
