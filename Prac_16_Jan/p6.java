package Prac_16_Jan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p6 {
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

        int max_key = 0;

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getKey() < key) {
                max_key = it.getKey();
            } else {
                break;
            }
        }

        if (max_key == 0)
            System.out.println("No greatest key found which is strictly less than given key.");

        else
            System.out.println(
                    "Greatest key of map which is strictly less than the given key: " + max_key
                            + " and value associated with this key: " + map.get(max_key));

    }
}
