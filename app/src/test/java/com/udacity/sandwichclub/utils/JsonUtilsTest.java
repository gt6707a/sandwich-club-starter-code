package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class JsonUtilsTest {

    @Test
    public void testParseSandwichJson() {
        String json = "{\"name\":{\"mainName\":\"Ham and cheese" +
                "sandwich\",\"alsoKnownAs\":[]},\"placeOfOrigin\":\"\",\"description\":\"A ham and cheese" +
                "sandwich is a common type of sandwich. It is made by putting cheese and sliced ham" +
                "between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables" +
                "like lettuce, tomato, onion or pickle slices can also be included. Various kinds of" +
                "mustard and mayonnaise are also" +
                "common.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\"ingredients\":[\"Sliced" +
                "bread\",\"Cheese\",\"Ham\"]}";

        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        assertEquals("Ham and cheese", sandwich.getMainName());
        // ideally, we would test for equality of properties as we would expect.
    }
}