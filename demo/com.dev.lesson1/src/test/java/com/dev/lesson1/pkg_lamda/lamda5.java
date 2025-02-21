package com.dev.lesson1.pkg_lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// Lambda với filter
class Book{
    int id;
    String name;
    float price;

    public Book(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
}
public class lamda5 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Jack Bauer", 9.95f));
        books.add(new Book(2, "Jack Bauer 2", 92.95f));
        books.add(new Book(3, "Jack Bauer 3", 91.95f));

        //Lọc sách có giá trị lớn hơn 90
        Stream<Book> filter_bookStream = books.stream().filter(b->b.price >90);
        filter_bookStream.forEach(System.out::println);
    }
}
