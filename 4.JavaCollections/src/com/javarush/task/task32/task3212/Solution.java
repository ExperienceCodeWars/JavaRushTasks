package com.javarush.task.task32.task3212;

import com.javarush.task.task32.task3212.service.Service;

import javax.naming.NamingException;

import static com.javarush.task.task32.task3212.ServiceLocator.getService;

/* 
Service Locator
*/

public class Solution {
    public static void main(String[] args){
        Service service = getService("EJBService");
        service.execute();
        System.out.println();
        service = getService("JMSService");
        service.execute();
        System.out.println();
        service = getService("EJBService");
        service.execute();
        System.out.println();
        service = getService("JMSService");
        service.execute();

    }

}
