package com.todo.list.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.todo.list.web.entyti.Product;

@Named
@ApplicationScoped
public class ProductService {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1000, "f230fh0g3", "Bamboo Watch", "Product Description", "bamboo-watch.jpg", 65,
                "Accessories", 24, 5));
        products.add(new Product(1001, "nvklal433", "Black Watch", "Product Description", "black-watch.jpg", 72,
                "Accessories", 61, 4));
        products.add(new Product(1002, "zz21cz3c1", "Blue Band", "Product Description", "blue-band.jpg", 79,
                "Fitness", 2, 3));
        products.add(new Product(1003, "244wgerg2", "Blue T-Shirt", "Product Description", "blue-t-shirt.jpg", 29,
                "Clothing", 25, 5));

    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> getProducts(int size) {

        if (size > products.size()) {
            Random rand = new Random();

            List<Product> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(products.size());
                randomList.add(products.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(products.subList(0, size));
        }

    }

    public List<Product> getClonedProducts(int size) {
        List<Product> results = new ArrayList<>();
        List<Product> originals = getProducts(size);
        for (Product original : originals) {
            results.add(original.clone());
        }
        return results;
    }
}
