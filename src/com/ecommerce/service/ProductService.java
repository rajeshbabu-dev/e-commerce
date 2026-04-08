package com.ecommerce.service;

import com.ecommerce.exeption.ProductExistException;
import com.ecommerce.exeption.ProductNotFoundException;
import com.ecommerce.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {

     /* CRUD Methods */

     /* -> Save */
      Product save(Product product) throws ProductExistException;

     /*Find BY Id*/
     Product getById(int id) throws ProductNotFoundException;

     /* Get All */
     List<Product> getAllProducts();

     /* Update */
     Product update(int id, Product product) throws ProductNotFoundException;

     /*Delete*/
     void delete(int id) throws ProductNotFoundException;



// 1 Get all available products based on availability.
     List<Product> getProductsByAvailability(boolean isAvailable);

     /* 2 Get all products belonging to a given category.*/
     List<Product> getProductsByCategory(String category);

     /* 3 Get all products with price greater than a given value*/
     List<Product> getProductsByPriceGreaterThan(int price);

     /* 4 Get names of all products.*/
     List<String> getAllProductsName();

     /* 5 Count how many products are available.*/
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
