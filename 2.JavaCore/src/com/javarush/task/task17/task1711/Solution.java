package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if(args.length > 0) {
            String sex;
            Date date;
            int count = 1;
            switch (args[0]) {
                case ("-c")://add peoples
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length - 3; i += 3) {
                            date = new SimpleDateFormat("d/MM/yyyy").parse(args[i + 2]);
                            if (args[i + 1].equals("м")) {
                                allPeople.add(Person.createMale(args[i], date));
                            } else {
                                allPeople.add(Person.createFemale(args[i], date));
                            }
                            count++;
                            System.out.println(count);
                        }
                    }
                    break;
                case("-u")://update peoples
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length - 4; i += 4) {
                            date = new SimpleDateFormat("d/MM/yyyy").parse(args[i + 3]);
                            if (args[i + 2].equals("male")) allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                            else allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                            allPeople.get(Integer.parseInt(args[i])).setName(args[i + 1]);
                            allPeople.get(Integer.parseInt(args[i])).setBirthDate(date);
                        }
                    }
                    break;
                        case ("-d"): //delete peoples
                            synchronized (allPeople) {
                                for (int i = 1; i < args.length; i++) {
                                    allPeople.get(Integer.parseInt(args[i])).setSex(null);
                                    allPeople.get(Integer.parseInt(args[i])).setName(null);
                                    allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                                }
                            }
                            break;
                    case ("-i")://print information
                        synchronized (allPeople) {
                            for (int i = 1; i < args.length; i++) {
                                if (allPeople.get(Integer.parseInt(args[i])).getSex() == Sex.MALE) sex = "м";
                                else sex = "ж";
                                System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " " + sex + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(args[i])).getBirthDate()));
                            }
                        }
                        break;
                default:
                    throw new IllegalStateException("Unexpected value: " + args[0]);
            }
        }
    }
}
