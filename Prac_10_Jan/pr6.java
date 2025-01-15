import java.util.LinkedList;
import java.util.Scanner;

public class pr6 {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements do you want to add: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of array-1: ");
        while ((n--) > 0) {
            int ele = sc.nextInt();
            l1.add(ele);
        }

        System.out.println("LinkedList 1: " + l1);

        LinkedList<Integer> l2 = (LinkedList<Integer>) l1.clone();

        System.out.println("LinkedList 2: " + l2);

        sc.close();
    }
}