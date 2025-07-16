package main.sweetshop;

import java.util.*;
import main.sweetshop.exception.SweetNotFoundException;


public class SweetShop {
    private final Map<Integer, Sweet> sweetMap = new HashMap<>();

    public void addSweet(Sweet sweet) {
        sweetMap.put(sweet.getId(), sweet);
    }
   
}