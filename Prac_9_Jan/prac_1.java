// package 9-Jan;

import java.util.ArrayList;
import java.util.Scanner;

public class prac_1 {
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

        System.out.println(arr);

        System.out.println("Second element before replacing: " + arr.get(1));
        arr.remove(1);

        System.out.println("Enter the value of element do you want to add at second index: ");
        int m = sc.nextInt();

        arr.add(1, m);
        System.out.println("Second element after replacing: " + arr.get(1));

        System.out.println(arr);

        sc.close();
    }
}
