/**
 * Description of the class
 *
 * @author     Daniel García Martínez bu0275
 * @author     Pedro Medrano Sánchez bu0433
 * @version     1.0
 */
public class PuertoEspacial {

    private String nombre;
    private String codigo;
    private double radio;
    private double azimut;
    private double polar;
    private int numMuelles;

    /**
     * Constructor of the class
     *
     * @param nombre
     * @param codigo
     * @param radio
     * @param azimut
     * @param polar
     * @param numMuelles
     */
    public PuertoEspacial(String nombre, String codigo, double radio, double azimut, double polar, int numMuelles) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.radio = radio;
        this.azimut = azimut;
        this.polar = polar;
        this.numMuelles = numMuelles;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public double getRadio() {
        return radio;
    }
    public double getAzimut() {
        return azimut;
    }

    public double getPolar() {
        return polar;
    }
    public int getMuelles() {
        return numMuelles;
    }

    /**
     * TODO: Método para calcular la distancia entre el puerto espacial que recibe el mensaje y el puerto
     *  espacial "destino" siguiendo las ecuaciones del enunciado (Las formulas se encuentran en el enunciado)
     * @param destino
     * @return
     */
    public double distancia(PuertoEspacial destino) {
        // TODO: Para calcular la distancia entre dos Puertos Espaciales, se transforman sus coordenadas esféricas a cartesianas
        double x,y,z,distancia;
        x = destino.getRadio() * Math.sin(destino.getAzimut()) * Math.cos(polar);
        y = destino.getRadio() * Math.sin(destino.getAzimut()) * Math.sin(polar);
        z = destino.getRadio() * Math.cos(destino.getAzimut());
        // TODO: Una vez se tienen las coordenadas cartesianas, basta con calcular la distancia euclídea entre ellas:
        distancia = Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));

        return distancia;
    }

    /**
     * TODO: Método que crea un String con los datos de un puerto espacial con el siguiente formato:
     * @return ejemplo -> "Gaia Galactic Terminal(GGT), en (1.0 90.0 0.0), con 8 muelles" (Radio, Azimut, Polar)
     */
    public String toString() {
        return  getNombre() +" - " +getCodigo()+ ", en ("+getRadio()+getAzimut()+getPolar()+"), con "+getMuelles()+ " muelles";
    }

    /**
     * TODO: Método que crea un String con los datos de un aeropuerto con el siguiente formato:
     * @return ejemplo -> "Gaia Galactic Terminal (GGT)"
     */
    public String toStringSimple() {
        return  getNombre() + " - "+getCodigo();
    }
}
