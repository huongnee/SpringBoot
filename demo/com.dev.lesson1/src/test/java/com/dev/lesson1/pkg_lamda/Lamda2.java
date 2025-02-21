package com.dev.lesson1.pkg_lamda;
//lamda có 1 tham số
@FunctionalInterface
interface Sayhello2{
    public void sayhello(String name);
}
public class Lamda2 {
    public static void main(String[] args) {
        //Lamda sử dụng 1 tham số
        Sayhello2 say1 = (name) ->{
            System.out.println("hello"+name);
        };
        say1.sayhello("world");
        //ngắn gọn hơn
        Sayhello2 say2 = name ->{
            System.out.println("hello"+name);
        };
        say2.sayhello("world ne");

        //ngắn gọn hơn nữa
        Sayhello2 say3 = name -> System.out.println("hello"+name);
        say3.sayhello("world haha");
    }
}

