package Prac_16_Jan;

import java.util.HashMap;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map1 = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of HashMap:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of HashMap:");

        int i = 0;

        while (i < n) {
            int ele = sc.nextInt();
            map1.put(i, ele);
            i++;
        }  

        System.out.println("Hash map-1: "+map1);
        HashMap<Integer, Integer> map2 = new HashMap<>(map1);
        System.out.println("Hash map-2: "+map2);
    }
}
