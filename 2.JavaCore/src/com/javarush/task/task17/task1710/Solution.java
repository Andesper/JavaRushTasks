package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        if(args.length > 0) {
            if (args[0].equals("-c")) {
                Date date = null;
                try {
                    date = new SimpleDateFormat("d/MM/yyyy").parse(args[3]);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(args[1], date));
                } else allPeople.add(Person.createFemale(args[1], date));
                System.out.println(allPeople.size() - 1);
            } else if (args[0].equals("-r")) {
                if(allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.MALE) {
                    System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " м " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
                }
                else System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " ж " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
            } else if (args[0].equals("-u")) {
                Date date = null;
                try {
                    date = new SimpleDateFormat("d/MM/yyyy").parse(args[4]);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                if(args[3].equals("м")) {
                    allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                }
                else allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(date);
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + allPeople.get(Integer.parseInt(args[1])).getSex() + allPeople.get(Integer.parseInt(args[1])).getBirthDate());
            } else if (args[0].equals("-d")) {
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
            }
        }
        else System.out.println("аргументов нет!");
    }
}
