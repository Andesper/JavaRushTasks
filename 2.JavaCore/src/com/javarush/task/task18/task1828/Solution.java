package com.javarush.task.task18.task1828;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String fileName = buffer.readLine();
            buffer.close();
            Scanner reader = new Scanner(new FileReader(fileName));
            HashMap<Integer, String> mapList = new LinkedHashMap<>();

            while (reader.hasNextLine()) {
                String str = reader.nextLine();
                mapList.put(Integer.parseInt(str.substring(0, 8).trim()), str);
            }
            for(Map.Entry<Integer, String> entry:mapList.entrySet()){
                System.out.println(entry.getValue());
            }
            System.out.println("----------------------------");
            if (args[0].equals("-u")) {
                StringBuilder str = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    if (i == 1) {//id
                        str.append(args[i]);
                        while(str.length() < 8) {
                            str.append(" ");
                        }
                    }
                    else if(i < args.length - 2) { //productname
                        str.append(args[i]).append(" ");
                    }
                    else if (i == args.length - 2) {//price
                        while (str.length() < 38) {
                            str.append(" ");
                        }
                        //if (str.length() > 38)
                            str.setLength(38);
                        str.append(args[i]);
                        while (str.length() < 46) {
                            str.append(" ");
                        }
                        str.setLength(46);
                    }
                    else if(i == args.length - 1) {//quantity
                        str.append(args[i]);
                        while (str.length() < 50) {
                            str.append(" ");
                        }
                        str.setLength(50);
                    }
                }
                mapList.put(Integer.parseInt(args[1]), String.valueOf(str));
            }
            if (args[0].equals("-d")) {
                mapList.remove(Integer.parseInt(args[1]));
            }
            reader.close();

            FileWriter writer = new FileWriter(fileName);
            for(Map.Entry<Integer, String> entry:mapList.entrySet()){
                System.out.println(entry.getValue());
                writer.write(entry.getValue() + "\n");
            }
            writer.close();
        }
    }
}