package com.example;

import java.util.Scanner;

public class app {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String jobLine = scanner.nextLine();

        System.out.println(Calc.getInstance(jobLine).calculate());
    }


}
