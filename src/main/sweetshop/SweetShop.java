package main.sweetshop;

import java.util.*;
import java.util.stream.Collectors;

import main.sweetshop.exception.InsufficientStockException;
import main.sweetshop.exception.SweetNotFoundException;


public class SweetShop {
    private final Map<Integer, Sweet> sweetMap = new HashMap<>();

    public void addSweet(Sweet sweet) {
        sweetMap.put(sweet.getId(), sweet);
    }

    // Delete a sweet if present, otherwise throw error
    public void deleteSweet(int id) {
        if (!sweetMap.containsKey(id)) {
            throw new SweetNotFoundException("Sweet with ID " + id + " not found.");
        }
        sweetMap.remove(id);
    }

     // Return all sweets as a list
    public List<Sweet> getAllSweets() {
        return new ArrayList<>(sweetMap.values());
    }

    // Find sweet by its ID
    public Sweet findById(int id) {
        Sweet sweet = sweetMap.get(id);
        if (sweet == null) {
            throw new SweetNotFoundException("Sweet with ID " + id + " not found.");
        }
        return sweet;
    }

    // search sweets by name (case-insensitive)
     public List<Sweet> searchByName(String name) {
        return sweetMap.values().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                 .collect(Collectors.toList());
    }

     // Search sweets by category
    public List<Sweet> searchByCategory(String category) {
        return sweetMap.values().stream()
                .filter(s -> s.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Search sweets between min and max price
    public List<Sweet> searchByPriceRange(double min, double max) {
        return sweetMap.values().stream()
                .filter(s -> s.getPrice() >= min && s.getPrice() <= max)
                .collect(Collectors.toList());
    }

    // Buy sweets if enough quantity is available
    public void purchaseSweet(int id, int quantity) {
        Sweet sweet = findById(id);
        if (sweet.getQuantity() < quantity) {
            throw new InsufficientStockException("Not enough stock for sweet ID " + id);
        }
        sweet.setQuantity(sweet.getQuantity() - quantity);  // reduce stock
    }

    




      
   
}