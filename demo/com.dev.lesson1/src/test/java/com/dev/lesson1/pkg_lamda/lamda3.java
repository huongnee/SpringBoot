package com.dev.lesson1.pkg_lamda;
//Có nhiều tham số
@FunctionalInterface
interface  Cal1{
    int add(int a, int b);
}
@FunctionalInterface
interface  Cal2{
    void add(int a, int b);
}

public class lamda3 {
    public static void main(String[] args) {
        Cal1 cal1 = (a, b) -> (a + b);
        System.out.println(cal1.add(10, 20));

        Cal1 cal2 = (a, b) -> (a + b);
        System.out.println(cal2.add(10, 23));

        Cal2 cal3 = (a,b) -> System.out.println(a+b);
        cal3.add(101, 20);

        Cal2 cal4 = (a,b) -> {
            int sum = a+b;
            System.out.println(a+" "+b+" "+sum);
        };
        cal4.add(101, 201);

    }
}
