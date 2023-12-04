package com.example.produktapi;

import com.example.produktapi.model.Product;
import org.junit.jupiter.api.Test;

public class ProductTests {

    Product a =new Product("SchoolBag",123.222,"Bag","Adidas","img.jpg");
@Test
public void checkProductTitle(){

    System.out.println(a.getTitle());

}
}
