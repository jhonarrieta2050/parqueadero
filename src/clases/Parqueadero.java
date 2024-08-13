package clases;

import clases.estacionamiento.Cubiculo;
import clases.estacionamiento.CubiculoAutos;
import clases.estacionamiento.CubiculoMotos;
import clases.personal.Vigilante;
import java.util.ArrayList;
import java.util.Scanner;

public class Parqueadero{

    private final ArrayList<Cubiculo> estacionamiento;
    private Vigilante vigilante;
    private final Scanner scanner = new Scanner(System.in);

    public Parqueadero(){
        estacionamiento = new ArrayList<>();

        estacionamiento.add(new CubiculoAutos(true));
        estacionamiento.add(new CubiculoAutos(true));
        estacionamiento.add(new CubiculoAutos(true));
        estacionamiento.add(new CubiculoAutos(true));
        estacionamiento.add(new CubiculoAutos(false));
        estacionamiento.add(new CubiculoAutos(false));
        estacionamiento.add(new CubiculoAutos(false));
        estacionamiento.add(new CubiculoAutos(false));
        estacionamiento.add(new CubiculoMotos(true));
        estacionamiento.add(new CubiculoMotos(true));
        estacionamiento.add(new CubiculoMotos(true));
        estacionamiento.add(new CubiculoMotos(false));
        estacionamiento.add(new CubiculoMotos(false));
        estacionamiento.add(new CubiculoMotos(false));

    }

    public void entrada(){

        System.out.println("Escriba su id");
        int id = scanner.nextInt();
        System.out.println("1.Carro o 2.moto");
        int op = scanner.nextInt();


        vigilante.darAcceso(id,op,estacionamiento);
    }

    public void salida(){

    }
}
