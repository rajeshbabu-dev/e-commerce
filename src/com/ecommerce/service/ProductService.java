package com.ecommerce.service;

import com.ecommerce.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {

     List<Product> getProductsByAvailability(boolean isAvailable);
     List<Product> getProductsByCategory(String category);
     List<Product> getProductsByPriceGreaterThan(int price);
     /*Get names of all products.*/
     List<String> getAllProductsName();

     /*Count how many products are available.*/
     long getAvailableProductsCount();

     /*6 Check if there is any product from a given company.
          existsByCompanyName */

     boolean isProductAvailableFromCompany(String companyName);

     /*7. Check if all products are available
     allProductsAvailable */

     boolean allProductsAvailable();

/* 8 Get the first product safely.*/
     Optional<Product> getFirstProduct();

     /*9 Get all unique categories.*/

     List<String> getAllUniqueCategories();

     /* 9 Get top N most expensive products.*/
     List<Product> getExpensiveProducts(int limit);

     /*10 Sort products by price in ascending order.*/

     List<Product> getProductsByPriceAscending();

     /*11 Sort products by name in descending order.*/
     List<Product> getProductsByNameDescending();

     /*12 Get total inventory value (sum of all product prices).*/
     double calculateTotalInventoryValue();

     /*13 Get all products manufactured after a given year.*/
     List<Product> getProductsManufacturedAfter(int year);

     /*14Get all products that are:
        - available
        - and price greater than a given value*/

     List<Product> getAllAvailableProductsGreaterThan(int price);

     /*15Count number of products in each category.*/
     Map<String, Long> getProductsCountByCategory();





}
