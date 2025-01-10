import java.util.ArrayList;
import java.util.Scanner;

public class prac_3 {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements do you want to add in array-1: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of array-1: ");

        while ((n--) > 0) {
            int ele = sc.nextInt();
            arr1.add(ele);
        }

        System.out.println("How many elements do you want to add in array-2: ");
        int m = sc.nextInt();

        System.out.println("Enter the elements of array-2: ");

        while ((m--) > 0) {
            int ele = sc.nextInt();
            arr2.add(ele);
        }

        System.out.println("Before Merging the arrays");
        System.out.println("Array-1: " + arr1);
        System.out.println("Array-2 " + arr2);

        System.out.println();
        System.out.println("After merging the arrays.");

        arr1.addAll(arr2);

        System.out.println("Merged Array: " + arr1);

        sc.close();
    }
}