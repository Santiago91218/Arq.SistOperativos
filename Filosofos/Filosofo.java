package Tp2.Filosofos;
public class Filosofo extends Thread{
    private int numero;
    private Cubierto izquierda,derecha;
    public Filosofo(int numero,Cubierto izquierda,Cubierto derecha) {
        this.numero = numero;
        this.izquierda=izquierda;
        this.derecha=derecha;
    }
    @Override
    public void run() {
        try{
            while(true){
                //le sumamos 1000, porque es el tiempo minimo,con long sacamos los decimales
                Thread.sleep((long) (Math.random() * 4000) + 1000);
                System.out.println("El filosofo "+numero+" esta pensando");//esta pensando

                //filosofo intenta agarrar el cubierto izquierdo
                synchronized (izquierda) {
                    System.out.println("El filosofo " + numero + " intenta tomar el cubierto izquierdo");
                    izquierda.agarrarTenedor();

                    //filosofo intenta agarrar el cubierto derecho
                    synchronized (derecha) {
                        System.out.println("El filosofo " + numero + " intenta tomar el cubierto derecho");
                        derecha.agarrarTenedor();

                        System.out.println("El filosofo " + numero + " esta comiendo");//esta comiendo
                        Thread.sleep((long) (Math.random() * 4000) + 1000);
                    }
                }
                //despues de comer suelta los cubiertos
                izquierda.soltarTenedor();
                derecha.soltarTenedor();
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}