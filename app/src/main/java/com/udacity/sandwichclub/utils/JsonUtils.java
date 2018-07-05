package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {
    static final String NAME = "name";

    public static Sandwich parseSandwichJson(String json) {

        if (json == null || json.isEmpty()) {
            return new Sandwich();
        }

        try {
            JSONObject object = new JSONObject(json);
            // Ideally, the values of query strings are better declared as static finals and
            //   perhaps even shared. Do one here as example.
            JSONObject name = object.getJSONObject(NAME);
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAsJsonArray = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = Arrays.asList();
            for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                if (alsoKnownAsJsonArray.optString(i) != null) {
                    alsoKnownAs.add(alsoKnownAsJsonArray.getString(i));
                }
            }
            String placeOfOrigin = object.getString("placeOfOrigin");
            String description = object.getString("description");
            String image = object.getString("image");
            JSONArray ingredientsJsonArray = object.getJSONArray("ingredients");
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
