package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private LRUCache<Long, Object> lruCache;
    private OriginalRetriever originalRetriever;
    private Storage storage;

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache<>(16);
    }

    @Override
    public Object retrieve(long id) {
        Object result = lruCache.find(id);
        if (result == null) {
            result = originalRetriever.retrieve(id);
            lruCache.set(id, result);
        }
        return result;

    }
}
