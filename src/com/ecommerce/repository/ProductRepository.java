package com.ecommerce.repository;

import com.ecommerce.model.Product;
import com.ecommerce.util.CsvParser;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
     private final List<Product> products;


    public ProductRepository() throws IOException {
        CsvParser csvParser = new CsvParser();
        products = csvParser.getProductsFromCsv();
    }

    public Product save(Product product) {
        this.products.add(product);
        return product;
    }

    public Optional<Product> getById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }
    public List<Product> getAll() {
        return products;
    }
//    update a product
    public Product update(int id , Product product) {
        this.products.replaceAll(p ->  p.getId() == id ?  product : p);
        return product;
    }

//    delete a product
    public boolean delete(int id) {
        this.products.removeIf(product -> product.getId() == id);
        return true;
    }


}
