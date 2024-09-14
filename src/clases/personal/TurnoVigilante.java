package clases.personal;

import clases.Parqueadero;

import java.util.ArrayList;


public class TurnoVigilante {
    private static ArrayList<Parqueadero> parqueaderos;
    private static Parqueadero parqueaderoActual;

    public static ArrayList<Parqueadero> getParqueaderos() {
        return parqueaderos;
    }

    public static void setParqueaderos(ArrayList<Parqueadero> parqueaderos) {
        TurnoVigilante.parqueaderos = parqueaderos;
    }

    public static Parqueadero getParqueaderoActual() {
        return parqueaderoActual;
    }

    public static void setParqueaderoActual(Parqueadero parqueaderoActual) {
        TurnoVigilante.parqueaderoActual = parqueaderoActual;
    }

    public static void cambioTurno() {
        parqueaderos.forEach(P -> {
            P.getVigilantes().forEach(vigilante -> {
                if (vigilante.getTurno() == 6) {
                    vigilante.setTurno(0);
                } else {
                    vigilante.sumarTurno();
                }
            });
        });
    }

    public static void cambioVigilante(String horaDelDia) {
        if (horaDelDia.equals("Manana")) {
            parqueaderos.forEach(P -> {
                P.setVigilanteActual(P.getVigilantes()
                        .stream().filter(vigilante ->
                                vigilante.getTurno() == 1 || vigilante.getTurno() == 2
                        ).findFirst().orElse(null));
            });
        }

        if (horaDelDia.equals("Noche")) {
            parqueaderos.forEach(P -> {
                P.setVigilanteActual(P.getVigilantes()
                        .stream().filter(vigilante ->
                                vigilante.getTurno() == 3 || vigilante.getTurno() == 4
                        ).findFirst().orElse(null));
            });
        }
    }
}