package pl.javastart.homework.repository;

import org.springframework.stereotype.Repository;
import pl.javastart.homework.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
    }

    public List<Product> getProductsList (){
        return products;
    }

    public ProductRepository(List<Product> products) {
        this.products = products;
    }

    public void addProduct (Product product){
        products.add(product);
    }

    public double getPriceSum (){
        double result = 0;
        for (Product product : products){
            result += product.getPrice();
        }
        return result;
    }


}
