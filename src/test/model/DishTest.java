package model;

import org.junit.jupiter.api.BeforeEach;

class DishTest {
    Dish testDish;

    @BeforeEach
    public void setup() {
        this.testDish = new Dish("Burger", "wheat flour, tomato, egg", 10);
    }
}