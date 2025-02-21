package com.dev.lesson1.pkg_default_method;

public class MultiInheristance implements Shape, Interface1, Interface2 {
    @Override
    public void draw() {
        System.out.println("MultiInheritance");
    }

    @Override
    public void setColor(String color) {
        Shape.super.setColor(color);
        System.out.println("MultiInheritance setColor");
    }

    @Override
    public void method1() {
        Interface1.super.method1();
        System.out.println("MultiInheritance method1");
    }

    //test
    public static void main(String[] args) {
        MultiInheristance mi = new MultiInheristance();
        mi.method1();
        mi.setColor("red");
        mi.method2();
        mi.setColor("blue");

    }
}
