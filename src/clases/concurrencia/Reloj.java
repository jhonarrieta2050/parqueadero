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
                if (Hora == 6 || Hora == 8 || Hora == 12 || Hora == 15 || Hora == 18 || Hora == 22){
                    alarma.verificarLlamado(Hora);
                }

                Hora++;
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("El temporizador fue interrumpido.");
        }
    }

    public static int getHora() {
        return Hora;
    }
}
