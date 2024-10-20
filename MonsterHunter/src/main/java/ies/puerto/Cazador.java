package ies.puerto;

import java.util.Random;

public class Cazador extends Thread {
    private String nombre;
    private Mapa mapa;
    private int tiempoEspera;
    private double tasaExito; // Probabilidad de atrapar un monstruo (ejemplo: 0.7 = 70%)
    private int monstruosAtrapados;
    private Random random;

    public Cazador(String nombre, Mapa mapa, int tiempoEspera, double tasaExito) {
        this.nombre = nombre;
        this.mapa = mapa;
        this.tiempoEspera = tiempoEspera;
        this.tasaExito = tasaExito;
        this.monstruosAtrapados = 0;
        this.random = new Random();
    }

    public String getNombre() {
        return nombre;
    }

    public int getMonstruosAtrapados() {
        return monstruosAtrapados;
    }

    @Override
    public void run() {
        while (true) { // El cazador se moverá continuamente hasta que el juego termine
            int[] nuevaUbicacion = mapa.generarUbicacion();
            mapa.moverCazador(this, nuevaUbicacion);
            System.out.println(nombre + " se movió a " + nuevaUbicacion[0] + ", " + nuevaUbicacion[1]);

            // Revisar si hay un monstruo en la misma ubicación
            for (String entidad : mapa.ubicaciones.keySet()) {
                if (!entidad.equals(nombre) && entidad.startsWith("Monstruo")) {
                    int[] ubicacionMonstruo = mapa.obtenerUbicacion(entidad);
                    if (mapa.mismaUbicacion(nuevaUbicacion, ubicacionMonstruo)) {
                        intentarAtrapar(entidad);
                    }
                }
            }

            // Pausar entre movimientos para simular la acción de cazar
            try {
                Thread.sleep(tiempoEspera * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void intentarAtrapar(String nombreMonstruo) {
        // El cazador intenta atrapar el monstruo con una probabilidad de éxito
        double probabilidad = random.nextDouble();
        if (probabilidad < tasaExito) {
            Monstruo monstruo = (Monstruo) mapa.obtenerUbicacion(nombreMonstruo);
            monstruo.atrapar();
            monstruosAtrapados++;
            System.out.println(nombre + " atrapó a " + nombreMonstruo);
        } else {
            System.out.println(nombre + " falló en atrapar a " + nombreMonstruo);
        }
    }
}

