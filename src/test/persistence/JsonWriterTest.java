package persistence;

import model.Dish;
import model.Menu;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Menu me = new Menu();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyMenu() {
        try {
            Menu me = new Menu();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyMenu.json");
            writer.open();
            writer.write(me);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyMenu.json");
            me = reader.read();
            assertEquals(0, me.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralMenu() {
        try {
            Menu me = new Menu();
            me.addDish(new Dish("A", "abc", 0));
            me.addDish(new Dish("B", "bbb", 1));

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralMenu.json");
            writer.open();
            writer.write(me);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralMenu.json");
            me = reader.read();
            List<Dish> dishes = me.allDishes();
            assertEquals(2, dishes.size());
            checkDish("A", "abc", 0, dishes.get(0));
            checkDish("B", "bbb", 1, dishes.get(1));


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
