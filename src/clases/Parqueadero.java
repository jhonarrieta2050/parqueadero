package clases;

import clases.estacionamiento.Cubiculo;
import clases.personal.Vigilante;
import java.util.ArrayList;
import java.util.Scanner;

public class Parqueadero{

    private ArrayList<Cubiculo> estacionamiento;
    private Vigilante vigilante;
    private final Scanner scanner = new Scanner(System.in);

    public void entrada(){

        System.out.println("Escriba su id");
        int id = scanner.nextInt();

        vigilante.darAcceso(id,estacionamiento);
    }

    public void salida(){

    }
}
