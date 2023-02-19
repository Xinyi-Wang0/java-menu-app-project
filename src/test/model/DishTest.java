package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DishTest {
    Dish testDish;

    @BeforeEach
    public void setup() {
        this.testDish = new Dish("Burger", "wheat flour, tomato, egg", 10);
    }

    @Test
    public void testConstructor() {
        assertEquals("Burger", testDish.getName());
        assertEquals("wheat flour, tomato, egg", testDish.getIngredients());
        assertEquals(10, testDish.getPrice());
    }

    @Test
    public void testGetDish() {
        assertEquals("Name:Burger; Ingredients:wheat flour, tomato, egg; Price: 10", testDish.getDish());
    }


}