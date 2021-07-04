package service;

import bean.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {

    public static void menu() {
        System.out.println("Выберите пункт меню (введите соответствующуу цифру):" +
                "\n 1. показать весь список" +
                "\n 2. показать продукты категории" +
                "\n 4. Добавить продукт");
    }

    public void findAll(ArrayList<Product> list) {
        int i = 0;
        for (Product product : list) {
            System.out.println(++i + ". " + product.getName() +
                    "\n  ID:" + product.getId() +
                    "\n  Категория:" + product.getCategory() +
                    "\n  Цена" + product.getPrice() +
                    "\n________________________");
        }
        menuSelect();
    }

    public void add() {
        Product product = new Product();
        System.out.println("Введите Id");
        int id = readNumber();
        System.out.println("Введите название");
        String name = readString();
        System.out.println("Введите категорию");
        String category = readString();
        System.out.println("Введите цену");
        double price = readDouble();
        product.setId(id);
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        ProductRepository.dataBase().add(product);
        System.out.println("Продукт добавлен");
        menuSelect();
    }

    public void findByCategory() {
        System.out.println("Выберите категорию");
        String category = readString();
        ArrayList<Product> categoryList = new ArrayList<>();
        for (Product product : ProductRepository.dataBase()) {
            if (category.equals(product.getCategory())) {
                categoryList.add(product);
            }
        }
        findAll(categoryList);
    }


    public String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int readNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public double readDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }


    public void menuSelect() {
        menu();
        int select = readNumber();
        switch (select) {
            case 1:
                findAll(ProductRepository.dataBase());
                break;
            case 2:
                findByCategory();
                break;
            case 4:
                add();
                break;
            default:
                System.out.println("Такого пункта нет! Повторите попытку");
                menuSelect();
        }
    }
}
