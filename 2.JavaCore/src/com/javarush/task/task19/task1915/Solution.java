package com.javarush.task.task19.task1915;
import java.io.*;
/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    String fileName = null;
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
    fileName = reader.readLine();
    }catch(IOException e){
        e.printStackTrace();
    }
    
        
    PrintStream consoleStream = System.out;

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  
    PrintStream stream = new PrintStream(outputStream);
    
    System.setOut(stream);
    
    testString.printSomething();
    
    String resultString = outputStream.toString();
    
    System.setOut(consoleStream);
    
    try(OutputStream os = new FileOutputStream(fileName)){
        os.write(resultString.getBytes());
    }catch(IOException e){
        e.printStackTrace();
    }
    
    System.out.println(resultString);
    
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

