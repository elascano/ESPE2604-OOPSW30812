
package ec.edu.espe.librarysystem.model.interfaces;
import java.util.List;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 * @param <T>
 */

public interface IManageable<T> {
    void add(T element);
    void remove(String id);
    T find(String id);
    List<T> findAll();
    void update(T element);
}
