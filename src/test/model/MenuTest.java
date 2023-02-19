package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    Menu menu;
    Dish dish1;
    Dish dish2;

    @BeforeEach
    public void setup() {
        this.menu = new Menu();
        this.dish1 = new Dish("Spaghetti", "flour,tomato,beef,oil", 20);
        this.dish2 = new Dish("salad", "tomato, lettuce, basil, kale", 30);
    }

    @Test
    void testAddDish() {
        assertEquals(0,menu.size());
        menu.addDish(dish1);
        assertEquals(1,menu.size());
        assertTrue(menu.contains(dish1));
        menu.addDish(dish2);
        assertEquals(2,menu.size());
        assertTrue(menu.contains(dish2));
    }

    @Test
    public void testRemoveDish() {
        assertEquals(menu.size(), 0);
        menu.addDish(dish1);
        assertEquals(menu.size(), 1);
        assertTrue(menu.contains(dish1));
        menu.removeDish(dish1);
        assertEquals(menu.size(), 0);
        assertFalse(menu.contains(dish1));
    }

    @Test
    public void testDeleteDish() {
        menu.addDish(dish1);
        menu.addDish(dish2);
        List<Dish> dishes = menu.allDishes();
        menu.deleteDish("salad");
        assertEquals(dish1, dishes.get(0));
        assertFalse(menu.contains(dish2));
        String result = menu.deleteDish("salad");
        String expect = "Fail to remove dish.";
        assertEquals(expect,result);
    }

    @Test
    public void testGetDishesDetails() {
        menu.addDish(dish1);
        menu.addDish(dish2);
        List<Dish> dishes = menu.allDishes();
        menu.getDishesDetails("salad");
        assertEquals(dish2, dishes.get(1));


    }

    @Test
    public void testGetAllDishes() {
        menu.addDish(dish1);
        menu.addDish(dish2);
        List<Dish> dishes = menu.allDishes();
        assertEquals(dish1, dishes.get(0));
        assertEquals(dish2, dishes.get(1));
        assertEquals(2, menu.size());
        assertFalse(menu.contains(new Dish("a","abc",10)));
        assertEquals("not available", menu.getDishesDetails("A"));

    }

    @Test
    public void testViewAllDishes() {
        assertEquals("List of Dishes: empty", menu.viewAllDish());
        menu.addDish(dish1);
        menu.addDish(dish2);
        String result = menu.viewAllDish();
        String expected = "List of Dishes: \n" + dish1.getDish() + "\n" + dish2.getDish();
        assertEquals(expected, result);
        assertFalse(menu.contains(new Dish("a","abc",10)));

    }


}
