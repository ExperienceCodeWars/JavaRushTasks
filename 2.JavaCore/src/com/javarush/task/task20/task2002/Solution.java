package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
         PrintWriter pw = new PrintWriter(outputStream);
            int size = users.size();
            pw.println(size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    pw.println(users.get(i).getFirstName());
                    pw.println(users.get(i).getLastName());
                    pw.println(users.get(i).getBirthDate().getTime());
                    pw.println(users.get(i).isMale() ? "true" : "false");
                    pw.println(users.get(i).getCountry());
                    pw.flush();
                }
            }
            pw.close();
        }
        public void load(InputStream inputStream) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            int size = Integer.parseInt(br.readLine());
            if (size > 0){
                for (int i = 0; i < size; i++) {
                    User user = new User();
                    user.setFirstName(br.readLine());
                    user.setLastName(br.readLine());
                    Date date = new Date();
                    date.setTime(Long.parseLong(br.readLine()));
                    user.setBirthDate(date);
                    user.setMale(br.readLine().equals("true"));
                    user.setCountry(User.Country.valueOf(br.readLine()));
                    this.users.add(user);
                }
            }
            br.close();
        }
        

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
