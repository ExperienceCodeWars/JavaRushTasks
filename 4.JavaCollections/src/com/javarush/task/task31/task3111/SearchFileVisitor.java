package com.javarush.task.task31.task3111;

import java.io.*;
import java.util.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    public void setPartOfName(String name) {
        this.partOfName = name;
    }

    public void setPartOfContent(String name) {
        this.partOfContent = name;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file);
        String contentStr = new String(Files.readAllBytes(file));
        boolean filter1 = true;
        boolean filter2 = true;
        if (partOfName != null && !file.getFileName().toString().contains(partOfName) ||
                partOfContent != null && !contentStr.contains(partOfContent))
            filter1 = false;
        if (Integer.valueOf(minSize) != 0 && !(content.length > minSize) ||
                Integer.valueOf(maxSize) != 0 && !(content.length < maxSize))
            filter2 = false;
        if (filter1 && filter2)
            getFoundFiles().add(file);
        return super.visitFile(file, attrs);
    }
}