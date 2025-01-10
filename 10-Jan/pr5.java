import java.util.LinkedList;
import java.util.Scanner;

public class pr5 {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements do you want to add in LinkedList-1: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of LinkedList-1: ");

        while ((n--) > 0) {
            int ele = sc.nextInt();
            l1.add(ele);
        }

        System.out.println("How many elements do you want to add in LinkedList-2: ");
        int m = sc.nextInt();

        System.out.println("Enter the elements of LinkedList-2: ");

        while ((m--) > 0) {
            int ele = sc.nextInt();
            l2.add(ele);
        }

        System.out.println("Before Merging the LinkedLists");
        System.out.println("LinkedList-1: " + l1);
        System.out.println("LinkedList-2 " + l2);

        System.out.println();
        System.out.println("After merging the LinkedLists.");

        l1.addAll(l2);

        System.out.println("Merged LinkedList: " + l1);

        sc.close();
    }
}