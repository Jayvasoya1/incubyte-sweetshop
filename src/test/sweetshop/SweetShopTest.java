package test.sweetshop;

import main.sweetshop.SweetShop;
import main.sweetshop.Sweet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
   
    
}