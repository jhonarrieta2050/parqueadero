package clases.concurrencia;

public class Alarma {

    public void verificarLlamado(int op){
        switch (op){
            case 8:
                abierto();
                break;
            case 12:
                almuerzo();
                break;
            case 13:
                abierto();
                break;
            case 20:
                cerrado();
                break;
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
