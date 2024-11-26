
package videojuegos;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public interface Jugable<T> extends Iterable<T> {
    void agregar(T item);
    void paraCadaElemento(Consumer<? super T> accion);
    Iterator<T> iterator();
    List<T> filtrar(Predicate<? super T> criterio);
    List<T> transformar(Function <? super T, ? extends T> transformacion);
    
}
