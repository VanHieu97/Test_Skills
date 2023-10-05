package model;

import controler.IProduct;
import controler.ReadAndWrite;

import java.util.ArrayList;

public class ManagerProduct implements IProduct<Product> {
    public ArrayList<Product> listProduct;
    private ReadAndWrite readAndWrite;


    public ManagerProduct() {
        readAndWrite = new ReadAndWrite();
        this.listProduct = readAndWrite.ReadFile();
    }

    @Override
    public void add(Product product) {
        listProduct.add(product);
        readAndWrite.WriteFile(listProduct);
    }

    @Override
    public void edit(String id, Product product) {
        for (int i = 0; i < listProduct.size(); i++) {
            if(listProduct.get(i).getId().equals(id)){
                listProduct.set(i,product);
            }
        }
        readAndWrite.WriteFile(listProduct);
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if(listProduct.get(i).getId().equals(id)){
                listProduct.remove(i);
            }
        }
        readAndWrite.WriteFile(listProduct);
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return listProduct;
    }

    @Override
    public ArrayList<Product> findProductByName(String name) {
        ArrayList<Product> listProductByName = new ArrayList<>();
        for (int i = 0; i < listProduct.size(); i++) {
            if(listProduct.get(i).getNameProduct().toLowerCase().contains(name.toLowerCase())){
                listProductByName.add(listProduct.get(i));
            }
        }
        return listProductByName;
    }

    @Override
    public ArrayList<Product> findProductByProductType(String productType) {
        ArrayList<Product> listProductByType = new ArrayList<>();
        for (Product product: listProduct) {
            if(product.getProductType().equals(productType)){
                listProductByType.add(product);
            }
        }
        return listProductByType;
    }

    @Override
    public ArrayList<Product> findProductById(String Id) {
        ArrayList<Product> listProductById = new ArrayList<>();
        for (Product product: listProduct) {
            if(product.getId().equals(Id)){
                listProductById.add(product);
            }
        }
        return listProductById;
    }
    public int findIndex(String id){
        for (int i = 0; i < listProduct.size(); i++) {
            if(listProduct.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
