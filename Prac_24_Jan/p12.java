package Prac_24_Jan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p12 {
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
        System.out.print("Maximum number from list of numbers: ");
        System.out.println(arr.stream().max((a, b) -> a.compareTo(b)).get());

        System.out.print("Minimum number from list of numbers: ");
        System.out.println(arr.stream().min((a, b) -> a.compareTo(b)).get());

        System.out.print("Sum of numbers: ");
        System.out.println(arr.stream().reduce(0, (num1, num2) -> num1 + num2));

        System.out.print("Average of numbers: ");
        double sum = arr.stream().reduce(0, (num1, num2) -> num1 + num2);
        System.out.println(sum / arr.size());
    }
}