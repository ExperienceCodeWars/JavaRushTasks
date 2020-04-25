package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = Paths.get(args[0]).getFileName().toString();
        String newFileName = "\new" + fileName;
        ZipEntry zipEntry;
        Map <String,ByteArrayOutputStream> filesInArchive = new HashMap<>();
        ZipInputStream zis = new ZipInputStream(new FileInputStream(args[1]));
        while((zipEntry=zis.getNextEntry())!=null){
            if(zipEntry.getName().endsWith(fileName)){
                newFileName = zipEntry.getName();
            }else{
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int lenght = 0;
                byte [] buff = new byte[1024];
                while((lenght=zis.read(buff))!=-1){
                    baos.write(buff,0,lenght);
                }
            filesInArchive.put(zipEntry.getName(),baos);
            }
        }
        zis.close();
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[1]));
        zipOut.putNextEntry(new ZipEntry(newFileName));
        Files.copy(Paths.get(args[0]),zipOut);
        for (Map.Entry<String, ByteArrayOutputStream> pair : filesInArchive.entrySet()) {
            zipOut.putNextEntry(new ZipEntry(pair.getKey()));
            pair.getValue().writeTo(zipOut);
        }
        zipOut.close();
    }
}
