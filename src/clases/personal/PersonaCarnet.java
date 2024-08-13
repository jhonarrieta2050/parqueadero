package clases.personal;

public class PersonaCarnet extends Persona {
    private int id;
    private boolean especial;

    public PersonaCarnet(String nombre, String apellido, int id, boolean especial){
        super(nombre,apellido);
        this.id = id;
        this.especial = especial;
    }

    public PersonaCarnet(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }
}
