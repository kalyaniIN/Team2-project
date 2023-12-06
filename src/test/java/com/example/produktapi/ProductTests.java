package com.example.produktapi;

import com.example.produktapi.model.Product;
import org.junit.jupiter.api.Assertions;




import org.junit.jupiter.api.Test;



public class ProductTests {

    Product product =new Product("SchoolBag",123.222,"Bag","Adidas","img.jpg");
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


}

@Test
    void checkProductId(){
    Product p1= new Product();
    Product p2= new Product();

    p1.setId(1001);
    p2.setId(-777);

    Assertions.assertEquals(1001,p1.getId());
    Assertions.assertEquals(-777,p2.getId());


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
    }

}
