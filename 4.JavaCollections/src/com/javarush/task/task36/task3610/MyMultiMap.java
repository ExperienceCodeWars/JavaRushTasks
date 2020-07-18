package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return values().size();
    }

    @Override
    public V put(K key, V value) {

        List<V> list = map.get(key);
        V oldValue = null;

        if (list == null) {
            list = new ArrayList<>();
        } else {
            oldValue = list.get(list.size() - 1);
            if (list.size() == repeatCount)
                list.remove(0);
        }
        list.add(value);
        map.put(key, list);
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        List<V> list = map.get(key);
        if (list == null)
            return null;

        V elementToBeRemove = list.get(0);
        list.remove(0);
        if (list.size() == 0)
            map.remove(key);

        return elementToBeRemove;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> vArrayList = new ArrayList<>();
        for (List<V> value : map.values()) {
            vArrayList.addAll(value);
        }
        return vArrayList;
    }

    @Override
    public boolean containsKey(Object key) {
        return keySet().contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}