package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;

public class Entry implements Serializable {
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Entry))
            return false;
        Long currentKey = getKey();
        Long comparableKey = ((Entry) o).getKey();
        String currentValue = getValue();
        String comparableValue = ((Entry) o).getValue();
        if (currentKey == comparableKey || (currentKey != null && currentKey.equals(comparableKey))) {
            if (currentValue == comparableValue || (currentValue != null && currentValue.equals(comparableValue)))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }
}
