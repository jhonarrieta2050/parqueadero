package clases.estacionamiento;

public class CubiculoMotos extends Cubiculo{

    public CubiculoMotos(boolean especial) {
        super(especial);
    }

    @Override
    void estacionarVehiculo() {
        System.out.println("-----------------------------------");
        System.out.println("Ha estacionado una motocicleta");
        System.out.println("-----------------------------------");
    }
}
