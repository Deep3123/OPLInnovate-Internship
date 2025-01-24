package Prac_21_Jan.pra_4;

import java.util.ArrayList;
import java.util.Scanner;

@FunctionalInterface
interface A {
    void MinAndMax(ArrayList obj);
}

public class p4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements of Arraylist: ");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of Arraylist: ");
        while ((n--) > 0) {
            arr.add(sc.nextInt());
        }

        A a = (array) -> {
            int max_ele = (int) array.get(0);
            int min_ele = (int) array.get(0);

            for (int i = 0; i < array.size(); i++) {
                int temp = (int) array.get(i);
                max_ele = Math.max(max_ele, temp);
                min_ele = Math.min(min_ele, temp);
            }
            System.out.println("Maximum element of Arraylist: " + max_ele);
            System.out.println("Minimum element of Arraylist: " + min_ele);
        };

        a.MinAndMax(arr);
    }
}
