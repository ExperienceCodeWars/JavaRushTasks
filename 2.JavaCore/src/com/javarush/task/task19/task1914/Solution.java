package com.javarush.task.task19.task1914;
import java.util.regex.*;
import java.io.*;
/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

    PrintStream consoleStream = System.out;

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  
    PrintStream stream = new PrintStream(outputStream);
    
    System.setOut(stream);
    
    testString.printSomething();
    
    String resultString = outputStream.toString();
    
    System.setOut(consoleStream);
    
    String [] mass= resultString.split(" ");
    int a = Integer.parseInt(mass[0]);
    int b = Integer.parseInt(mass[2]);
    int result=0;
    
    if(mass[1].equals("-")) result = a - b;
    if(mass[1].equals("+")) result = a + b;
    if(mass[1].equals("*")) result = a * b;
    System.out.printf("%d %s %d = %d", a,mass[1],b,result);
    
    
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

