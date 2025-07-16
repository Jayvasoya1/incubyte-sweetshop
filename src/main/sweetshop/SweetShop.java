package main.sweetshop;

import java.util.*;
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
   
}