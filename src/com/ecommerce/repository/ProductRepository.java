package com.ecommerce.repository;

import com.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private  final List<Product> products ;

    public ProductRepository() {
        products = new ArrayList<>();
        initialProducts();

    }

    private void initialProducts() {
        Product product1 = new Product()
                .setId(101).setName("iPhone 14")
                .setMaxRetailPrice(80000).setDiscountPercentage(10.5f)
                .setRating(5).setAvailable(true);

        Product product2 = new Product()
                .setId(102).setName("Samsung Galaxy S22")
                .setMaxRetailPrice(70000).setDiscountPercentage(12.0f)
                .setRating(4).setAvailable(true);

        Product product3 = new Product()
                .setId(103).setName("OnePlus 11")
                .setMaxRetailPrice(65000).setDiscountPercentage(8.5f)
                .setRating(4).setAvailable(true);

        Product product4 = new Product()
                .setId(104).setName("Realme Narzo 60")
                .setMaxRetailPrice(18000).setDiscountPercentage(15.0f)
                .setRating(3).setAvailable(true);

        Product product5 = new Product()
                .setId(105).setName("Redmi Note 12")
                .setMaxRetailPrice(20000).setDiscountPercentage(18.0f)
                .setRating(4).setAvailable(false);

        Product product6 = new Product()
                .setId(106).setName("MacBook Air M2")
                .setMaxRetailPrice(120000).setDiscountPercentage(5.0f)
                .setRating(5).setAvailable(true);

        Product product7 = new Product()
                .setId(107).setName("Dell Inspiron 15")
                .setMaxRetailPrice(55000).setDiscountPercentage(20.0f)
                .setRating(4).setAvailable(true);

        Product product8 = new Product()
                .setId(108).setName("Sony Headphones")
                .setMaxRetailPrice(15000).setDiscountPercentage(25.0f)
                .setRating(5).setAvailable(true);

        Product product9 = new Product()
                .setId(109).setName("Boat Smartwatch")
                .setMaxRetailPrice(5000).setDiscountPercentage(30.0f)
                .setRating(3).setAvailable(true);

        Product product10 = new Product()
                .setId(110).setName("HP Pavilion Laptop")
                .setMaxRetailPrice(75000).setDiscountPercentage(10.0f)
                .setRating(4).setAvailable(false);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        products.add(product10);
    }

    public   List<Product> getAll() {
        return products;
    }

    public  Product getById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

//    update a product

    public Product update(Product product) {
        Product oldProduct = getById(product.getId());
        if (oldProduct != null) {
            int oldProductId = products.indexOf(oldProduct);
            products.set(oldProductId,product);
            return product;
        }
        return null;
    }

         //save and create a product
    public  Product save(Product product) {
        if (getById(product.getId()) != null) {
            return null;
        }
        products.add(product);
        return product;
    }




//     delete Product

    public  void delete(int id) {
        Product product = getById(id);
        if (product != null){
            products.remove(product);
        }

    }


}
