package com.javarush.task.task33.task3310.tests;
/*
Shortener (15)
        Напишем еще один тест, который проверит, что получить идентификатор для строки используя стратегию HashBiMapStorageStrategy можно быстрее, чем используя стратегию HashMapStorageStrategy.
        15.1. Создай класс SpeedTest в пакете tests.
        15.2. Добавь в класс метод long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids). Он должен возвращать время в миллисекундах необходимое для получения идентификаторов для всех строк из strings. Идентификаторы должны быть записаны в ids.
        15.3. Добавь в класс метод long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings). Он должен возвращать время в миллисекундах необходимое для получения строк для всех идентификаторов из ids. Строки должны быть записаны в strings.
        15.4. Добавь в класс SpeedTest тест testHashMapStorage(). Он должен:
        15.4.1. Создавать два объекта типа Shortener, один на базе HashMapStorageStrategy, второй на базе HashBiMapStorageStrategy. Назовем их shortener1 и shortener2.
        15.4.2. Генерировать с помощью Helper 10000 строк и помещать их в сет со строками, назовем его origStrings.
        15.4.3. Получать время получения идентификаторов для origStrings (вызывать метод getTimeToGetIds для shortener1, а затем для shortener2).
        15.4.4. Проверять с помощью junit, что время, полученное в предыдущем пункте для shortener1 больше, чем для shortener2.
        15.4.5. Получать время получения строк (вызывать метод getTimeToGetStrings для shortener1 и shortener2).
        15.4.6. Проверять с помощью junit, что время, полученное в предыдущем пункте для shortener1 примерно равно времени для shortener2. Используй метод assertEquals(float expected, float actual, float delta). В качестве delta можно использовать 30, этого вполне достаточно для наших экспериментов.
*/
import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.task.task33.task3310.Solution.getIds;
import static com.javarush.task.task33.task3310.Solution.getStrings;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date startDateTime = new Date();
        ids = getIds(shortener, strings);
        Date finishDateTime = new Date();

        return finishDateTime.getTime() - startDateTime.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date startDateTime = new Date();
        strings = getStrings(shortener, ids);
        Date finishDateTime = new Date();

        return finishDateTime.getTime() - startDateTime.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortenerFirst = new Shortener(new HashMapStorageStrategy());
        Shortener shortenerSecond = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++)
            origStrings.add(Helper.generateRandomString());
        Set<Long> ids = new HashSet<>();
        Long shortnerGetTimeToGetIdsFirst = getTimeToGetIds(shortenerFirst, origStrings, ids);
        Long shortnerGetTimeToGetIdsSecond = getTimeToGetIds(shortenerSecond, origStrings, ids);
        Assert.assertTrue(shortnerGetTimeToGetIdsFirst > shortnerGetTimeToGetIdsSecond);

        Long shortnerGetTimeToGetStringFirst = getTimeToGetStrings(shortenerFirst, ids, new HashSet<>());
        Long shortnerGetTimeToGetStringSecond = getTimeToGetStrings(shortenerSecond, ids, new HashSet<>());
        Assert.assertEquals(shortnerGetTimeToGetStringFirst, shortnerGetTimeToGetStringSecond, 30);

    }
}
