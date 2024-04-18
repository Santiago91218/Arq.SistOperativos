package Tp2.Filosofos;
public class Main {
    public static void main(String[] args) {
        Cubierto [] cubiertos= new Cubierto[5];
        for (int i = 0; i < 5; i++) {
            //se crea un objeto tipo Cubierto
            cubiertos[i] = new Cubierto(i);
        }
        Filosofo [] filosofos= new Filosofo[5];
        /*cubiertos[i] es el cubierto de la izquierda
          cubierto[(i+1)%5], es para el de la derecha, el 5% es para que este dentro del rango valido i+1 es 5,
          5% lo convierte en 0*/
        for (int i = 0; i < 5; i++) {
            filosofos[i]=new Filosofo(i+1,cubiertos[i],cubiertos[(i + 1) % 5]);
            filosofos[i].start();
        }
    }
}