package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Serializable, Cloneable {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(int capacity) {
        map = new HashMap<>(capacity);
    }

    public AmigoSet(Collection<? extends E> с) {
        map = new HashMap<>(Math.max((int) (с.size() / .75f) + 1, 16));
        addAll(с);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = map.keySet().iterator();
        return iterator;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == null;
    }

    @Override
    public Object clone() throws InternalError {
        try {
            AmigoSet<E> cloneSet = (AmigoSet<E>) super.clone();
            cloneSet.map= (HashMap<E, Object>) this.map.clone();
            return cloneSet;
        } catch (Exception e) {
            throw new InternalError();
        }
    }
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();

        Set<E> keySet = map.keySet();

        Object [] array = keySet.toArray();
        objectOutputStream.writeObject(array);

        Object loadFactor = HashMapReflectionHelper.callHiddenMethod(map,"loadFactor");
        objectOutputStream.writeObject(loadFactor);

        Object capacity = HashMapReflectionHelper.callHiddenMethod(map,"capacity");
        objectOutputStream.writeObject(capacity);

    }
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();

        Object [] arrayKeys = (Object[]) objectInputStream.readObject();
        float loadFactor = (float)objectInputStream.readObject();
        int capacity = (int)objectInputStream.readObject();

        map = new HashMap<>(capacity, loadFactor);

        for(Object element : arrayKeys){
            map.put((E)element,PRESENT);
        }
    }
}
