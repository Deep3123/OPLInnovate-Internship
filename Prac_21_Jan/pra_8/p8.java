package Prac_21_Jan.pra_8;

import java.util.ArrayList;
import java.util.Scanner;

@FunctionalInterface
interface A {
    void avg_len(ArrayList<String> arr);
}

public class p8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements of Arraylist: ");
        int n = sc.nextInt();

        ArrayList<String> arr = new ArrayList<>();

        System.out.println("Enter the elements of Arraylist: ");
        while ((n--) > 0) {
            arr.add(sc.next());
        }

        A a = (array) -> {
            double sum = 0;

            for (String s : array)
                sum += s.length();

            System.out.println("Average length of string of list is: " + (sum / array.size()));
        };

        a.avg_len(arr);
    }
}
