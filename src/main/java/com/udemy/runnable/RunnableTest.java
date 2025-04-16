package com.udemy.runnable;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

public class RunnableTest {

    public static void main(String[] args) {

        // The purpose of this interface to perform anything

        Runnable r = () -> {
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            System.out.println("Hello world");
        };

        //a thread accepts Runnable
        new Thread(r).start();
        System.out.println("Run in thread");


    }
}
