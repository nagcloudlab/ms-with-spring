package com.example;

/*
    computation ( part of process )
    io          ( external to process )
 */

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        //step-1:
        io();
        // step-2
        computation();
    }

    private static void io() {
        System.out.println(Thread.currentThread()+ "started io");
        Scanner scanner=new Scanner(System.in);
        String line= scanner.nextLine();
        System.out.println(line);
    }

    private static void computation() {
        System.out.println(Thread.currentThread()+ "started computation");
        while (true){}
    }
}
