package Prac_15_Jan.Treeset;

import java.util.Scanner;
import java.util.TreeSet;

public class p1 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of TreeSet:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of TreeSet:");

        while ((n--) > 0) {
            String ele = sc.next();
            ts.add(ele);
        }

        System.out.println("TreeSet: " + ts);

        sc.close();
    }
}
