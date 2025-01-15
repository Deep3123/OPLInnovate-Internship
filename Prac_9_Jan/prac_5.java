import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class prac_5 {
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

        System.out.println("Before reversing the array.");
        System.out.println(arr);

        Collections.reverse(arr);

        System.out.println("After reversing the array.");
        System.out.println(arr);

        sc.close();
    }
}
