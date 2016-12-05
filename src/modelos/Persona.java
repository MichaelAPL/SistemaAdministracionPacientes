package modelos;

public class Persona {
    
    private String apellidos;
    private String direccion;
    private String localidad;
    private String nombres;
    private String telefono;
    private int edad;

    public Persona(String nombres, String apellidos, String direccion, String localidad, String telefono, int edad) {
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.localidad = localidad;
        this.nombres = nombres;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
