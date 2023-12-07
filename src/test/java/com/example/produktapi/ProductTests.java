package com.example.produktapi;

import com.example.produktapi.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTests {

    Product product =new Product("Bracelet",123.222,"Jewelery","Silver dragon bracelet","img.jpg");//
    // Suzana. Testing Get Description. Positive testing.
    @Test
public void checkProductDescription(){
    Assertions.assertEquals("Silver dragon bracelet", product.getDescription());

}
    // Suzana. Testing Get Description. Negative testing.
    @Test
    public void checkProductDescription2(){
        Assertions.assertEquals("123456", product.getDescription());

    }
///Suzana. Testing setting a new Description of a Product.
    @Test
    public void AddNewProductDescription() {
    product.setDescription("A new bracelet");
    Assertions.assertEquals("A new bracelet", product.getDescription());
    }
}
