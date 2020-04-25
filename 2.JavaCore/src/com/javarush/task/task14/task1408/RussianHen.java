package com.javarush.task.task14.task1408;


public class RussianHen extends Hen implements Country{
        @Override
        public  int getCountOfEggsPerMonth(){
            return 553245;
        }
        @Override
        public String getDescription(){
           return super.getDescription() + " Моя страна - " + "Russia. Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
        }
    }