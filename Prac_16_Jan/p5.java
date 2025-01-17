package Prac_16_Jan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p5 {
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

        System.out.print("Enter the thresold key value: ");
        int key = sc.nextInt();

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getKey() < key)
                System.out.println(
                        "key of map: " + it.getKey() + " and value associated with this key: " + map.get(it.getKey()));
        }
    }
}
