package Prac_16_Jan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p3 {
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

        int max_key = 0, min_key = 0;

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getKey() > max_key)
                max_key = it.getKey();

            if (min_key > it.getKey())
                min_key = it.getKey();
        }

        System.out
                .println("Greatest key of map: " + max_key + " and value associated with this key: " + map.get(max_key));
        System.out.println("Lowest key of map: " + min_key + " and value associated with this key: " + map.get(min_key));
    }
}
