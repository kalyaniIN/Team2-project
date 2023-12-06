package com.example.produktapi;

import com.example.produktapi.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductTests {

    Product a =new Product("SchoolBag",123.222,"Bag","Adidas","img.jpg");
@Test
public void checkProductTitle(){

    System.out.println(a.getTitle());

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

}
