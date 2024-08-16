package clases.personal;

import clases.estacionamiento.Cubiculo;
import clases.registro.InfoRegistro;

import java.util.ArrayList;
import java.util.Optional;


public class Vigilante extends Persona {
    static ArrayList<PersonaCarnet> personasList;
    private final ArrayList<InfoRegistro> planilla;
    private Verificacion verificacion;

    public Vigilante(String nombre, String apellido){
        personasList = new ArrayList<>();
        planilla = new ArrayList<>();
        verificacion = new Verificacion();
        PersonaCarnet usuario = new PersonaCarnet("jhon","arrieta",1042,true);
        personasList.add(usuario);
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public boolean darAcceso(int id,int op, ArrayList<Cubiculo> puestos, int placa){

        PersonaCarnet carnet = new PersonaCarnet(id);
        Optional<Cubiculo> cubiculo;
        boolean pass = true;

        pass = verificacion.verificarHora();

        if(!pass){
            System.out.println("El parqueadero se encuentra cerrado");
            return false;
        }

        Optional<PersonaCarnet> access = verificacion.verificarCarnet(new PersonaCarnet(id),personasList);
        if(access.isEmpty()){
            System.out.println("Usuario no encontrado");
           return false;
        }

        carnet = access.get();

        cubiculo = verificacion.verficarCubiculos(puestos,carnet,op);

        if(cubiculo.isEmpty()){
            System.out.println("No hay cubiculos disponibles");
            return false;
        }

        verificacion.verificarCubiculoUso(cubiculo.get());

        verificacion.guardarInformacion(carnet,cubiculo.get(),placa,planilla);

        System.out.println("Has pasado");
        return pass;

    }

    public Optional<InfoRegistro> verificarRegistrado(PersonaCarnet carnet, int pl, ArrayList<Cubiculo> puestos ) {
        return planilla.stream()
                .filter(c -> c.getPlacaVehiculo() == pl && c.getPersona().getId() == carnet.getId())
                .findFirst();
    }



    public boolean darSalida(PersonaCarnet carnet, int pl, ArrayList<Cubiculo> puestos){
        Optional<InfoRegistro> info = verificacion.verificarRegistrado(carnet,pl,puestos,planilla);
        if(info.isEmpty()){
            System.out.println("No se  encontrado");
            return false;
        }
        verificacion.verificarCubiculoUso(info.get().getCubiculo());
        System.out.println("Salida con exito");
        System.out.println("Hasta la proxima");
        return true;
    }
}
