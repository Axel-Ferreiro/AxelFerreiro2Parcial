
package videojuegos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Inventario<T> implements Jugable<T> {
    
    private ArrayList<T> lista = new ArrayList<>();

    @Override
    public void agregar(T item) {
        if (item == null) {
            throw new IllegalArgumentException("No se puede agregar un null");
        }
        lista.add(item);
    }
    
    @Override
    public void paraCadaElemento(Consumer<? super T> accion) {
        for(T item: lista){
            accion.accept(item);
        }
    }


    @Override
    public List<T> filtrar(Predicate<? super T> criterio) {
        List<T> aux = new ArrayList<>();
        for (T item : lista) {
            if (criterio.test(item)) {
                aux.add(item);
            }
        }
        return aux;
    }

    @Override
    public List<T> transformar(Function<? super T, ? extends T> transformacion) {
        List<T> aux = new ArrayList<>();
        for (T item : lista) {
            aux.add(transformacion.apply(item));
            }
        return aux;  
    }

    public Iterator<T> ordenar() {
        List<T> aux = new ArrayList<>(lista);
        aux.sort(null);
        return aux.iterator();       
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void guardarEnArchivo(List <Personaje> lista, String path) {
        File archivo = new File(path);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write("aca va el titulo\n");
            for (Personaje p : lista) {
                bw.write(p.toCSV() + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public static Personaje fromCSV(String personajesCSV) {
        Personaje p1 = null;
        String[] values = personajesCSV.split(",");
        if (values.length == 4) { // 
            int ID = Integer.parseInt(values[0]);
            String nombre = values[1];
            ClasePersonaje clase = ClasePersonaje.valueOf(values[2]);
            int nivelPersonaje = Integer.parseInt(values[3]);

            p1 = new Personaje(ID, nombre, clase, nivelPersonaje);
        }
        return p1;
    }
    
    public static List<Personaje> cargarDesdeArchivo(String path) {
        List<Personaje> aux = new ArrayList<>();
        File archivo = new File(path);

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                if (linea.endsWith("\n")) {
                    linea = linea.substring(linea.length() - 1);
                }
                aux.add(Personaje.fromCSV(linea));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return aux;
    }


}

