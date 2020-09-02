package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String string1 = "firstString";
        String string2 = "secondString";
        String string3 = "firstString";

        Long stringId1 = shortener.getId(string1);
        Long stringId2 = shortener.getId(string2);
        Long stringId3 = shortener.getId(string3);

        Assert.assertNotEquals(stringId2, stringId1);
        Assert.assertNotEquals(stringId2, stringId3);

        Assert.assertEquals(string1, string3);

        String stringFromShortener1 = shortener.getString(stringId1);
        String stringFromShortener2 = shortener.getString(stringId2);
        String stringFromShortener3 = shortener.getString(stringId3);

        Assert.assertEquals(string1, stringFromShortener1);
        Assert.assertEquals(string2, stringFromShortener2);
        Assert.assertEquals(string3, stringFromShortener3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);

    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);

    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);

    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);

    }
}
