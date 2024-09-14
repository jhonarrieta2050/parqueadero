package clases.concurrencia;

public class IniciarReloj implements Runnable{
    private Reloj reloj = new Reloj();
    @Override
    public void run() {
        reloj.relojHora();
    }
}
