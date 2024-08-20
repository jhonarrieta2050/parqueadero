package clases.personal;

import clases.concurrencia.Reloj;
import clases.estacionamiento.Cubiculo;
import clases.registro.InfoRegistro;

import java.util.ArrayList;
import java.util.Optional;


public class Vigilante extends Persona {
    static ArrayList<PersonaCarnet> personasList;
    private final ArrayList<InfoRegistro> planilla;
    private final Verificacion verificacion;
    private int turno;

    public Vigilante(String nombre, String apellido,int turno){
        personasList = new ArrayList<>();
        planilla = new ArrayList<>();
        verificacion = new Verificacion();
        this.turno = turno;

        PersonaCarnet usuario = new PersonaCarnet("jhon","arrieta",1042,true);
        personasList.add(usuario);
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public boolean darAcceso(int id,int op, ArrayList<Cubiculo> puestos, int placa){

        boolean pass;
        pass = verificacion.verificarHora();
        if (!pass){
            return false;
        }

        Optional<InfoRegistro> registro = verificacion.verificacionUsoDeLaMismaPesona(new PersonaCarnet(id),placa,planilla);
        if(registro.isPresent()){
            System.out.println("Este ya se encuentra usando el mismo parqueadero con el mismo vehiculo");
            return false;
        }

        Optional<PersonaCarnet> carnet = verificacion.verificarCarnet(new PersonaCarnet(id),personasList);
        if(carnet.isEmpty()){
            System.out.println("Usuario no encontrado");
           return false;
        }

        Optional<Cubiculo> cubiculo;
        cubiculo = verificacion.verficarCubiculos(puestos,carnet.get(),op);
        if(cubiculo.isEmpty()){
            System.out.println("No hay cubiculos disponibles");
            return false;
        }

        verificacion.verificarCubiculoUso(cubiculo.get());
        verificacion.guardarInformacion(carnet.get(),cubiculo.get(),placa,planilla);

        System.out.println("Has pasado");
        return true;
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

    public void verPlanilla(){
        ImprimirInfo.imprimir(planilla);
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void sumarTurno(){
        turno++;
    }

    @Override
    public String toString() {
        return "Vigilante{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
