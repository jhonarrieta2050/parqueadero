package clases;

import clases.concurrencia.Reloj;
import clases.estacionamiento.Cubiculo;
import clases.estacionamiento.CubiculoAutos;
import clases.estacionamiento.CubiculoMotos;
import clases.personal.ImprimirInfo;
import clases.personal.PersonaCarnet;
import clases.personal.Vigilante;
import java.util.ArrayList;
import java.util.Scanner;

public class Parqueadero{

    private final String nombreParqueadero;
    private final ArrayList<Cubiculo> estacionamiento;
    private ArrayList<Vigilante> vigilantes;
    private Vigilante vigilanteActual;
    private final Scanner scanner = new Scanner(System.in);

    public Parqueadero(ArrayList<Vigilante> vigilantes,String nombrePaqueadero){
        this.nombreParqueadero = nombrePaqueadero;
        this.vigilantes = vigilantes;
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

        vigilanteActual.darAcceso(id,op,estacionamiento,pl);
    }

    public void salida(){

        System.out.println("Escriba su id");
        int id = scanner.nextInt();
        System.out.println("Placa del vehiculo");
        int pl = scanner.nextInt();

        vigilanteActual.darSalida(new PersonaCarnet(id),pl,estacionamiento);

    }

    public void verCubiculos(){
        ImprimirInfo.imprimir(estacionamiento);
    }

    public void verInformacionRegistro(){
        vigilanteActual.verPlanilla();
    }

    public String getNombreParqueadero() {
        return nombreParqueadero;
    }

    public ArrayList<Vigilante> getVigilantes() {
        return vigilantes;
    }

    public void setVigilantes(ArrayList<Vigilante> vigilantes){
        this.vigilantes = vigilantes;
    }


    public Vigilante getVigilanteActual() {
        return vigilanteActual;
    }

    public void setVigilanteActual(Vigilante vigilanteActual) {
        this.vigilanteActual = vigilanteActual;
    }

}
