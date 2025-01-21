package Prac_21_Jan.pra_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

interface A {
    void arr_sort(ArrayList<String> arr);
}

public class p5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements of Arraylist: ");
        int n = sc.nextInt();

        ArrayList<String> arr = new ArrayList<>();

        System.out.println("Enter the elements of Arraylist: ");
        while ((n--) > 0) {
            arr.add(sc.next());
        }

        A a = (array) -> {
            Collections.sort(array);
            System.out.println("List of Strings after sorting: " + array);
        };

        a.arr_sort(arr);
    }
}
