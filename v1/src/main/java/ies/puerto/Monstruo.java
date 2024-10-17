package ies.puerto;

public class Monstruo {
    
    String nombre;
    int vida;                                                                                                                                                                                                           

    public Monstruo() {
    }

    public Monstruo(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vidaMonstruo();
    }
    
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    private  int vidaMonstruo(){
        int vida= (int)(30*Math.random()+1);
        return vida;
    }
}
