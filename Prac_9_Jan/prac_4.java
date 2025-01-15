// package 9-Jan;

import java.util.ArrayList;
import java.util.Scanner;

public class prac_4 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements do you want to add: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of array: ");

        while ((n--) > 0) {
            int ele = sc.nextInt();
            arr.add(ele);
        }

        System.out.println("Before swapping the elements: ");
        System.out.println(arr);

        System.out.println("Enter the index of elements do you want to swap: ");

        int x = sc.nextInt();
        int y = sc.nextInt();

        if (arr.contains(arr.get(x)) && arr.contains(arr.get(y))) {
            int temp1 = arr.get(x);
            int temp2 = arr.get(y);

            arr.remove(x);
            arr.add(x, temp2);

            arr.remove(y);
            arr.add(y, temp1);
        }

        System.out.println("Before swapping the elements: ");
        System.out.println(arr);

        sc.close();
    }

}
