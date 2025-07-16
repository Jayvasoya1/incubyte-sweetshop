package test.sweetshop;

import main.sweetshop.SweetShop;
import main.sweetshop.exception.SweetNotFoundException;
import main.sweetshop.Sweet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
   
    
}