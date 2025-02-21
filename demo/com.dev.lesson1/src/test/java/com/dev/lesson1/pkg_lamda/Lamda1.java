package com.dev.lesson1.pkg_lamda;


//lamda không có tham số
@FunctionalInterface
interface  SayHello{
    void sayHello();
}
public class Lamda1 {
    public static void main(String[] args) {
        SayHello sayHello = () -> {
            System.out.println("Hello World");
        };

        sayHello.sayHello();
    }
}
/*
tương đương vs cách viết
SayHello sayHello = new SayHello() {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
};
lamda
(parameters) -> { body }

 */