package ui;

import model.Dish;
import model.Menu;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuApp {
    private static final String JSON_STORE = "./data/menu.json";
    private Menu menu;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the Menu application
    public MenuApp() throws FileNotFoundException {
        menu = new Menu();
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runMenu();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runMenu() {
        String command = "";

        while (true) {
            displayMenu();
            command = input.next();
            input.nextLine();

            if (command.equals("Quit")) {
                System.out.println("Thank you for viewing");
                break;
            } else if (command.equals("s")) {
                saveMenu();
            } else if (command.equals("l")) {
                loadMenu();
            } else {
                processCommand(command);
            }
            System.out.println("*----------------------------------------------------------*");
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\n" + "* Today Special (Select dish to get more information)");
        System.out.println("[1] Add dish");
        System.out.println("[2] Check in detail");
        System.out.println("[3] Check menu");
        System.out.println("[4] Number of dishes");
        System.out.println("[5] Delete dish");
        System.out.println("\ts -> save menu to file");
        System.out.println("\tl -> load menu from file");
        System.out.println("Quit");
    }

    private void processCommand(String command) {
        if (command.equals("1")) {
            createDish();
        }
        if (command.equals("2")) {
            System.out.println("Enter dish name: ");
            String name = input.nextLine();
            System.out.println(menu.getDishesDetails(name));
        }
        if (command.equals("3")) {
            System.out.println(menu.viewAllDish());
        }
        if (command.equals("4")) {
            System.out.println("Num: " + menu.size());
        }
        if (command.equals("5")) {
            System.out.println("Enter dish name: ");
            String name = input.nextLine();
            System.out.println(menu.deleteDish(name));
        }
    }

    private void createDish() {
        System.out.println("Enter dish name: ");
        String name = input.nextLine();
        System.out.println("Enter dish ingredients: ");
        String ingredients = input.nextLine();
        System.out.println("Enter the price: ");
        int customers = input.nextInt();
        menu.addDish(new Dish(name, ingredients, customers));
        System.out.println("New dish added!");
    }


    // EFFECTS: prints all the dishes on the menu to the console
    private void printDishes() {
        List<Dish> dishes = menu.allDishes();

        for (Dish d : dishes) {
            System.out.println(d);
        }
    }

    // EFFECTS: saves the menu to file
    private void saveMenu() {
        try {
            jsonWriter.open();
            jsonWriter.write(menu);
            jsonWriter.close();
            System.out.println("Saved " + menu.viewAllDish() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads menu from file
    private void loadMenu() {
        try {
            menu = jsonReader.read();
            System.out.println("Loaded " + menu.viewAllDish() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
