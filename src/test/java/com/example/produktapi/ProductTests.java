package com.example.produktapi;

import com.example.produktapi.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class ProductTests {
Product product =new Product("SchoolBag",123.222,"Bag","Adidas","img.jpg");
    // Suzana. Testing Get Description. Positive testing.
    
    @Test
public void checkProductDescription(){
    Assertions.assertEquals("Adidas", product.getDescription());

}
    // Suzana. Testing Get Description. Negative testing.
    @Test
    public void checkProductDescription2(){
        Assertions.assertNotEquals("123456", product.getDescription());

    }
//Suzana. Testing setting a new Description of a Product.
    @Test
    public void AddNewProductDescription() {
    product.setDescription("A new bracelet");
    Assertions.assertEquals("A new bracelet", product.getDescription());
    }


    //Product product =new Product("SchoolBag",123.222,"Bag","Adidas","img.jpg");
    @Test
    public void checkProductCategory(){
        //Get the category.
        String productCategory = product.getCategory();
        // check the category is correct.
        Assertions.assertEquals("Bag", productCategory);
    }
    @Test
    public void setNewCategoryAndCheckThatNewCategoryRetuns(){
        //Declare and set a new category to an existing category.
        String newCategory = "Backpack";
        product.setCategory(newCategory);
        //Get the new category.
        String productCategory = product.getCategory();
        // check the category is correct.
        Assertions.assertEquals(newCategory, productCategory);
    }
    @Test
    public void checkProductPrice(){
        //Get the price.
        Double productPrice = product.getPrice();
        // check the price is correct.
        Assertions.assertEquals(123.222, productPrice);
    }

@Test
    void checkProductId(){
    Product products= new Product();
    
    products.setId(1001);
    Assertions.assertEquals(1001,products.getId());
    
    products.setId(-777);
    Assertions.assertEquals(-777,products.getId());

    }

    @Test
    public void setNewPriceAndCheckThatNewPriceReturns(){
        //Declare and set a new price to an existing price.
        Double newPrice = 109.99;
        product.setPrice(newPrice);
        //Get the new price.
        Double productPrice = product.getPrice();
        // check the price is correct.
        Assertions.assertEquals(newPrice, productPrice);
    }    @Test
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
