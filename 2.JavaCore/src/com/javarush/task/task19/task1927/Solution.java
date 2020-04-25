package com.javarush.task.task19.task1927;
import java.io.*;
/* 
Контекстная реклама
*/

public class Solution {
     public static TestString testString = new TestString();
    public static void main(String[] args) throws IOException {
    PrintStream consoleStream = System.out;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(byteArrayOutputStream);
    System.setOut(printStream);
    testString.printSomething();
    String[]list=byteArrayOutputStream.toString().split("\n");
    System.setOut(consoleStream);

    printStream.close();
    int count = 0;
        for (int i = 0; i <list.length; i++) {
            count++;
            System.out.println(list[i]);
            if(count%2==0){
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
