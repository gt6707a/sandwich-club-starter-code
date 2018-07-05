package com.udacity.sandwichclub.utils;

import java.util.List;

public final class StringUtils {
    public static String join(List<String> list) {
        if (list == null) return "";

        StringBuilder sb = new StringBuilder();

        int i = 0;
        for(String str : list) {
            sb.append(str + (i++ == list.size() - 1 ? "" : ", "));
        }

        return sb.toString();
    }

    private StringUtils() {
        // non-instantiable
    }
}
