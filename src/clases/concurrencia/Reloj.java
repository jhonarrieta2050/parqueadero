package clases.concurrencia;

public class Reloj {

   public static int Hora = 0;
   public Alarma alarma = new Alarma();
    public void relojHora() {
        try {
            while (true) {
                if(Hora == 24){
                    Hora = 0;
                }
                if(Hora % 4 == 0) {
                    System.out.println("Son las  " + Hora + ":" + "00" + " Horas");
                }
                if (Hora == 8 || Hora == 12 || Hora == 13 || Hora == 20){
                    alarma.verificarLlamado(Hora);
                }

                Hora++;
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("El temporizador fue interrumpido.");
        }
    }

}
