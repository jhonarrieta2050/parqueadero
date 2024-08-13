package clases.estacionamiento;

public class CubiculoAutos extends Cubiculo{


    public CubiculoAutos(boolean especial) {
        super(especial);
    }

    @Override
    void estacionarVehiculo() {
        System.out.println("-----------------------------------");
        System.out.println("Ha estacionado un automovil");
        System.out.println("-----------------------------------");
    }
}
