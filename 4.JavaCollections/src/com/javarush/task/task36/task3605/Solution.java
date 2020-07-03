package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Set<Character> treeSet = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String s = reader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]", "");
                for (int i = 0; i < s.length(); i++)
                    treeSet.add(s.charAt(i));
            }
        }
        Iterator<Character> iterator = treeSet.iterator();

        int n = Math.min(treeSet.size(), 5);

        for (int i = 0; i < n; i++) {
            System.out.print(iterator.next());
        }
    }
}

