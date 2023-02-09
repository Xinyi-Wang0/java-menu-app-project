package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private ArrayList<Dish> menu;
    private int numOfDish;

    //EFFECTS: constructs Menu with initial 0 number of Dish and empty list of dishes
    public Menu() {
        this.menu = new ArrayList<>();
        numOfDish = 0;
    }

    //MODIFIES: this
    //EFFECTS: add dish to this menu
    public void addDish(Dish dish) {
        menu.add(dish);
    }

    //MODIFIES: this
    //EFFECTS: remove dish to this menu
    public void removeDish(Dish dish) {
        menu.remove(dish);
    }

    //EFFECTS: remove dish if it is contained in the list, the numOfDish -1, if not return
    //         "not available"
    public String deleteDish(String theName) {
        for (Dish dish : menu) {
            if (dish.getName().equalsIgnoreCase(theName)) {
                removeDish(dish);
                numOfDish--;
                return dish.getName() + " has been removed from menu.";
            }
        }
        return "Fail to remove dish.";
    }

    //EFFECTS: return dish if it is contained in the list, add1 to the numOfDish, if not return
    //         "not available"
    public String getDishesDetails(String selectedDishName) {
        for (Dish dish : menu) {
            if (dish.getName().equalsIgnoreCase(selectedDishName)) {
                String output = dish.getDish() + "\n";
                numOfDish++;
                return output;
            }
        }
        return "not available";
    }

    //EFFECTS: return all the dishes in the list
    public String viewAllDish() {
        if (menu.size() == 0) {
            return "List of Dishes: empty";
        } else {
            String output = "List of Dishes: ";
            for (Dish dish : menu) {
                output += "\n" + dish.getDish();
            }
            return output;
        }
    }

    // EFFECTS: return an unmodifiable list of dishes in this menu
    public List<Dish> allDishes() {
        return menu;
    }

    //EFFECTS: return number of dishes in menu
    public int size() {
        return menu.size();
    }

    // EFFECTS: return true if selected dish is in this menu
    public boolean contains(Dish dish) {
        return menu.contains(dish);
    }

}
