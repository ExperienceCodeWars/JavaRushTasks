package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.*;
/* 
Прайсы 2
*/

public class Solution {
   public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

            ArrayList<String> list = new ArrayList<>();
            while (in.ready()) {
                list.add(in.readLine());
            }
            if (args[0].equals("-u")) {
                for (String s : list) {
                    String currentId = s.substring(0, 8).trim();
                    if (!args[1].trim().equals(currentId)) {
                        out.write(s);
                    } else {
                        out.write(String.format("%-8d%-30.30s%-8.2f%-4d", Integer.parseInt(args[1]), args[2], Double.parseDouble(args[3]), Integer.parseInt(args[4])));
                    }
                    out.newLine();
                }
            } else if (args[0].equals("-d")) {
                for (String s : list) {
                    String currentId = s.substring(0, 8).trim();
                    if (!args[1].trim().equals(currentId)) {
                        out.write(s);
                        out.newLine();
                    }
                }
            }
            in.close();
            out.close();

        }

    }
}