package com.glen.BankSpringCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
        ApplicationContext factory=new ClassPathXmlApplicationContext("dependencies.xml");
        Bank bank = (Bank) factory.getBean("bank");
        System.out.println("Welcome to Bank");
        
    }
}
