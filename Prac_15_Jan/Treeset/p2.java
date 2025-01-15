package Prac_15_Jan.Treeset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class p2 {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of TreeSet:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of TreeSet:");

        while (n-- > 0) {
            int ele = sc.nextInt();
            ts.add(ele);
        }

        System.out.println("TreeSet before reversing: " + ts);

        List<Integer> list = new ArrayList<>(ts);
        Collections.reverse(list);

        System.out.println("TreeSet after reversing: " + list);

        sc.close();
    }
}