
package videojuegos;

import config.AppConstants;
import static config.AppConstants.PATH_CSV;
import static config.AppConstants.PATH_SERIAL;
import java.io.IOException;

public class test {


    public static void main(String[] args) {
        
        
       
        try {
// Crear un inventario de personajes jugables
            Inventario<Personaje> inventarioPersonajes = new Inventario<>();
            inventarioPersonajes.agregar(new Personaje(1, "Aragorn", ClasePersonaje.GUERRERO,
                    20));
            inventarioPersonajes.agregar(new Personaje(2, "Gandalf", ClasePersonaje.MAGO, 50));
            inventarioPersonajes.agregar(new Personaje(3, "Legolas", ClasePersonaje.ARQUERO,
                    25));
            inventarioPersonajes.agregar(new Personaje(4, "Frodo", ClasePersonaje.GUERRERO,
                    10));
            inventarioPersonajes.agregar(new Personaje(5, "Saruman", ClasePersonaje.MAGO, 40));
            inventarioPersonajes.agregar(new Personaje(6, "Robin Hood", ClasePersonaje.ARQUERO,
                    30));
            
// Mostrar todos los personajes en el inventario
            System.out.println("Inventario de personajes:");
            inventarioPersonajes.paraCadaElemento(personaje
                    -> System.out.println(personaje));
// Ordenar personajes de manera natural (por nombre)
            System.out.println("\nPersonajes ordenados por nombre (orden natural):");
            inventarioPersonajes.ordenar();
            inventarioPersonajes.paraCadaElemento(personaje
                    -> System.out.println(personaje));
// Ordenar personajes por nivel utilizando un Comparator
            System.out.println("\nPersonajes ordenados por nivel:");
            inventarioPersonajes.ordenar();
            inventarioPersonajes.paraCadaElemento(personaje
                    -> System.out.println(personaje));
// Filtrar personajes de clase MAGO
            System.out.println("\nPersonajes de la clase MAGO:");
            inventarioPersonajes.filtrar(p -> p.getClasePersonaje().equals(ClasePersonaje.MAGO))
                    .forEach(personaje -> System.out.println(personaje));
// Transformar personajes: aumentar nivel en +5
            System.out.println("\nAumentando nivel de todos los personajes en +5:");
            inventarioPersonajes.transformar((Personaje p) -> {
                p.aumentarNivel(5);
                return p;
            }
            );
            inventarioPersonajes.paraCadaElemento(personaje
                    -> System.out.println(personaje));
// Guardar el inventario en un archivo binario
// Cargar el inventario desde el archivo binario
            Inventario<Personaje> inventarioCargado = new Inventario<>();
            inventarioCargado.guardarEnArchivo(inventarioPersonajes,PATH_CSV);
            System.out.println("\nPersonajes cargados desde archivo binario:");
            inventarioCargado.paraCadaElemento(personaje
                    -> System.out.println(personaje));4 // Guardar el inventario en un archivo CSV

            inventarioPersonajes.guardarEnCSV(inventarioPersonajes,PATH_CSV);
// Cargar el inventario desde el archivo CSV
            inventarioCargado.cargarDesdeCSV("src/data/personajes.csv",/* acá va una
expresión lambda*/);
            System.out.println("\nPersonajes cargados desde archivo CSV:");
            inventarioCargado.paraCadaElemento(personaje
                    -> System.out.println(personaje));
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


}
