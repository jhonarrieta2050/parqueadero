package clases.estacionamiento;

public abstract class Cubiculo {
    protected int numeroCubiculo;
    protected boolean especial;
    protected boolean ocupado = false;
    protected static int conteo;

    public Cubiculo(boolean especial){
        this.numeroCubiculo = conteo++;
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

    public int getNumeroCubiculo() {
        return numeroCubiculo;
    }

    abstract void estacionarVehiculo();

    @Override
    public String toString() {
        return "Cubiculo{" +
                "numeroCubiculo=" + numeroCubiculo +
                ", Es especial=" + especial +
                ", Esta ocupado?=" + (ocupado ? "Si" : "No") +
                '}';
    }
}
