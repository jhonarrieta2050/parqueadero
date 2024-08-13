package clases.estacionamiento;

public abstract class Cubiculo {
    protected static int numeroCubiculo;
    protected boolean especial;
    protected boolean ocupado = false;

    public Cubiculo(boolean especial){
        numeroCubiculo++;
        this.especial = especial;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    abstract void estacionarVehiculo();
}
