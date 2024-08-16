import clases.Parqueadero;
import clases.vistas.EleccionSede;

import java.util.Scanner;

public class Main {
    private static final EleccionSede sede = new EleccionSede();
    public static void main(String[] args) {

        while (true) {
            Parqueadero parqueadero = sede.eleccion();
            sede.iniciarParqueadero(parqueadero);
        }
    }
}
