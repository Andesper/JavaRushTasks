package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(buffer.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer entry;
        while(file.available() > 0) {
            entry = file.read();
            if(map.containsKey(entry)) map.put(entry, map.get(entry) + 1);
            else map.put(entry, 1);
        }
        buffer.close();
        file.close();

        Integer maxKey = Collections.max(map.values());
        for(Map.Entry<Integer, Integer> key:map.entrySet()) {
            if(maxKey == key.getValue()) System.out.print(key.getKey() + " ");
        }
    }
}
