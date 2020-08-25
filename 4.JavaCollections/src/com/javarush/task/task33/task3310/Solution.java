package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Helper helper = new Helper();

    public static void main(String[] args) {
        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);

        StorageStrategy strategy2 = new OurHashMapStorageStrategy();
        testStrategy(strategy2, 10000);

        StorageStrategy strategy3 = new FileStorageStrategy();
        testStrategy(strategy3, 100);

        StorageStrategy strategy4 = new OurHashBiMapStorageStrategy();
        testStrategy(strategy4, 10000);

        StorageStrategy strategy5 = new HashBiMapStorageStrategy();
        testStrategy(strategy5,50000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String element : strings)
            set.add(shortener.getId(element));
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();
        for (Long element : keys)
            set.add(shortener.getString(element));
        return set;
    }

    public static void testStrategy(StorageStrategy storageStrategy, long elementsNumber) {
        //6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.
        Helper.printMessage(storageStrategy.getClass().getSimpleName());

        //6.2.3.2. Генерировать тестовое множество строк.
        Set<String> set = new HashSet<>();
        Long[] elements = new Long[(int) elementsNumber];

        for (int i = 0; i < elements.length; i++) {
            set.add(Helper.generateRandomString());
        }
        //6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.
        Shortener shortener = new Shortener(storageStrategy);

        //6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии
        Date startDateTime = new Date();
        Set<Long> ids = getIds(shortener, set);
        Date finishDateTime = new Date();

        long deltaTime = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));

        //6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии
        startDateTime = new Date();
        Set<String> strings = getStrings(shortener, ids);
        finishDateTime = new Date();

        deltaTime = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));

        //6.2.3.6. Сравнивать одинаковое ли содержимое множества строк
        if (set.equals(strings)) {
            Helper.printMessage("Тест пройден.");
        } else
            Helper.printMessage("Тест не пройден.");
    }
}
