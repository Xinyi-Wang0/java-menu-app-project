package model;

public class Dish {
    private String name;
    private String ingredients;
    private int price;

    //EFFECTS: Dish has given name, ingredients and price
    public Dish(String name, String ingredients, int price) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    //EFFECT: return dish name
    public String getName() {
        return name;
    }

    //EFFECTS: return price
    public int getPrice() {
        return price;
    }

    //EFFECTS: return ingredients
    public String getIngredients() {
        return ingredients;
    }

    //EFFECTS: return all details of dish
    public String getDish() {
        return "Name:" + name;
    }

}
