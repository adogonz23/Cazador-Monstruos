package ies.puerto;

public class Monstruo implements Runnable {
    private String nombre;
    private Mapa mapa;
    private int duracionVida;
    private boolean atrapado;

    public Monstruo(String nombre, Mapa mapa, int duracionVida) {
        this.nombre = nombre;
        this.mapa = mapa;
        this.duracionVida = duracionVida;
        this.atrapado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void atrapar() {
        atrapado = true;
        mapa.eliminarMonstruo(nombre);
        System.out.println(nombre + " ha sido atrapado.");
    }

    @Override
    public void run() {
        
        int[] ubicacion = mapa.generarUbicacion();
        mapa.agregarMonstruo(this, ubicacion);
        System.out.println("Monstruo " + nombre + " apareció en " + ubicacion[0] + ", " + ubicacion[1]);

        try {
            Thread.sleep(duracionVida * 1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!atrapado) {
            mapa.eliminarMonstruo(nombre);
            System.out.println(nombre + " desapareció.");
        }
    }
}

