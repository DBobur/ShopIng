package shop.service;

import shop.model.Product;

import java.util.Arrays;

public class ProductService {
    static Product[] products = new Product[100];
    static int count = 0;
    static long idGeneration = 0L;
    public boolean add(Product product){
        product.setId(idGeneration++);
        products[count++] = product;
        return true;
    }

    public Product[] show(Long id) {
        Product[] products1 = new  Product[count];
        int i = 0;
        for (int j = 0; j < count; j++) {
            if(products[j].getOwnerId().equals(id)){
                products1[i++] = products[j];
            }
        }
        return Arrays.copyOf(products1,i);
    }

    public boolean delete(Long id, int number) {
        Product[] products1 = show(id);
        for (int i = 0; i < count; i++) {
            if(products1[number-1].getId().equals(products[i].getId())){
                for (int j = i; j < count-1; j++) {
                    products[j] = products[j+1];
                }
                count--;
                return true;
            }
        }
        return false;
    }

    public void ShowList() {
        int j = 1;
        for (int i = 0; i < count; i++) {
            System.out.println((j++)+" "+products[i].toString());
        }
    }

    public Product buy(int i) {
        return products[i-1];
    }
}
