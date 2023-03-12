package persistence;

import model.Dish;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {protected void checkDish(String name, String ingredients, int price, Dish dish) {
    assertEquals(name, dish.getName());
    assertEquals(ingredients, dish.getIngredients());
    assertEquals(price, dish.getPrice());
}
}
