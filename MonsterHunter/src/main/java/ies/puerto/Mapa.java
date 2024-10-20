import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;

public class Mapa {
    private int size;
    private ConcurrentHashMap<String, int[]> ubicaciones; 
    private Random random;

    public Mapa(int size) {
        this.size = size;
        this.ubicaciones = new ConcurrentHashMap<>();
        this.random = new Random();
    }

    public int[] generarUbicacion() {
        
        int x = random.nextInt(size);
        int y = random.nextInt(size);
        return new int[] {x, y};
    }

    public void moverCazador(Cazador cazador, int[] nuevaUbicacion) {

        ubicaciones.put(cazador.getNombre(), nuevaUbicacion);
    }

    public void agregarMonstruo(Monstruo monstruo, int[] ubicacion) {

        ubicaciones.put(monstruo.getNombre(), ubicacion);
    }

    public void eliminarMonstruo(String nombre) {
        
        ubicaciones.remove(nombre);
    }

    public int[] obtenerUbicacion(String nombre) {
       
        return ubicaciones.get(nombre);
    }

    public boolean mismaUbicacion(int[] ubicacion1, int[] ubicacion2) {
        
        return ubicacion1[0] == ubicacion2[0] && ubicacion1[1] == ubicacion2[1];
    }
}

