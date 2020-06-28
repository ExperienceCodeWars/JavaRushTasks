package com.javarush.task.task35.task3507;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> animals = new HashSet<>();

        File[] list = new File(pathToAnimals).listFiles();
        for (File file : list) {
            if (file.isFile() && file.getName().endsWith(".class")) {

                String packageName = Solution.class.getPackage().getName() + ".data";
                Class clazz = new ClassFromPath().load(file.toPath(), packageName);

                int counter = 0;
                //Find interface Animal
                Class[] interfaces = clazz.getInterfaces();
                for (Class currentInter : interfaces)
                    if (currentInter.getSimpleName().equals("Animal"))
                        counter++;


                //Find default construct
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor currentConstructor : constructors)
                    if (currentConstructor.getParameterCount() == 0)
                        counter++;

                if (counter == 2) {
                    try {
                        Animal animal = (Animal) clazz.newInstance();
                        animals.add(animal);
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return animals;
    }

    public static class ClassFromPath extends ClassLoader {
        public Class<?> load(Path path, String packageName) {
            try {
                String className = packageName + "." + path.getFileName().toString().replace(".class", "");
                byte[] mass = Files.readAllBytes(path);
                return defineClass(className, mass, 0, mass.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
}
