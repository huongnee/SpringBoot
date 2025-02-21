package com.dev.lesson1.pkg_lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortLamda {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("jv","php","c","a");
        //sắp xếp
        Collections.sort(list,(String a,String b)->a.compareTo(b));

        for (String str : list) {
            System.out.println(str);
        }
    }
}
