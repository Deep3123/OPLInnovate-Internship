package Prac_24_Jan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p6 {
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
        System.out.println("All the numbers in sorterd order:");
        arr.stream().sorted().forEach(System.out::println);
    }
}