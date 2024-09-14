package clases.personal;

public abstract class Persona {
    protected String nombre;
    protected String apellido;

    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Persona(){}

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
