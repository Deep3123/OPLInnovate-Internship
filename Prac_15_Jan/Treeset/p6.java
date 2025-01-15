package Prac_15_Jan.Treeset;

import java.util.Scanner;
import java.util.TreeSet;

public class p6 {
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

        System.out.println("Treeset before deleting given element: "+ts);

        System.out.println("Enter the value of element do you want to delete: ");
        int key=sc.nextInt();

        ts.remove(key);

        System.out.println("Treeset after deleting given element: "+ts);
    }
}
