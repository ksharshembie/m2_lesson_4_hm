package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> textA = new ArrayList<>();
        ArrayList<String> textB = new ArrayList<>();
        ArrayList<String> textC = new ArrayList<>();
        textA.addAll(addText(5));
        textB.addAll(addText(5));
        textC.addAll(concatList(textA, textB));
        System.out.println("\nОбъединение списков в формате {A1,B5,А2,Б4,А3,Б3,А4,Б2,А5,Б1}:\n"
                + textC);
        sortByLength(textC);
    }

    public static ArrayList<String> addText(int listLength) {
        System.out.println("Введите " + listLength + " строк(слов) с клавиатуры:");
        Scanner console = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            System.out.print((i + 1) + ": ");
            text.add(console.nextLine());
        }
        System.out.println(text);
        return text;
    }

    public static ArrayList<String> concatList(ArrayList<String> listA, ArrayList<String> listB) {
        ArrayList<String> text = new ArrayList<>();
        text.addAll(listA);
        Collections.reverse(listB);
        int i = 1;
        int j = 0;
        while (j < listB.size()) {
            if (i >= text.size()) {
                text.add(listB.get(j));
                j++;
            } else {
                text.add(i, listB.get(j));
                i += 2;
                j++;
            }
        }
        return text;
    }

    public static void sortByLength(ArrayList<String> list) {
        ArrayList<String> text = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(j).length() < list.get(i).length()) {
                    String temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }
        text.addAll(list);
        System.out.println("\nОтсортированный по длине список:\n" + text);
    }
}
