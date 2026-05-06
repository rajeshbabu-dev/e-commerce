package com.ecommerce.util;

import com.ecommerce.enums.*;
import com.ecommerce.model.Address;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Order;
import com.ecommerce.model.Product;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
/* Method to convert products.csv file into list of products
* Method name
* arguments
* return type
* access modifiers
* */

    public List<Product> getProductsFromCsv() throws IOException {
        List<Product> products = new ArrayList<>();
        File file = new File("D:/Downloads/products.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        String productData = br.readLine();

        while (productData != null) {
            String[] Split = productData.split(",");
            Product product = new Product();
            product.setId(Integer.parseInt(Split[0]))
                    .setName(Split[1])
                    .setMaxRetailPrice(Integer.parseInt(Split[2]))
                    .setDiscountPercentage(Float.parseFloat(Split[3]))
                    .setAvailable(Boolean.parseBoolean(Split[4]))
                    .setCompany(Split[5])
                    .setCategory(Split[6])
                    .setManufacturedYear(Integer.parseInt(Split[7]));
            products.add(product);
            productData = br.readLine();


        }return products;

    }

    public List<Customer> getCustomersFromCsv() throws IOException {
        List<Customer> customers = new ArrayList<>();
        File file = new File("D:/Downloads/customers.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        String customerData = br.readLine();

        while (customerData != null) {
            String[] Split = customerData.split(",");
            Address residential = parseAddress(Split[7]);
            Address shipping = parseAddress((Split[8]));
            Customer customer = new Customer();
            customer.setId(Integer.parseInt(Split[0]))
                    .setName(Split[1])
                    .setEmail(Split[2])
                    .setAge(Integer.parseInt(Split[3]))
                    .setGender(Gender.valueOf(Split[4].trim().toUpperCase()))
                    .setStatus(Status.valueOf(Split[5].trim().toUpperCase()))
                    .setMembershipType(Membership.valueOf(Split[6].trim().toUpperCase()))
                    .setResdentialAddress(residential)
                    .setShippingAddress(shipping);
            customers.add(customer);
            customerData = br.readLine();

        }
        return customers;
    }
    public Address parseAddress(String address) {
        String[] Split = address.split("\\|");
        Address address1 = new Address();
        address1.setHouseNo(Split[0].trim())
                .setStreet(Split[1].trim())
                .setArea(Split[2].trim())
                .setCity(Split[3].trim())
                .setPincode(Integer.parseInt(Split[4].trim()));
        return address1;
    }

    public List<Order> getOrdersFromCsv() throws IOException {
        List<Order> orders = new ArrayList<>();
        File file = new File("/Users/VISHU/vishu/orders.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String orderData = br.readLine();
            while (orderData != null) {
                String[] split = orderData.split(",");

                Order order = new Order()
                        .setId(Integer.parseInt(split[0].trim()))
                        .setStatus(OrderStatus.valueOf(split[1].trim().toUpperCase()))
                        .setPaymentMethod(PaymentMethod.valueOf(split[2].trim().toUpperCase()));

                orders.add(order);
                orderData = br.readLine();
            }
        }
        return orders;
    }

}
