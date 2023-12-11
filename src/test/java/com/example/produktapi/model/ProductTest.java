package com.example.produktapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ProductTest {
    // Create a Product instance
    Product product =new Product("SchoolBag",123.222,"Bag","Adidas","img.jpg");

    @Test
    public void testGetTitle() {
        // Use the getTitle method and assert the result
        String productTitle = product.getTitle();
        assertEquals("SchoolBag", productTitle);
    }
    @Test
    public void testSetTitle() {
        System.out.println("Original Title: " + product.getTitle());
        // Set a new title using the setTitle method
        String newTitle = "UnicornBag";
        product.setTitle(newTitle);

        String productTitle = product.getTitle();

        System.out.println("Updated Title: " + productTitle);
        // Use the getTitle method to get the updated title and assert the result
        assertEquals("UnicornBag", productTitle);
    }
    @Test
    public void testGetImage() {
        String productImage = product.getImage();
        // Use the getImage method and assert the result
        assertEquals("img.jpg", productImage);
    }
    @Test
    public void testSetImage() {
        // Print the original image
        System.out.println("Original Image: " + product.getImage());

        // Set a new image using the setImage method
        String newImage = "new-image.jpg";
        product.setImage(newImage);

        String productImage = product.getImage();

        // Print the updated image
        System.out.println("Updated Image: " + productImage);

        // Use the getImage method to get the updated image and assert the result
        assertEquals("new-image.jpg", productImage);
    }
  
}