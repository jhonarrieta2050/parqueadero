package clases;

import clases.concurrencia.Reloj;
import clases.estacionamiento.Cubiculo;
import clases.estacionamiento.CubiculoAutos;
import clases.estacionamiento.CubiculoMotos;
import clases.personal.PersonaCarnet;
import clases.personal.Vigilante;
import java.util.ArrayList;
import java.util.Scanner;

public class Parqueadero{

    private final String nombreParqueadero;
    private final ArrayList<Cubiculo> estacionamiento;
    private final Vigilante vigilante;
    private final Scanner scanner = new Scanner(System.in);

    public Parqueadero(Vigilante vigilante,String nombrePaqueadero){
        this.nombreParqueadero = nombrePaqueadero;
        this.vigilante = vigilante;

        estacionamiento = new ArrayList<>();
        estacionamiento.add(new CubiculoMotos(true));
        estacionamiento.add(new CubiculoMotos(true));
        estacionamiento.add(new CubiculoMotos(true));
        estacionamiento.add(new CubiculoMotos(false));
        estacionamiento.add(new CubiculoMotos(false));
        estacionamiento.add(new CubiculoMotos(false));
        estacionamiento.add(new CubiculoAutos(true));
        estacionamiento.add(new CubiculoAutos(true));
        estacionamiento.add(new CubiculoAutos(true));
        estacionamiento.add(new CubiculoAutos(false));
        estacionamiento.add(new CubiculoAutos(false));
        estacionamiento.add(new CubiculoAutos(false));

    }

    public void entrada(){

        System.out.println("Escriba su id");
        int id = scanner.nextInt();
        System.out.println("1.Carro o 2.moto");
        int op = scanner.nextInt();
        System.out.println("Placa del vehiculo");
        int pl = scanner.nextInt();

        vigilante.darAcceso(id,op,estacionamiento,pl);
    }

    public void salida(){

        System.out.println("Escriba su id");
        int id = scanner.nextInt();
        System.out.println("Placa del vehiculo");
        int pl = scanner.nextInt();

        vigilante.darSalida(new PersonaCarnet(id),pl,estacionamiento);

    }

    public String getNombreParqueadero() {
        return nombreParqueadero;
    }
}
