package test.sweetshop;

import main.sweetshop.SweetShop;
import main.sweetshop.exception.SweetNotFoundException;
import main.sweetshop.Sweet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;


public class SweetShopTest {

    @Test
    void testAddAndFindSweet() {
        // create a new sweet shop
        SweetShop shop = new SweetShop();

        // add a sweet to the shop
        Sweet sweet = new Sweet(1001, "Kaju Katli", "Nut-Based", 50.0, 20);
        shop.addSweet(sweet);

        // try to find it by ID and check the name
        Sweet result = shop.findById(1001);
        assertEquals("Kaju Katli", result.getName());
    }

    @Test
    void testDeleteSweet() {
        // add a sweet and delete it
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 10));
        shop.deleteSweet(1001);

        // try to find it now, should throw an exception
        assertThrows(SweetNotFoundException.class, () -> shop.findById(1001));
    }

    @Test
    void testSearchByName() {
        // add a sweet and search by name
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1, "Barfi", "Milk", 20, 5));

        // should return 1 sweet with that name
        List<Sweet> result = shop.searchByName("Barfi");
        assertEquals(1, result.size());
    }

    @Test
    void testSearchByCategory() {
        // add two sweets in the same category
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1, "Candy", "Sugar", 10, 10));
        shop.addSweet(new Sweet(2, "Toffee", "Sugar", 15, 5));

        // search by category should return both
        List<Sweet> result = shop.searchByCategory("Sugar");
        assertEquals(2, result.size());
    }

    @Test
    void testSearchByPriceRange() {
        // add a sweet with price in given range
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1, "Choco", "Choco", 30, 5));

        // search within price range
        List<Sweet> result = shop.searchByPriceRange(20, 40);
        assertEquals(1, result.size());
    }

    @Test
    void testPurchaseAndRestock() {
        // add a sweet and purchase some
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1001, "Ladoo", "Sweet", 25, 10));
        shop.purchaseSweet(1001, 5);

        // quantity should be reduced
        assertEquals(5, shop.findById(1001).getQuantity());

        // restock it and check again
        shop.restockSweet(1001, 10);
        assertEquals(15, shop.findById(1001).getQuantity());
    }

    
   
    
}