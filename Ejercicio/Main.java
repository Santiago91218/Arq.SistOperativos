package Ejercicio;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Barbero barber1=new Barbero("Santiago");

        System.out.println("Ingrese cuantos clientes tiene el Barbero "+barber1.getNombre());
        int clientes=sc.nextInt();
        barber1.setNum_clientes(clientes);
        barber1.start();

        for (int i = 0; i <clientes;i++) {
            //tiene que tener asociado un barbero
            Cliente cliente=new Cliente(i+1,barber1);
            cliente.start();
        }

    }
}