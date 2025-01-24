package Prac_24_Jan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p3 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements do you want to add in arraylist: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of arraylist: ");
        while ((n--) > 0) {
            int ele = sc.nextInt();
            arr.add(ele);
        }
        System.out.println();
        System.out.println("Duplicate elements in a given integers list:");
        arr.stream().filter(p -> Collections.frequency(arr, p) > 1).collect(Collectors.toSet()).forEach(System.out::println);
    }
}