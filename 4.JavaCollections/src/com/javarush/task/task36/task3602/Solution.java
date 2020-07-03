package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {

        Class[] classes = Collections.class.getDeclaredClasses();

        for (Class currentClass : classes) {
            if (Modifier.isPrivate(currentClass.getModifiers())) {
                if (Modifier.isStatic(currentClass.getModifiers())) {
                    if (List.class.isAssignableFrom(currentClass)) {
                        try {
                            Constructor constructor = currentClass.getDeclaredConstructor();
                            constructor.setAccessible(true);
                            List list = (List) constructor.newInstance();
                            list.get(0);
                        } catch (IndexOutOfBoundsException e) {
                            return currentClass;
                        } catch (InstantiationException | NoSuchMethodException |
                                InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return null;
    }
}
