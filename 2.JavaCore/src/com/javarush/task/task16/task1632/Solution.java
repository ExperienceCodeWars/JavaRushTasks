package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
static {
    Thread thread1= new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){

            }
        }
    });
    threads.add(thread1);
    Thread thread2= new Thread(new Runnable() {
        @Override
        public void run() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
        }
    });
    threads.add(thread2);
    Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
         while(true){
             try {
                 System.out.println("Ура");
                 Thread.sleep(500);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
        }
    });
    threads.add(thread3);
    MyThread thread4 =new MyThread();
    threads.add(thread4);

  Thread thread5 = new Thread(new Runnable() {
        @Override
        public void run() {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = "";
        Integer n;
        int sum = 0;
        while (!s1.equals("N")) {
            try {
                s1 = br.readLine();
                n = Integer.parseInt(s1);
                sum += n;
            } catch (Exception e) {

            }
        }
        System.out.println(sum);
        }
    });
    threads.add(thread5);
}
public static class MyThread extends Thread implements Message {


    @Override
    public void run() {
     while(!isInterrupted()){
         
     }

    }
    public void showWarning(){
       this.interrupt();
    }
}
    public static void main(String[] args) {
    }
}