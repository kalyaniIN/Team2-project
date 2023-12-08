package com.example.produktapi;

import com.example.produktapi.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTests {
    // Suzana. Testing Get Description. Positive testing.
    Product product =new Product("SchoolBag",123.222,"Bag","Adidas","img.jpg");
    @Test
public void checkProductDescription(){
    Assertions.assertEquals("Adidas", product.getDescription());

}
    // Suzana. Testing Get Description. Negative testing.
    @Test
    public void checkProductDescription2(){
        Assertions.assertNotEquals("123456", product.getDescription());

    }
///Suzana. Testing setting a new Description of a Product.
    @Test
    public void AddNewProductDescription() {
    product.setDescription("A new bracelet");
    Assertions.assertEquals("A new bracelet", product.getDescription());
    }
}
