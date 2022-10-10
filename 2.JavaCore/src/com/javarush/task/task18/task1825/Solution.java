package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        Map<String, String> mapFileName = new TreeMap<>();
        String[] array = new String[10];
        while (!(fileName = scanner.readLine()).equals("end")) {
            array = fileName.split("\\.part");
            mapFileName.put(array[1], array[0]);
            //System.out.println(mapFileName);
        }
        scanner.close();

        FileInputStream reader;
        FileOutputStream writer = new FileOutputStream(array[0], true);

        for(Map.Entry<String, String> entry:mapFileName.entrySet()) {
            //byte[] buffer = new byte[100];
            int count = 0;
            fileName = entry.getValue() + ".part" + entry.getKey();
            reader = new FileInputStream(fileName);
            while(reader.available() > 0) {
                byte[] buffer = new byte[reader.available()];
                reader.read(buffer);
                writer.write(buffer);
            }
            reader.close();
            writer.flush();
        }
        writer.close();
    }
}
