package clases.personal;

import clases.estacionamiento.Cubiculo;
import clases.registro.InfoRegistro;

import java.time.LocalTime;
import java.util.ArrayList;


public class Vigilante extends Persona {
    private ArrayList<PersonaCarnet> personasList;
    private ArrayList<InfoRegistro> planilla;

    private boolean verificarHora(){

        LocalTime hora = LocalTime.now();
        LocalTime hora10pm = LocalTime.of(22,00);
        LocalTime hora6am = LocalTime.of(6,00);

        return hora.isAfter(hora6am) && hora.isBefore(hora10pm);
    }

    private boolean verificarCarnet(int carnet){
        return  personasList.stream().anyMatch(c ->
                c.getId() == carnet);
    }

    public boolean darAcceso(int carnet, ArrayList<Cubiculo> puestos){
        boolean pass = true;

        pass = this.verificarHora();

        if(!pass){
            return false;
        }

        pass = this.verificarCarnet(carnet);
        if(!pass){
           return false;
        }

        return pass;

    }
}
