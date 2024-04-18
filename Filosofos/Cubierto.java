package Tp2.Filosofos;
public class Cubierto {
    private boolean disponible;
    private int id;
    //Metodos sincronizados, para asegurar que solo un hilo pueda ejecutarlos a la vez
    public Cubierto(int id) {
        this.id = id;
    }
    public synchronized boolean agarrarTenedor()  throws InterruptedException{
        if (disponible) {
            disponible = false;
            /*si retorna true significa que pudo tomar el cubierto, y continua con el proceso de adquirir el otro
             cubierto*/
            return true;
        } else {
            /*si retorna false significa qu eno pudo tomarlo, y puede decidir liberar el cubierto que haya tomado y
            esperar antes de volver a intentar*/
            return false;
        }
    }
    public synchronized void soltarTenedor() {
        //esto indica que se solto el tenerdo y ahora esta disponible
        disponible = true;
    }
}