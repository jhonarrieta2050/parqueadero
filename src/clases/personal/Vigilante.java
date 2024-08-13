package clases.personal;

import clases.estacionamiento.Cubiculo;
import clases.registro.InfoRegistro;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;


public class Vigilante extends Persona {
    private ArrayList<PersonaCarnet> personasList;
    private ArrayList<InfoRegistro> planilla;

    public Vigilante(){
        personasList = new ArrayList<>();
        personasList.add(new PersonaCarnet("jhon","arreita",1042,true));
    }

    private boolean verificarHora(){

        LocalTime hora = LocalTime.now();
        LocalTime hora10pm = LocalTime.of(22,00);
        LocalTime hora6am = LocalTime.of(6,00);

        return hora.isAfter(hora6am) && hora.isBefore(hora10pm);
    }

    private Optional<PersonaCarnet> verificarCarnet(PersonaCarnet carnet){
        return  personasList.stream().filter(c ->
                c.getId() == carnet.getId()
                ).findAny();
    }

    private Optional<Cubiculo> verficarCubiculos(ArrayList<Cubiculo> puestos, PersonaCarnet carnet, int op){

        if(op == 1 && carnet.isEspecial()){
            return puestos.stream().filter( c ->
                    !c.isOcupado() && c.isEspecial()
                    ).findAny();
        }else if(op == 1 && !carnet.isEspecial()){
            return puestos.stream().filter( c ->
                    !c.isOcupado() && !c.isEspecial()
            ).findAny();
        }else if(op == 2 && carnet.isEspecial()){
            return puestos.stream().filter( c ->
                    !c.isOcupado() && !c.isEspecial()
            ).findAny();
        }else if(op == 2 && !carnet.isEspecial()){
            return puestos.stream().filter( c ->
                    !c.isOcupado() && !c.isEspecial()
            ).findAny();
        }
        System.out.println("HUBO ERROR");

        return Optional.empty();

    }

    private void guardarInformacion(PersonaCarnet carnet, Cubiculo cubiculo,int pl){
        InfoRegistro info = new InfoRegistro(carnet,pl,cubiculo.getNumeroCubiculo());
        planilla.add(info);

    }
    public boolean darAcceso(int id,int op, ArrayList<Cubiculo> puestos, int placa){

        PersonaCarnet carnet = new PersonaCarnet(id);
        Optional<Cubiculo> cubiculo;
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

        cubiculo = this.verficarCubiculos(puestos,carnet,op);

        if(cubiculo.isEmpty()){
            System.out.println("No hay cubiculos disponibles");
            return false;
        }

        this.guardarInformacion(carnet,cubiculo.get(),placa);

        System.out.println("Has pasado");
        return pass;

    }

    public Optional<InfoRegistro> buscarRegistrado(PersonaCarnet carnet, int pl, ArrayList<Cubiculo> puestos ) {
        return planilla.stream()
                .filter(c -> c.getPlacaVehiculo() == pl && c.getPersona().getId() == carnet.getId())
                .findFirst();
    }



    public boolean darSalida(PersonaCarnet carnet, int pl, ArrayList<Cubiculo> puestos){
        Optional<InfoRegistro> info = this.buscarRegistrado(carnet,pl,puestos);
        if(info.isEmpty()){
            System.out.println("No se  encontrado");
            return false;
        }

        return true;
    }
}
