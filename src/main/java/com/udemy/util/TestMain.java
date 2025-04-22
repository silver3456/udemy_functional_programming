package com.udemy.util;

public class TestMain {

    public static void main(String[] args) {
        System.out.println(

                LinkUtil.getResponseCode("https://the-internet.herokuapp.com/broken_images")
        );
    }
}
