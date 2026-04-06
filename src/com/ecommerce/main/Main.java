package com.ecommerce.main;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

import java.util.List;

public class Main {
    static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        List<Product> products = productRepository.getAll();
        System.out.println("Default list of products:");
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println();
        System.out.println(productRepository.getById(110));
        System.out.println();

        System.out.println(productRepository.update(new Product().setId(106).setName("Gaming Laptop").setMaxRetailPrice(98900).setDiscountPercentage(21.5f).setAvailable(true)));

        System.out.println();

        productRepository.save(new Product().setId(109).setName("Mobile charger").setMaxRetailPrice(5999).setDiscountPercentage(14.5f).setAvailable(true));
        productRepository.save(new Product().setId(111).setName("Mobile charger").setMaxRetailPrice(5999).setDiscountPercentage(14.5f).setAvailable(true));


        System.out.println();

        productRepository.delete(108);
        System.out.println();
        System.out.println("After list manipulation:");

        for (Product product : products) {
            System.out.println(product);
        }


    }
}
