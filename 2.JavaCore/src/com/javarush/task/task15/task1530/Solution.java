package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {
    DrinkMaker latte = new LatteMaker();
    latte.makeDrink();
    DrinkMaker tea = new TeaMaker();
    tea.makeDrink();
    }
}
