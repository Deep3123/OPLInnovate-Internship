package Prac_21_Jan.pra_6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

interface A {
    void remove_duplicate(ArrayList<Integer> arr);
}

public class p6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements of Arraylist: ");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of Arraylist: ");
        while ((n--) > 0) {
            arr.add(sc.nextInt());
        }

        A a = (array) -> {
            System.out.println("Array before removing duplicates: " + array);

            HashSet<Integer> st = new HashSet<>(array);

            System.out.println("Array after removing duplicates: " + st);

        };

        a.remove_duplicate(arr);
    }
}