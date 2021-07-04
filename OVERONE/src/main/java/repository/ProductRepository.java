package repository;

import bean.Product;

import java.util.ArrayList;

public class ProductRepository {

   static ArrayList<Product> productList = new ArrayList<>();

    public static ArrayList<Product> dataBase (){
        return productList;
    }

    static
    {
        productList.add(new Product(1, "Фрукты", "Яблоки", 5.0));
        productList.add(new Product(2, "Ягоды", "Малина", 5.0));
        productList.add(new Product(3, "Фрукты", "Бананы", 5.0));
        productList.add(new Product(4, "Овощи", "Огурец", 5.0));
        productList.add(new Product(4, "Овощи", "Огурец", 5.0));
        productList.add(new Product(5, "Фрукты", "Ананас", 5.0));
    }
}
