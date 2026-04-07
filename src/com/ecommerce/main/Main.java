package com.ecommerce.main;

import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.ProductServiceImpl;

import java.io.IOException;

public class Main {
    static void main(String[] args) throws IOException {
//        ProductRepository productRepository = new ProductRepository();
//        List<Product> products = productRepository.getAll();
//        System.out.println("Default list of products:");
//        for (Product product : products) {
//            System.out.println(product);
//        }
//
//        System.out.println();
//        System.out.println(productRepository.getById(110));
//        System.out.println();
//
//        System.out.println(productRepository.update(new Product().setId(106).setName("Gaming Laptop").setMaxRetailPrice(98900).setDiscountPercentage(21.5f).setAvailable(true)));
//
//        System.out.println();
//
//        productRepository.save(new Product().setId(109).setName("Mobile charger").setMaxRetailPrice(5999).setDiscountPercentage(14.5f).setAvailable(true));
//        productRepository.save(new Product().setId(111).setName("Mobile charger").setMaxRetailPrice(5999).setDiscountPercentage(14.5f).setAvailable(true));
//
//
//        System.out.println();
//
//        productRepository.delete(108);
//        System.out.println();
//        System.out.println("After list manipulation:");
//
//        for (Product product : products) {
//            System.out.println(product);
//        }


        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductServiceImpl(productRepository);

        System.out.println(productService.getProductsByAvailability(true));

        System.out.println(productService.getProductsByCategory("Electronics"));
        System.out.println(productService.getProductsByPriceGreaterThan(5000));
        System.out.println(productService.getAllProductsName());
        System.out.println(productService.getAvailableProductsCount());

        System.out.println(productService.isProductAvailableFromCompany("apple"));

        System.out.println(productService.allProductsAvailable());

        System.out.println(productService.getFirstProduct());

        System.out.println(productService.getAllUniqueCategories());

        System.out.println(productService.getExpensiveProducts(2));

        System.out.println(productService.getProductsByPriceAscending());

        System.out.println("--------");

        System.out.println(productService.getProductsByNameDescending());
        System.out.println();

        System.out.println(productService.calculateTotalInventoryValue());

        System.out.println(productService.getProductsManufacturedAfter(2023));

        System.out.println("-----");
        System.out.println(productService.getAllAvailableProductsGreaterThan(100000));
        System.out.println("------------------------------");
        System.out.println(productService.getProductsCountByCategory());


    }
}
