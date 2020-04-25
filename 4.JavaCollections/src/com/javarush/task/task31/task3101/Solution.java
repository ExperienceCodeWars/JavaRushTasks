package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/* 
Проход по дереву файлов
*/
public class Solution {
    public static void readRecursiveDirectory(File directory, List<File> listFiles) {
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                if (file.length() <= 50) {
                    listFiles.add(file);
                }
            } else {
                readRecursiveDirectory(file, listFiles);
            }
        }
    }
    public static void main(String[] args) {
    String path = args[0];
    String resultFileAbsolutePath = args[1];
    List <File> listFileless50byte = new ArrayList<>();
    
    File resultFile = new File(resultFileAbsolutePath);
    File renameFile = new File(resultFile.getParent() + "/allFilesContent.txt");
    
    if (FileUtils.isExist(resultFile)) {
        FileUtils.renameFile(resultFile, renameFile);
    }
    
    File directory = new File(path);
    readRecursiveDirectory(directory,listFileless50byte);
    
    Collections.sort(listFileless50byte,new Comparator <File>(){
        @Override
        public int compare(File o1,File o2){
            return o1.getName().compareTo(o2.getName());
        }
    });
    
    try(OutputStream os = new BufferedOutputStream(new FileOutputStream(renameFile))){
        Iterator<File> iter = listFileless50byte.iterator();
        
        while(iter.hasNext()){
            File file = iter.next();
            
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            while(is.available()>0){
                os.write(is.read());
            }
            os.write('\n');
        }
    }catch(IOException e){
     e.printStackTrace();   
    }
    }
}
