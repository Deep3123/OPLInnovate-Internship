package Prac_16_Jan;

import java.util.HashMap;
import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of HashMap:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of HashMap:");

        int i = 0;

        while (i < n) {
            int ele = sc.nextInt();
            map.put(i, ele);
            i++;
        }

        System.out.println("HashMap: " + map);

        System.out.print("Enter the value which do you want to find out: ");
        int key = sc.nextInt();

        if (map.containsValue(key)) {
            System.out.println("Key-Value pair found for the given value.");
        } else
            System.out.println("Key-Value pair missing for the given value.");
    }
}
