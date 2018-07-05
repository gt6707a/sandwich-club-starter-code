package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    static final String NAME = "name";
    static final String MAIN_NAME = "mainName";
    static final String ALSO_KNOWN_AS = "alsoKnownAs";
    static final String PLACE_OF_ORIGIN = "placeOfOrigin";
    static final String DESCRIPTION = "description";
    static final String IMAGE = "image";
    static final String INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {

        if (json == null || json.isEmpty()) {
            return new Sandwich();
        }

        try {
            JSONObject object = new JSONObject(json);
            JSONObject name = object.getJSONObject(NAME);
            String mainName = name.getString(MAIN_NAME);
            JSONArray alsoKnownAsJsonArray = name.getJSONArray(ALSO_KNOWN_AS);
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                if (!alsoKnownAsJsonArray.optString(i).equals("")) {
                    alsoKnownAs.add(alsoKnownAsJsonArray.getString(i));
                }
            }
            String placeOfOrigin = object.getString(PLACE_OF_ORIGIN);
            String description = object.getString(DESCRIPTION);
            String image = object.getString(IMAGE);
            JSONArray ingredientsJsonArray = object.getJSONArray(INGREDIENTS);
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsJsonArray.length(); i++) {
                String ingredient = ingredientsJsonArray.optString(i);
                ingredients.add(ingredient);
            }

            return new Sandwich(
                    mainName,
                    alsoKnownAs,
                    placeOfOrigin,
                    description,
                    image,
                    ingredients
            );
        } catch (JSONException ex) {
            return new Sandwich();
        }
    }
}
