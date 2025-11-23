package ua.opnu;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // task 1
        System.out.println("=== MyOptional test ===");

        // 1. Порожній
        MyOptional<String> empty = new MyOptional<>();
        System.out.println(empty);                           // MyOptional[empty]
        System.out.println(empty.isPresent());               // false
        System.out.println(empty.orElse("немає"));           // немає

        // 2. Існуюче значення
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);                        // MyOptional[value=admin]
        System.out.println(username.get());                  // admin
        System.out.println(username.orElse("guest"));        // admin

        // 3. get() на пустому
        try {
            empty.get();
        } catch (Exception e) {
            System.out.println("Очікувано: " + e.getMessage());
        }

        // 4. Конструктор не приймає null
        try {
            MyOptional<String> x = new MyOptional<>(null);
        } catch (Exception e) {
            System.out.println("Правильно: " + e.getMessage());
        }

        // task 2

        System.out.println("\n=== BookData Comparable ===");

        BookData b1 = new BookData("Java", "John", 100, 400);
        BookData b2 = new BookData("Python", "Alice", 50, 180);
        BookData b3 = new BookData("C#", "Bob", 100, 400);

        BookData[] books = {b1, b2, b3};
        Arrays.sort(books);

        for (BookData b : books)
            System.out.println(b);

        // task 3

        System.out.println("\n=== Printer.printArray ===");

        Printer p = new Printer();
        Integer[] ints = {1,2,3};
        String[] texts = {"Hello", "World"};

        p.printArray(ints);
        p.printArray(texts);

        // task 4

        System.out.println("\n=== Utils.filter ===");

        Integer[] nums = {1,2,3,4,5,6,7,8,9};
        Integer[] evens = Utils.filter(nums, x -> x % 2 == 0);

        for (int i : evens)
            System.out.println(i);

        // task 5

        System.out.println("\n=== Utils.contains ===");

        String[] names = {"Max", "Ivan", "Dima"};
        System.out.println(Utils.contains(names, "Max")); // true
        System.out.println(Utils.contains(names, "Den")); // false

        // task 6
        System.out.println("\n=== GenericTwoTuple / GenericThreeTuple ===");

        GenericTwoTuple<String, Integer> car =
                new GenericTwoTuple<>("BMW", 500);

        GenericThreeTuple<String, Integer, Double> product =
                new GenericThreeTuple<>("Tesla", 1200, 9.99);

        System.out.println(car);
        System.out.println(product);
    }
}
