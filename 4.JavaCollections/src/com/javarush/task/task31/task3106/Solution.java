package com.javarush.task.task31.task3106;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;
/* 
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args)throws IOException {
        if(args.length < 2){return;}
        String resultFileName = args[0];
        int lengths = args.length-1;
        String [] fileParthName = new String[lengths];
        for(int i =0;i<lengths;i++){
            fileParthName[i]=args[i+1];
        }
        Arrays.sort(fileParthName);
        List <FileInputStream> array = new ArrayList<>();
        try{
        for(int i = 0; i<lengths;i++)
            array.add(new FileInputStream(fileParthName[i]));
        }catch (FileNotFoundException e) {
            for (FileInputStream inputStream : array) {
                inputStream.close();
            }
            throw e;
        }
        try(SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(array));
            ZipInputStream zis = new ZipInputStream(sis);
            FileOutputStream fos = new FileOutputStream(resultFileName)){
            byte [] buff = new byte[1024*1024];
            while(zis.getNextEntry()!=null){
                int count;
                while((count=zis.read(buff))!=-1){
                    fos.write(buff,0,count);
                }
            }
            }catch(IOException e){
                e.printStackTrace();
            }
    }
}
