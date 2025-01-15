package Prac_15_Jan.Treeset;

import java.util.Scanner;
import java.util.TreeSet;

public class p3 {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of TreeSet:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of TreeSet:");

        while ((n--) > 0) {
            int ele = sc.nextInt();
            ts.add(ele);
        }

        System.out.print("Elements less than 7 are: ");
        for (Integer it : ts) {
            if (it < 7) {
                System.out.print(it + " ");
            }
        }
    }
}
