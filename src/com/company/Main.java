package com.company;

import org.apache.commons.validator.routines.IntegerValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Calculator calculator = Calculator.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Для выхода введите exit");
        System.out.println("Введите строку типа a + b:");

        while(true) {
            String string = scanner.nextLine();
            if(string.equals("exit"))
                break;
            System.out.println(calculator.executeOperation(string));

        }

    }
}
