
package videojuegos;

import static config.AppConstants.PATH_CSV;
import static config.AppConstants.PATH_SERIAL;

public class Personaje implements Comparable<Personaje> {
    private int ID;
    private String nombre;
    private ClasePersonaje clasePersonaje;
    private int nivelPersonaje;

    public Personaje(int ID, String nombre, ClasePersonaje clasepersonaje, int nivelPersonaje) {
        this.ID = ID;
        this.nombre = nombre;
        this.clasePersonaje = clasePersonaje;
        this.nivelPersonaje = nivelPersonaje;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "," + "Nombre: " + nombre + "," + "Clase: " + clasePersonaje + "," + "Nivel: " + nivelPersonaje;
    }

    @Override
    public int compareTo(Personaje o) {
        return nombre.compareTo(o.nombre);
    }

    public ClasePersonaje getClasePersonaje() {
        return clasePersonaje;
    }
    
    public void aumentarNivel(double porcentaje) {
    nivelPersonaje = (int)( nivelPersonaje + nivelPersonaje * porcentaje / 100);
    }
     
    public String toCSV(){
        return ID + "," + nombre + "," + clasePersonaje + "," + nivelPersonaje;
    }
    
    public static Personaje fromCSV(String empleadosCSV) {
        Personaje p1 = null;
        String[] values = empleadosCSV.split(",");
        if (values.length == 4) { // aca valido porq son 4 valores
            int ID = Integer.parseInt(values[0]);
            String nombre = values[1];
            ClasePersonaje clase = ClasePersonaje.valueOf(values[2]);
            int nivelPersonaje = Integer.parseInt(values[3]);

            p1 = new Personaje(ID, nombre, clase, nivelPersonaje);
        }
        return p1;
    }
        

    
    
}
