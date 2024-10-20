package ies.puerto;

public class Juego {
    public static void main(String[] args) throws InterruptedException {
        Mapa mapa = new Mapa(10); 
        int duracionJuego = 30;

 
        Cazador cazador1 = new Cazador("Cazador1", mapa, 2, 0.7);
        Cazador cazador2 = new Cazador("Cazador2", mapa, 3, 0.6);


        Monstruo monstruo1 = new Monstruo("Monstruo1", mapa, 5);
        Monstruo monstruo2 = new Monstruo("Monstruo2", mapa, 8);

        cazador1.start();
        cazador2.start();


        Thread hiloMonstruo1 = new Thread(monstruo1);
        Thread hiloMonstruo2 = new Thread(monstruo2);

        hiloMonstruo1.start();
        hiloMonstruo2.start();


        Thread.sleep(duracionJuego * 1000);

        cazador1.interrupt();
        cazador2.interrupt();
        hiloMonstruo1.interrupt();
        hiloMonstruo2.interrupt();

        System.out.println("El juego ha terminado.");
        System.out.println(cazador1.getNombre() + " atrapó " + cazador1.getMonstruosAtrapados() + " monstruos.");
        System.out.println(cazador2.getNombre() + " atrapó " + cazador2.getMonstruosAtrapados() + " monstruos.");
    }
}

