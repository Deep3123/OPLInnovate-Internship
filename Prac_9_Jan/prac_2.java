import java.util.ArrayList;
import java.util.Scanner;

public class prac_2 {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements do you want to add: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of array-1: ");
        while ((n--) > 0) {
            int ele = sc.nextInt();
            arr1.add(ele);
        }

        System.out.println("Array 1: " + arr1);

        ArrayList<Integer> arr2 = (ArrayList<Integer>) arr1.clone();

        System.out.println("Array 2: " + arr2);

        sc.close();
    }
}