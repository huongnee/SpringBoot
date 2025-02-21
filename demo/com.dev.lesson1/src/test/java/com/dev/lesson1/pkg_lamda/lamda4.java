package com.dev.lesson1.pkg_lamda;

import java.util.Arrays;
import java.util.List;
//lamda với vòng lặp
public class lamda4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("jv","php","c","a");
        list.forEach(item -> System.out.println(item));
        System.out.println("=========================");
        list.forEach(System.out::println);
    }
}
