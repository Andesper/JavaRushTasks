package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.*;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length > 0 && args[0].equals("-c")) {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String fileName = buffer.readLine();
            Scanner reader = new Scanner(new FileReader(fileName));
            ArrayList<Integer> idList = new ArrayList<>();

            while (reader.hasNextLine()) {
                idList.add(Integer.parseInt(reader.nextLine().substring(0, 8).trim()));
            }

            //собираем строку из параметров запроса
            StringBuilder result = new StringBuilder();
            result.append(Collections.max(idList) + 1);
            StringBuilder nameString = new StringBuilder();
            for (int i = 1; i < args.length - 2; i++) {
                nameString.append(args[i]).append(" ");
            }
            String[] priceArr = args[args.length - 2].split("");
            String[] quantityArr = args[args.length - 1].split("");

            if(nameString.length() < 30) {
                for (int i = 0; i < 30; i++) {
                    nameString.append(" ");
                }
            }

            nameString.setLength(30);

            result.append(nameString);
            for (int i = 0; i < 8; i++) {
                if (priceArr.length > i) {
                    result.append(priceArr[i]);
                }
                else result.append(" ");
            }

            for (int i = 0; i < 4; i++) {
                if (quantityArr.length > i) {
                    result.append(quantityArr[i]);
                }
                else result.append(" ");
            }

            System.out.println(result);
            System.out.println(fileName);
            reader.close();
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("\n" + result);
            writer.close();
        }
    }
}
