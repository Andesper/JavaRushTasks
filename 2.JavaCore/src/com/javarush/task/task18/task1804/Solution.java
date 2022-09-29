package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(buffer.readLine());

        while (file.available() > 0) {
            Integer byteKey = file.read();
            if(countMap.containsKey(byteKey)) {
                countMap.put(byteKey, countMap.get(byteKey) + 1);
            }
            else countMap.put(byteKey, 1);
        }

        //countMap.forEach((k, v) -> System.out.println(k + " " + v));
        buffer.close();
        file.close();
        Integer minValue = Collections.min(countMap.values());
        for (Map.Entry<Integer, Integer> entry:countMap.entrySet()){
            if(minValue == entry.getValue()) System.out.print(entry.getKey() + " ");
        }
    }
}
