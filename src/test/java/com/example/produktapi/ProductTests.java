package com.example.produktapi;

import com.example.produktapi.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductTests {
Product product =new Product("SchoolBag",123.222,"Bag","Adidas","img.jpg");
    // Suzana. Testing Get Description. Positive testing.
    
    //Suzana
    @Test
    public void checkProductDescription(){
        assertEquals("Adidas", product.getDescription());

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
        assertEquals("A new bracelet", product.getDescription());
    }
    //Faisal Farman
    @Test
    public void checkProductCategory(){
        //Get the category.
        String productCategory = product.getCategory();
        // check the category is correct.
        assertEquals("Bag", productCategory);
    }
    //Faisal Farman
    @Test
    public void setNewCategoryAndCheckThatNewCategoryRetuns(){
        //Declare and set a new category to an existing category.
        String newCategory = "Backpack";
        product.setCategory(newCategory);
        //Get the new category.
        String productCategory = product.getCategory();
        // check the category is correct.
        assertEquals(newCategory, productCategory);
    }
    //Faisal Farman
    @Test
    public void checkProductPrice(){
        //Get the price.
        Double productPrice = product.getPrice();
        // check the price is correct.
        assertEquals(123.222, productPrice);
    }

    //Uma
    @Test
    void checkProductId(){
    Product products= new Product();
    
    products.setId(1001);
    assertEquals(1001,products.getId());
    
    products.setId(-777);
    assertEquals(-777,products.getId());
    }

    //Faisal Farman
    @Test
    public void setNewPriceAndCheckThatNewPriceReturns(){
        //Declare and set a new price to an existing price.
        Double newPrice = 109.99;
        product.setPrice(newPrice);
        //Get the new price.
        Double productPrice = product.getPrice();
        // check the price is correct.
        assertEquals(newPrice, productPrice);
    }

    //Kalyani
    @Test
    public void testGetTitle() {
        // Use the getTitle method and assert the result
        String productTitle = product.getTitle();
        assertEquals("SchoolBag", productTitle);
    }

    //Kalyani
    @Test
    public void testSetTitle() {
        // Set a new title using the setTitle method
        String newTitle = "UnicornBag";
        product.setTitle(newTitle);

        String productTitle = product.getTitle();

        // Use the getTitle method to get the updated title and assert the result
        assertEquals("UnicornBag", productTitle);
    }

    //Kalyani
    @Test
    public void testGetImage() {
        String productImage = product.getImage();
        // Use the getImage method and assert the result
        assertEquals("img.jpg", productImage);
    }

    //Kalyani
    @Test
    public void testSetImage() {

        // Set a new image using the setImage method
        String newImage = "new-image.jpg";
        product.setImage(newImage);

        String productImage = product.getImage();

        // Use the getImage method to get the updated image and assert the result
        assertEquals("new-image.jpg", productImage);
    }

}
