package main.sweetshop;

import java.util.*;
import java.util.stream.Collectors;

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




      
   
}