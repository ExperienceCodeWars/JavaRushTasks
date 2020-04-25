package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    
    static{
        labels.put(new Double(1),"s");
        labels.put(new Double(2),"sq");
        labels.put(new Double(3),"sqew");
        labels.put(new Double(4),"srqeq");
        labels.put((double)5,"szdf");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
