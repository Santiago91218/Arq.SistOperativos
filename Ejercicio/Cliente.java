package Ejercicio;
public class Cliente extends Thread{
    private int num_id;
    private Barbero barbero;
    public Cliente(int num_id,Barbero barbero) {
        this.num_id = num_id;
        this.barbero=barbero;
    }
    @Override
    public void run() {
        while (true) {
            if (barbero.ocuparSilla()) {
                System.out.println("El cliente " + this.num_id + " llega a la barberia");
                try {
                    Thread.sleep(2000); // simula el tiempo de espera del cliente
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("El cliente " + num_id + " es atendido por el barbero");
                barbero.liberarSilla();
                break;
            }
        }
    }
    public int getNumid() {
        return num_id;
    }
    public void setNumid(int num_id) {
        num_id = num_id;
    }
}