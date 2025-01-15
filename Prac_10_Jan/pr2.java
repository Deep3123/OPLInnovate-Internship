import java.util.LinkedList;
import java.util.Scanner;

public class pr2 {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements do you want to add in linkedlist:");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        while ((n--) > 0) {
            int ele = sc.nextInt();
            l.add(ele);
        }

        System.out.println("Linked List: " + l);

        System.out.println("Enter the value of index at which you want to add element:");
        int ind=sc.nextInt();

        System.out.println("Enter the value of element: ");
        int key = sc.nextInt();

        l.add(ind, key);

        System.out.println("Linked List after adding element at particular index: " + l);

        sc.close();
    }
}
