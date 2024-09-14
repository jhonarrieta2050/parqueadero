package clases.vistas;

import clases.Parqueadero;
import clases.concurrencia.IniciarReloj;
import clases.concurrencia.Reloj;
import clases.personal.TurnoVigilante;
import clases.personal.Vigilante;

import java.util.ArrayList;
import java.util.Scanner;

public class EleccionSede {

    private ArrayList<Parqueadero> parqueaderos = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private static final Thread reloj = new Thread(new IniciarReloj());
    public EleccionSede() {
        ArrayList<Vigilante> vigilantes = new ArrayList<>();
        vigilantes.add(new Vigilante("pepe","elmago",1));
        vigilantes.add(new Vigilante("Sebastian","Herrera",3));
        vigilantes.add(new Vigilante("fernando","perez",5));

        parqueaderos.add(new Parqueadero(vigilantes,"Cuatro Vientos"));
        parqueaderos.add(new Parqueadero(vigilantes,"Turbaco"));
        TurnoVigilante.setParqueaderos(parqueaderos);
        reloj.start();
    }

    public Parqueadero eleccion(){
        int op;
        System.out.println("Bienvenido");
        System.out.println("Ha que sede se dirige?");
        System.out.println("1.Cuatro vientos");
        System.out.println("2.Centro");
        System.out.println("3.Turbaco");
        System.out.println("4.Salir");
        op = scanner.nextInt();

            switch(op) {
                case 1:
                    TurnoVigilante.setParqueaderoActual(parqueaderos.get(0));
                    return parqueaderos.get(0);
                case 2:
                    TurnoVigilante.setParqueaderoActual(parqueaderos.get(1));
                   return parqueaderos.get(1);
                case 3:
                    TurnoVigilante.setParqueaderoActual(parqueaderos.get(2));
                    return parqueaderos.get(2);
                    case 4:
                        System.exit(0);
            }
        return null;
    }

    public void iniciarParqueadero(Parqueadero parqueadero) {
        boolean pass = true;
        while (pass) {
            int op;

            System.out.println("Bienvenido a la sede " + parqueadero.getNombreParqueadero());
            System.out.println("Que desea hacer?");
            System.out.println("1.Entrada de vehiculo");
            System.out.println("2.Salida de vehiculo");
            System.out.println("3.Cambiar sede");
            System.out.println("4.Ver cubiculos");
            System.out.println("5.Ver informacion de registro");
            System.out.println("6.Ver vigilante actual");
            System.out.println("7.Terminar programa");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    parqueadero.entrada();
                    break;
                case 2:
                    parqueadero.salida();
                    break;
                    case 3:
                        pass = false;
                        break;
                        case 4:
                            parqueadero.verCubiculos();
                            break;
                            case 5:
                            parqueadero.verInformacionRegistro();
                            break;
                                case 6:
                                    System.out.println(parqueadero.getVigilanteActual().toString());
                                    break;
                        case 7:
                            System.exit(0);
                            break;
            }
        }
    }
}
