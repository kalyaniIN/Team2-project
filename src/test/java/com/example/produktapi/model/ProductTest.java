package com.example.produktapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ProductTest {
    // Create a Product instance
    Product product = new Product("Test Product", 29.99, "Electronics", "A test product", "test-image.jpg");

    @Test
    public void testGetTitle() {
        // Use the getTitle method and assert the result
        assertEquals("Test Product", product.getTitle());
    }
    @Test
    public void testSetTitle() {
        // Create a Product instance
        Product product = new Product("Old Title of bag", 35.55, "accessories", "A sample product", "sample-image.jpg");
        System.out.println("Original Title: " + product.getTitle());
        // Set a new title using the setTitle method
        product.setTitle("New Title of bag");

        System.out.println("Updated Title: " + product.getTitle());
        // Use the getTitle method to get the updated title and assert the result
        assertEquals("New Title of bag", product.getTitle());
    }
    @Test
    public void testGetImage() {
        // Use the getImage method and assert the result
        assertEquals("test-image.jpg", product.getImage());
    }
    @Test
    public void testSetImage() {
        // Create a Product instance with an initial image
        Product product = new Product("Test Product of shirt", 99.99, "Clothing", "A test product", "initial-image.jpg");

        // Print the original image
        System.out.println("Original Image: " + product.getImage());

        // Set a new image using the setImage method
        product.setImage("new-image.jpg");

        // Print the updated image
        System.out.println("Updated Image: " + product.getImage());

        // Use the getImage method to get the updated image and assert the result
        assertEquals("new-image.jpg", product.getImage());
    }
  
}