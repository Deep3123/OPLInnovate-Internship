package Prac_24_Jan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p4 {
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
        System.out.println("The first element of the list:");
        System.out.println(arr.stream().findFirst().get());
    }
}