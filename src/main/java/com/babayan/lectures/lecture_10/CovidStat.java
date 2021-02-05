package com.babayan.lectures.lecture_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class CovidStat {
    public static void main(String[] args) {
        String[] a = {"Ma1", "aA2", "aA0", "aA", "aA6", "aA7", "aA1","Ma1"};
//        String[] temp = "awdawdaw@mail.com".split("@");
//        System.out.println(temp[1]);
//        CovidStat.mostPopular(a);
        System.out.println(CovidStat.mostPopular(a));
    }

    HashMap<Integer, Person> data;

    public CovidStat(HashMap<Integer, Person> data) {
        this.data = data;
    }

    private static String mostPopular(String[] a) {
        HashMap<String, Integer> hashMapVariable = new HashMap<>();
        HashMap<Integer, String> hashMapVariable2 = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (hashMapVariable.containsKey(a[i])) {
                hashMapVariable.put(a[i], hashMapVariable.get(a[i]) + 1);
            } else {
                hashMapVariable.put(a[i], 1);
            }
        }
        int number = 0;
        for (int temp : hashMapVariable.values()) {
            if (temp > number) {
                number = temp;
            }
        }
        Iterator <String> iterator2 = hashMapVariable.keySet().iterator();
        Iterator<Integer> iterator = hashMapVariable.values().iterator();
        while (iterator.hasNext() && iterator2.hasNext()) {
            hashMapVariable2.put(iterator.next(),iterator2.next());
        }
        if (number==1) {
            return "No!";
        } else return hashMapVariable2.get(number);
    }

    public String getMostPopularName() {
        String[] name = new String[data.size()];
        int i = 0;
        for (Person person : data.values()) {
            name[i] = person.getFirstName();
            i++;
        }
        return mostPopular(name);
    }

    public String getMostPopularSurname() {
        String[] name = new String[data.size()];
        int i = 0;
        for (Person person : data.values()) {
            name[i] = person.getLastName();
            i++;
        }
        return mostPopular(name);
    }

    public String getMostPopularMailDomain() {
        String[] email = new String[data.size()];
        int i = 0;
        for (Person person : data.values()) {
            String[] temp = person.getEmail().split("@");
            email[i] = temp[1];
            i++;
        }
        return mostPopular(email);
    }

    private int averageNum(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp += num;
        }
        return temp / nums.length;
    }

    public int getAverageAge() {
        int[] nums = new int[data.size()];
        int i = 0;
        for (Person person : data.values()) {
            nums[i] = person.getAge();
            i++;
        }
        return averageNum(nums);
    }

    public int getAverageHeight() {
        int[] nums = new int[data.size()];
        int i = 0;
        for (Person person : data.values()) {
            nums[i] = person.getHeight();
            i++;
        }
        return averageNum(nums);
    }

    public int getAverageWeight() {
        int[] nums = new int[data.size()];
        int i = 0;
        for (Person person : data.values()) {
            nums[i] = person.getWeight();
            i++;
        }
        return averageNum(nums);
    }

}
