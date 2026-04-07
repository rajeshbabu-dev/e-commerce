package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsByAvailability(boolean isAvailable){
        return productRepository.getAll().stream()
                .filter(Product::isAvailable)
                .toList();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getAll().stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();
    }

    @Override
    public List<Product> getProductsByPriceGreaterThan(int price) {
        return productRepository.getAll().stream()
                .filter(product -> product.getMaxRetailPrice() > price)
                .toList();


    }

    @Override
    public List<String> getAllProductsName() {
        return productRepository.getAll().stream()
                .map(Product::getName)
                .toList();
    }

    @Override
    public long getAvailableProductsCount() {
        return productRepository.getAll().stream()
                .filter(Product::isAvailable)
                .count();

    }

    @Override
    public boolean isProductAvailableFromCompany(String companyName) {
        return productRepository.getAll().stream()
                .anyMatch(product1 -> product1.getCompany().equals(product1.getCompany()) );
    }

    @Override
    public boolean allProductsAvailable() {
        return productRepository.getAll().stream()
                .allMatch(Product::isAvailable);

    }

    @Override
    public Optional<Product> getFirstProduct() {
        return productRepository.getAll().stream()
                .findFirst();
    }


    @Override
    public List<String> getAllUniqueCategories() {
        return productRepository.getAll().stream()
                .map(Product::getCategory)
                .distinct()
                .toList();

    }

    @Override
    public List<Product> getExpensiveProducts(int limit) {
        return productRepository.getAll().stream()
                .sorted((a,b) ->Double.compare(b.getMaxRetailPrice(),a.getMaxRetailPrice()))
                .limit(limit)
                .toList();
    }

    @Override
    public List<Product> getProductsByPriceAscending() {
        return productRepository.getAll().stream()
                .sorted((Product a,Product b) -> Double.compare(a.getMaxRetailPrice(),b.getMaxRetailPrice()))
                .toList();


    }

    @Override
    public List<Product> getProductsByNameDescending() {
        return productRepository.getAll().stream()
                .sorted(Comparator.comparing(Product -> Product.getName().toLowerCase(), Comparator.reverseOrder()))
                .toList();
    }

    @Override
    public double calculateTotalInventoryValue() {
        return productRepository.getAll().stream()
                .collect(Collectors.summingDouble(Product::getMaxRetailPrice));

    }

    @Override
    public List<Product> getProductsManufacturedAfter(int year) {
        return productRepository.getAll().stream()
                .filter(Product -> Product.getManufacturedYear() > year)
                .toList();

    }

    @Override
    public List<Product> getAllAvailableProductsGreaterThan(int price) {
        return productRepository.getAll().stream()
                .filter(product -> product.getMaxRetailPrice() > price)
                .toList();
    }

    @Override
    public Map<String, Long> getProductsCountByCategory() {
        return productRepository.getAll().stream()
                .collect(Collectors.groupingBy(Product::getCategory,Collectors.counting()));
    }


}



