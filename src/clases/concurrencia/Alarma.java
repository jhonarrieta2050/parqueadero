package clases.concurrencia;


import static clases.personal.TurnoVigilante.*;

public class Alarma {

    public void verificarLlamado(int op){
        switch (op){
            case 6:
                cambioVigilante("Manana");
                break;
            case 8:
                abierto();
                break;
            case 12:
                almuerzo();
                break;
            case 13:
                abierto();
                break;
            case 18:
                cambioVigilante("Noche");
                break;
            case 22:
                cerrado();
                break;
            case 0:
                cambioTurno();
        }
    }

    private void abierto(){
        System.out.println("El parqueadero a sido abierto");
    }
    private void almuerzo(){
        System.out.println("El parqueadero esta cerrado por hora de almuerzo, Vuelva mas tarde");
    }
    private void cerrado(){
        System.out.println("El parqueadero a cerrado, vuelva mañana");
    }
}
