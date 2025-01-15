package Prac_15_Jan.hashset;

import java.util.HashSet;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of set-1:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of set-1:");

        while ((n--) > 0) {
            int ele = sc.nextInt();
            s1.add(ele);
        }

        HashSet<Integer> s2 = new HashSet<>();

        System.out.println("Enter the size of set-2:");
        int m = sc.nextInt();

        System.out.println("Enter the elements of set-2:");

        while ((m--) > 0) {
            int ele = sc.nextInt();
            s2.add(ele);
        }

        HashSet<Integer> s3 = new HashSet<>();

        for (int it : s1) {
            if (s2.contains(it))
                s3.add(it);
        }

        System.out.println("Set-1: " + s1);
        System.out.println("Set-2: " + s2);
        System.out.println("Common elements in both: " + s3);
    }
}
