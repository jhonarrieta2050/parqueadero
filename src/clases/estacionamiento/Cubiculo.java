package clases.estacionamiento;

public abstract class Cubiculo {
    protected int numeroCubiculo;
    protected boolean especial;
    protected boolean ocupado;

    abstract void estacionarVehiculo();
}
