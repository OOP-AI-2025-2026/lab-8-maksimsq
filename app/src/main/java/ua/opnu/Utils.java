package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class Utils {

    // task 4
    public static <T> T[] filter(T[] input, Predicate<T> p) {

        Object[] temp = new Object[input.length];
        int idx = 0;

        for (T element : input) {
            if (p.test(element)) {
                temp[idx++] = element;
            }
        }

        // повертаємо масив такого ж типу, як і input
        return Arrays.copyOf(temp, idx, (Class<? extends T[]>) input.getClass());
    }


    // task 5
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T t : array) {
            if (t.compareTo(element) == 0)
                return true;
        }
        return false;
    }
}