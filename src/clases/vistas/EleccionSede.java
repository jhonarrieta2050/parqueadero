package clases.vistas;

import clases.Parqueadero;
import clases.personal.Vigilante;

import java.util.Scanner;

public class EleccionSede {

    private final Parqueadero[] parqueaderos = new Parqueadero[2];
    private final Scanner scanner = new Scanner(System.in);

    public EleccionSede() {
        Vigilante vigilante = new Vigilante("pepe","elmago");
        parqueaderos[0] = new Parqueadero(vigilante,"Cuatro Vientos");
        parqueaderos[1] = new Parqueadero(vigilante,"Centro");
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
                    return parqueaderos[0];
                case 2:
                   return parqueaderos[1];
                case 3:
                    return parqueaderos[2];
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
            System.out.println("6.Terminar programa");
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
                            System.exit(0);
                            break;
            }
        }
    }
}
