package Prac_24_Jan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p11 {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements do you want to add in arraylist: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of arraylist: ");
        while ((n--) > 0) {
            String ele = sc.next();
            arr.add(ele);
        }

        System.out.println();
        System.out.println("All distinct strings:");
        arr.stream().filter(p -> p != null || p.length() != 0).forEach(System.out::println);

    }
}