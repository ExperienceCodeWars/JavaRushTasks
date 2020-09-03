package com.javarush.task.task33.task3310.tests;

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
