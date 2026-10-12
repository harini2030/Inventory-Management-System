package Src;

import java.util.ArrayList;
import java.util.Scanner;

class Product {

    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        System.out.println(id + " | " + name + " | ₹" + price + " | " + quantity);
    }
}

public class Main {

    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int id = 1;

    static void addProduct() {

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        products.add(new Product(id++, name, price, quantity));

        System.out.println("Product added successfully!");
    }

    static void viewProducts() {

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\nID | Product | Price | Quantity");

        for (Product product : products) {
            product.display();
        }
    }

    static void searchProduct() {

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        boolean found = false;

        for (Product product : products) {

            if (product.name.equalsIgnoreCase(name)) {
                product.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }

    static void updateQuantity() {

        System.out.print("Enter product ID: ");
        int productId = sc.nextInt();

        System.out.print("Enter new quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        for (Product product : products) {

            if (product.id == productId) {
                product.quantity = quantity;
                System.out.println("Quantity updated successfully!");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    static void deleteProduct() {

        System.out.print("Enter product ID: ");
        int productId = sc.nextInt();
        sc.nextLine();

        for (Product product : products) {

            if (product.id == productId) {
                products.remove(product);
                System.out.println("Product deleted successfully!");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Quantity");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    viewProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateQuantity();
                    break;

                case 5:
                    deleteProduct();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
