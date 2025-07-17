package main.sweetshop;

import main.sweetshop.exception.SweetNotFoundException;
import main.sweetshop.exception.InsufficientStockException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SweetShop shop = new SweetShop();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Sweet Shop Menu ---");
            System.out.println("1. Add Sweet");
            System.out.println("2. Delete Sweet");
            System.out.println("3. View All Sweets");
            System.out.println("4. Find Sweet by ID");
            System.out.println("5. Search by Name");
            System.out.println("6. Search by Category");
            System.out.println("7. Search by Price Range");
            System.out.println("8. Purchase Sweet");
            System.out.println("9. Restock Sweet");
            System.out.println("10. Sort by Name");
            System.out.println("11. Sort by Price");
            System.out.println("12. Sort by Quantity");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  
            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Category: ");
                        String category = sc.nextLine();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        shop.addSweet(new Sweet(id, name, category, price, qty));
                        System.out.println("Sweet added successfully.");
                    }
                    case 2 -> {
                        System.out.print("Enter sweet ID to delete: ");
                        int id = sc.nextInt();
                        shop.deleteSweet(id);
                        System.out.println("Sweet deleted.");
                    }
                    case 3 -> {
                        List<Sweet> sweets = shop.getAllSweets();
                        sweets.forEach(System.out::println);
                    }
                    case 4 -> {
                        System.out.print("Enter sweet ID: ");
                        int id = sc.nextInt();
                        System.out.println(shop.findById(id));
                    }
                    case 5 -> {
                        System.out.print("Enter sweet name: ");
                        String name = sc.nextLine();
                        shop.searchByName(name).forEach(System.out::println);
                    }
                    case 6 -> {
                        System.out.print("Enter category: ");
                        String category = sc.nextLine();
                        shop.searchByCategory(category).forEach(System.out::println);
                    }
                    case 7 -> {
                        System.out.print("Min Price: ");
                        double min = sc.nextDouble();
                        System.out.print("Max Price: ");
                        double max = sc.nextDouble();
                        shop.searchByPriceRange(min, max).forEach(System.out::println);
                    }
                    case 8 -> {
                        System.out.print("Enter sweet ID to purchase: ");
                        int id = sc.nextInt();
                        System.out.print("Quantity to purchase: ");
                        int qty = sc.nextInt();
                        shop.purchaseSweet(id, qty);
                        System.out.println("Purchase successful.");
                    }
                    case 9 -> {
                        System.out.print("Enter sweet ID to restock: ");
                        int id = sc.nextInt();
                        System.out.print("Quantity to add: ");
                        int qty = sc.nextInt();
                        shop.restockSweet(id, qty);
                        System.out.println("Restock successful.");
                    }
                    case 10 -> shop.sortByName().forEach(System.out::println);
                    case 11 -> shop.sortByPrice().forEach(System.out::println);
                    case 12 -> shop.sortByQuantity().forEach(System.out::println);
                    case 0 -> System.out.println("Exiting... Thank you!");
                    default -> System.out.println("Invalid option.");
                }
            } catch (SweetNotFoundException | InsufficientStockException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);
    }
}