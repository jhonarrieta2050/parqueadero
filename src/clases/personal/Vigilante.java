package clases.personal;

import clases.registro.InfoRegistro;

import java.util.ArrayList;
import java.util.Date;

public class Vigilante extends Persona {
    private ArrayList<PersonaCarnet> personasList;
    private ArrayList<InfoRegistro> planilla;

    private boolean verificarHora(){
        Date fecha = new Date();
    }

    private boolean verificarCarnet(int carnet){

    }

    public boolean darAcceso(int carnet){
        boolean pass = true;

        pass = this.verificarCarnet(carnet);
        if(!pass){
           return false;
        }

    }
}
