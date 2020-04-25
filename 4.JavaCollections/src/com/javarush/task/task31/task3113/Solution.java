package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path>{
    int dirCount = 0;
    int filesCount = 0;
    long filesSize = 0;
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
          filesCount++;
          filesSize+=Files.size(file);
    return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            dirCount++;
    return FileVisitResult.CONTINUE;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathToFolder = reader.readLine();

        reader.close();
        Solution solution = new Solution();
        Path path = Paths.get(pathToFolder.toString());

        if (!Files.isDirectory(path)) {
            System.out.println(pathToFolder + " - не папка");
        } else {
            Files.walkFileTree(path,solution);
            solution.dirCount--;
            System.out.println("Всего папок - " + solution.dirCount);
            System.out.println("Всего файлов - " + solution.filesCount);
            System.out.println("Общий размер - " + solution.filesSize);
            
        }
        
    }


}