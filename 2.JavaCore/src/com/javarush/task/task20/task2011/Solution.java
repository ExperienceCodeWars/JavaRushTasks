package com.javarush.task.task20.task2011;
import java.io.*;
/* 
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {
    
    public void writeExternal(ObjectOutput out){
        try{out.writeObject(address);
        out.writeInt(year);
        }catch(Exception e){
            
        }
    }
    public void readExternal(ObjectInput in){
        try{this.address = (String)in.readObject();
        this.year = in.readInt();
        }catch(Exception e){
            
        }
            
        }
        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }
    }

    public static void main(String[] args) {

    }
}
