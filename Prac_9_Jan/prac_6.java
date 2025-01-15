import java.util.ArrayList;
import java.util.Scanner;

public class prac_6 {
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

        System.out.println("Enter the element do you want to search: ");
        int key = sc.nextInt();

        if (arr.contains(key))
            System.out.println("Given Element " + key + " is found at index " + arr.indexOf(key));

        else
            System.out.println("Element not found.");

        sc.close();
    }
}
