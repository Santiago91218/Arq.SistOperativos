package Ejercicio;
public class Barbero extends Thread {
    private static final int num_sillas = 3;
    private static int sillasOcupadas = 0;
    private String nombre;
    private boolean disponible;
    private int num_clientes;
    public Barbero(String nombre) {
        this.nombre = nombre;
        this.disponible = true;
    }
    @Override
    public void run() {
        System.out.println("El barbero comenzo a trabajar");
        try {
            int tiempo= 1000 * num_clientes;//suponemos que tarda 1 segundos por cliente
            Thread.sleep(tiempo); // Simula el tiempo que tarda en trabajar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //si el barbero se duerme es poruqe ya no tiene clientes por atender
        System.out.println("El barbero " + nombre + " esta durmiendo");
    }
    public synchronized boolean ocuparSilla(){
        if(sillasOcupadas<num_sillas){
            sillasOcupadas++;
            //barbero no disponible para atender a un cliente
            this.disponible=false;
            return true;//El cliente pudo tomar una silla
        }
        return false;//El cliente no pudo tomar una silla
    }
    public synchronized void liberarSilla() {
        sillasOcupadas--;
        //barbero disponible para atender a un cliente
        this.disponible = true;
    }
    public boolean isDisponible() {
        //Si el barbero esta disponible,puede atender a otro cliente
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public static int getSillasOcupadas() {
        return sillasOcupadas;
    }
    public static void setSillasOcupadas(int sillasOcupadas) {
        Barbero.sillasOcupadas = sillasOcupadas;
    }
    public int getNum_clientes() {
        return num_clientes;
    }
    public void setNum_clientes(int num_clientes) {
        this.num_clientes = num_clientes;
    }
}