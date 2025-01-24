package Prac_24_Jan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p10 {
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
        System.out.println(
                "if duplicate elements present in a given integers list then it will print true otherwise false:");

        long count = arr.stream().filter(p -> Collections.frequency(arr, p) > 1).count();

        if (count > 1)
            System.out.println(true);

        else
            System.out.println(false);
    }
}