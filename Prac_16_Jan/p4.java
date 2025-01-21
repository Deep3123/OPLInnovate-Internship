package Prac_16_Jan;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return -o1.compareTo(o2);
    }
}

public class p4 {
    public static void main(String[] args) {
        MyComparator m = new MyComparator();

        TreeMap<Integer, Integer> map = new TreeMap<>(m);

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

        System.out.println("TreeMap after reversing the keys: " + map);
    }
}
