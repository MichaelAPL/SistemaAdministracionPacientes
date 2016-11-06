package modelos;

/**
 * Esta clase es el valor abstracto de una persona
 *
 * @author: Milka Cabrilla
 * @version: 20/10/2016
 */
public class Persona {

    //campos de la clase
    private String nombres;
    private String apellidos;
    private int edad; // tendrá un intervalo de 0 a 200
    private String direccion;
    private String localidad;
    private String telefono; // tendrá entre 7 y 10 caracteres

    /**
     * Constructor de la clase Persona
     *
     * @param nombres contiene los nombres de la persona
     * @param apellidos contiene los apellidos de la persona
     * @param edad contiene la edad de la persona
     * @param direccion contiene la dirección de la persona
     * @param localidad contiene la localidad de la persona
     * @param telefono contiene el telefono de la persona
     */
    public Persona(String nombres, String apellidos, int edad, String direccion, String localidad, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
    }

    /**
     * Método que devuelve los nombres de la persona
     *
     * @return los nombres de la persona
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Método que cambia los nombres actuales por los que se manden como
     * parámetros
     *
     * @param nombres son los nombres que se asignarán
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Método que devuelve los apellidos de la persona
     *
     * @return los apellidos de la persona
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método que cambia los nombres actuales por los que se manden como
     * parámetros
     *
     * @param apellidos son los apellidos que se asignarán
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Método que devuelve la edad de la persona
     *
     * @return la edad de la persona
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Método que cambia los nombres actuales por los que se manden como
     * parámetros
     *
     * @param edad es la edad que se asignará
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Método que devuelve la dirección de la persona
     *
     * @return la direccion de la persona
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método que cambia los nombres actuales por los que se manden como
     * parámetros
     *
     * @param direccion es la dirección que se asignará
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método que devuelve la localidad de la persona
     *
     * @return la localidad de la persona
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Método que cambia los nombres actuales por los que se manden como
     * parámetros
     *
     * @param localidad es la localidad que se asignará
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * Método que devuelve el teléfono de la persona
     *
     * @return el teléfono de la persona
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método que cambia los nombres actuales por los que se manden como
     * parámetros
     *
     * @param telefono es el teléfono que se asignará
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
