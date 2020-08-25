package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        File file = new File(fileName);
        return new ObjectMapper().readValue(file, clazz);
    }

    public static void main(String[] args) throws IOException {
       User user = convertFromJsonToNormal("C:\\Users\\Stas\\Desktop\\qwerty\\JsonFormat\\JsonObject.txt",User.class);
       System.out.println(user);
    }
    @JsonAutoDetect
    static class User
    {
        public String name;
        public int age;
        public int weight;
        User(){}

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", weight=" + weight +
                    '}';
        }
    }
}
