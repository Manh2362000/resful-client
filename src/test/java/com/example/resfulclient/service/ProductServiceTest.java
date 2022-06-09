package com.example.resfulclient.service;

import com.example.resfulclient.entity.Product;
import com.example.resfulclient.retrofit.RetrofitGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

class ProductServiceTest {
    ProductService productService = RetrofitGenerator.createService(ProductService.class);

    @Test
    void getProducts() {
        try {
            List<Product> products = productService.getProducts().execute().body();
            for (Product pro : products){
                System.out.println(pro.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getProductDetails() {
        try {
            Product product = productService.getProductDetails(1).execute().body();
            System.out.println(product.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void save() {
        productService.save(new Product(6, "Product 6", new BigDecimal(23)));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}