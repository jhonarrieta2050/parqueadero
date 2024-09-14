package clases.personal;

import clases.concurrencia.Alarma;
import clases.concurrencia.Reloj;
import clases.estacionamiento.Cubiculo;
import clases.registro.InfoRegistro;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

public class Verificacion {
    private static Reloj reloj;
    private final Alarma alarma = new Alarma();

    public Optional<PersonaCarnet> verificarCarnet(PersonaCarnet carnet, ArrayList<PersonaCarnet> personasList) {
        return  personasList.stream().filter(c ->
                c.getId() == carnet.getId()
        ).findAny();
    }

    public Optional<Cubiculo> verficarCubiculos(ArrayList<Cubiculo> puestos, PersonaCarnet carnet, int op){

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
        System.out.println("No hay cubiculos disponibles actualmente");

        return Optional.empty();

    }

    public void verificarCubiculoUso(Cubiculo cubiculo){
        cubiculo.setOcupado(!cubiculo.isOcupado());
    }

    public boolean verificarHora(){
        int hora = Reloj.getHora();
        if(hora <= 7 || hora > 20 || hora >= 12 && hora <= 15 ){
            System.out.println("El parqueadero se encuentra cerrado, vuelva mas tarde");
            return false;
        }
        return true;
    }

    public void guardarInformacion(PersonaCarnet carnet, Cubiculo cubiculo, int pl, ArrayList<InfoRegistro> planilla){
        InfoRegistro info = new InfoRegistro(carnet,pl,cubiculo);
        planilla.add(info);
    }

    public Optional<InfoRegistro> verificarRegistrado(PersonaCarnet carnet, int pl, ArrayList<Cubiculo> puestos,ArrayList<InfoRegistro> planilla ) {
        Optional<InfoRegistro> op=  planilla.stream()
                .filter(c -> c.getPlacaVehiculo() == pl && c.getPersona().getId() == carnet.getId() && !c.isVencido())
                .findFirst();
            op.ifPresent(c -> c.setVencido(true));
            return op;
    }

    public Optional<InfoRegistro> verificacionUsoDeLaMismaPesona(PersonaCarnet personaCarnet, int placa,ArrayList<InfoRegistro> planilla) {
        return planilla.stream().filter(i ->
            i.getPersona().getId() == personaCarnet.getId() && i.getPlacaVehiculo() == placa && !i.isVencido()
        ).findAny();
    }
}
