package model;

import model.exception.Event;
import model.exception.EventLog;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Writable {
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
        EventLog.getInstance().logEvent(new Event("Added dish: " + dish.getName()));
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
                EventLog.getInstance().logEvent(new Event("Removed dish: " + dish.getName()));
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
                String output = dish.getDish() + " " + "Ingredients: " + dish.getIngredients()
                        + " " + "Price:" + dish.getPrice() + "\n";
                numOfDish++;
                return output;
            }
        }
        return "not available";
    }

    //EFFECTS: return all the dishes in the list
    public String viewAllDish() {
        if (menu.size() == 0) {
            EventLog.getInstance().logEvent(new Event("List of Dishes: empty \n"));
            return "List of Dishes: empty";
        } else {
            String output = "List of Dishes: ";
            for (Dish dish : menu) {
                output += "\n" + dish.getDish();
            }
            EventLog.getInstance().logEvent(new Event("Viewed list of dishes: \n" + output));
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


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("dish", listOfDishesToJson());
        return json;
    }

    // EFFECTS: returns things in this menu as a JSON array
    private JSONArray listOfDishesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Dish d : menu) {
            jsonArray.put(d.toJson());
        }

        return jsonArray;
    }
}