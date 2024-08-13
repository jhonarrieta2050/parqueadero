import clases.Parqueadero;

import java.util.Scanner;

public class Main {
    private static Parqueadero parqueadero = new Parqueadero();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int op;
        System.out.println("Bienvenido");
        System.out.println("Que desea hacer");
        System.out.println("1.Entrada de vehiculo");
        System.out.println("2.salida de vehiculo");
        System.out.println("3.finalizar programa");
        op = scanner.nextInt();
        while(op != 3) {
            switch(op) {
                case 1:
                    parqueadero.entrada();
                    break;
                    case 2:
                        parqueadero.salida();
                        break;
                        case 3:
                            System.out.println("Hasta la proxima");

            }
        }
    }
}