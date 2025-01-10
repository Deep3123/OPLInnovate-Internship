import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class pr7 {
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

        System.out.println("LinkedList: " + l1);

        ArrayList<Integer>arr=new ArrayList<>(l1);

        System.out.println("ArrayList: " + arr);

        sc.close();
    }
}