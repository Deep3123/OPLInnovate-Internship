package Prac_24_Jan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class p9 {
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements do you want to add in arraylist-1: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of arraylist-1: ");
        while ((n--) > 0) {
            int ele = sc.nextInt();
            arr1.add(ele);
        }

        List<Integer> arr2 = new ArrayList<>();

        System.out.println("How many elements do you want to add in arraylist-2: ");
        int m = sc.nextInt();

        System.out.println("Enter the elements of arraylist: ");
        while ((m--) > 0) {
            int ele = sc.nextInt();
            arr2.add(ele);
        }

        Stream<Integer> s1 = arr1.stream();
        Stream<Integer> s2 = arr2.stream();

        Stream<Integer> s3 = Stream.concat(s1, s2);

        System.out.println(s3.toList());
    }
}