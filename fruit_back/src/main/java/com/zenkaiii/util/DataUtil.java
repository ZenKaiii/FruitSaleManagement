package com.zenkaiii.util;

import java.util.HashMap;
import java.util.Map;

public class DataUtil {
    public static Map<String,String> createItemStyle(Integer sale) {
        String color = "";
        if (sale <= 60){
            color = "#96dee8";
        }
        if (sale > 60 && sale <= 160){
            color = "#c4ebad";
        }
        if (sale > 160 && sale <= 300){
            color = "#6be6c1";
        }
        if (sale > 300 && sale <= 500){
            color = "#3fb1e3";
        }
        if (sale > 500) {
            color = "#a0a7e6";
        }
        Map<String,String> map = new HashMap<>();
        map.put("color",color);
        return map;
    }
}
