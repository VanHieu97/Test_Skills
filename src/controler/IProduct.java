package controler;

import java.util.ArrayList;

public interface IProduct<E> {
    void add(E e);
    void edit(String id, E e);
    void delete(String id);
    ArrayList<E> getAllProduct();
    ArrayList<E> findProductByName(String name);
    ArrayList<E> findProductByProductType(String productType);
    ArrayList<E> findProductById(String Id);
}
