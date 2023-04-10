package model;

import model.exception.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    private Event e;
    private Date d;

    @BeforeEach
    public void runBefore() {
        e = new Event("Dish added");   // (1)
        d = Calendar.getInstance().getTime();   // (2)
    }


    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "Dish added", e.toString());
    }
}
