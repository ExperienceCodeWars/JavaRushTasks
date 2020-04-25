package com.javarush.task.task19.task1918;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
 public static void main(String[] args) throws IOException {
        String targetTag = args[0];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        String html = "";
        for(String line = fileReader.readLine(); line != null; line = fileReader.readLine())
        {
            line = line.replaceAll("<" + targetTag + "$", "<" + targetTag + " ");
            html += line;
        }
        fileReader.close();

        
        List<String> list = new ArrayList<>();
        List<String> buff = new ArrayList<>();
        Stack<Tag> stack = new Stack<>();
        Pattern pattern = Pattern.compile("<(/?)" + targetTag + "(\\s|>)");
        Matcher matcher = pattern.matcher(html);
        int posOpenTag = 0;
        String currentTag = "";
        boolean wrapp = false;
        while (matcher.find()) {
            String name = html.substring(matcher.start(), matcher.end());
            if(name.equals("</" + currentTag.replaceAll("[<\\s>]","") + ">")) {
                if(wrapp)
                    buff.add(0, currentTag + html.substring(posOpenTag, matcher.start()) + name);
                else
                    list.add(currentTag + html.substring(posOpenTag, matcher.start()) + name);
                if(!stack.empty()){
                    Tag tag = stack.pop();
                    currentTag = tag.name;
                    posOpenTag = tag.position;
                }
            }
            else {
                if(buff.size() > 0) {
                    list.addAll(buff);
                    buff.clear();
                }
                stack.push(new Tag(currentTag, posOpenTag));
                if(stack.peek().name.equals(""))
                    wrapp = false;
                else
                    wrapp = true;

                currentTag = name;
                posOpenTag = matcher.end();
            }
        }
        if(buff.size() > 0) {
            list.addAll(buff);
            buff.clear();
        }

        for(String s : list)
            System.out.println(s);
    }

    static class Tag
    {
        String name;
        int position;

        Tag(final String name, final int position)
        {
            this.name = name;
            this.position = position;
        }
    }
}
