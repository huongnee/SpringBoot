package com.dev.lesson1.pkg_default_method;

public interface Interface1 {
    default void method1() {
        System.out.println("Interface1.method1");
    }
}
