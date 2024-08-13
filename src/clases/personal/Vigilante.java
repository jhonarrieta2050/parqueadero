package clases.personal;

import clases.estacionamiento.Cubiculo;
import clases.registro.InfoRegistro;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;


public class Vigilante extends Persona {
    private ArrayList<PersonaCarnet> personasList;
    private ArrayList<InfoRegistro> planilla;

    private boolean verificarHora(){

        LocalTime hora = LocalTime.now();
        LocalTime hora10pm = LocalTime.of(22,00);
        LocalTime hora6am = LocalTime.of(6,00);

        return hora.isAfter(hora6am) && hora.isBefore(hora10pm);
    }

    private Optional<PersonaCarnet> verificarCarnet(PersonaCarnet carnet){
        return  personasList.stream().filter(c ->
                c.getId() == carnet.getId() && carnet.isEspecial()
                ).findAny();
    }

    private boolean verficarCubiculos(ArrayList<Cubiculo> puestos, PersonaCarnet carnet, int op){

        if(op == 1){
            puestos = puestos.stream().filter( c ->
                    !c.isOcupado() &&
                    ).
        }

    }

    private void guardarInformacion(){

    }
    public boolean darAcceso(int id,int op, ArrayList<Cubiculo> puestos){

        PersonaCarnet carnet = new PersonaCarnet(id);
        boolean pass = true;

        pass = this.verificarHora();

        if(!pass){
            return false;
        }

        Optional<PersonaCarnet> access = this.verificarCarnet(carnet);
        if(access.isEmpty()){
           return false;
        }

        carnet = access.get();

        pass = this.verficarCubiculos(puestos,carnet,op);

        return pass;

    }
}
