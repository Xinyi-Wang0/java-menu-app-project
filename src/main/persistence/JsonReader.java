package persistence;

import model.Dish;
import model.Menu;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

//Represents a reader that reads menu from JSON data stored in file
public class JsonReader {
    private String source;

    //EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads menu from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Menu read() throws IOException {
        //JSONArray jsonArray = new JSONArray();
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseMenu(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses menu from JSON object and returns it
    private Menu parseMenu(JSONObject jsonObject) {
        //JSONArray dishes = jsonObject.getJSONArray("dish");
        //String name = jsonObject.getString("name");
        Menu me = new Menu();
        addDishes(me, jsonObject);
        return me;
    }

    // MODIFIES: me
    // EFFECTS: parses dishes from JSON object and adds them to menu
    private void addDishes(Menu me, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("dish");
        for (Object json : jsonArray) {
            JSONObject nextDish = (JSONObject) json;
            addDish(me, nextDish);
        }
    }

    // MODIFIES: me
    // EFFECTS: parses dish from JSON object and adds it to menu
    private void addDish(Menu me, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String ingredients = jsonObject.getString("ingredients");
        int price = jsonObject.getInt("price");
        Dish dish = new Dish(name, ingredients, price);
        me.addDish(dish);
    }


}
