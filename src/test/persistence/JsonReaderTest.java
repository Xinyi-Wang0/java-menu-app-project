package persistence;

import model.Dish;
import model.Menu;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Menu me = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkMenu() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyMenu.json");
        try {
            Menu me = reader.read();
            assertEquals(0, me.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralMenu() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralMenu.json");

        try {
            Menu me = reader.read();
            List<Dish> dishes = me.allDishes();
            assertEquals(2, dishes.size());
            checkDish("A", "abc", 0, dishes.get(0));
            checkDish("B", "bcd", 1, dishes.get(1));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
