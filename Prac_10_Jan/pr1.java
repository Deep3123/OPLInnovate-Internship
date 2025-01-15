
import java.util.LinkedList;
import java.util.Scanner;

public class pr1 {
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

        System.out.println("Enter the position/index you want to iterate on: ");
        int pos = sc.nextInt();

        while (pos < l.size()) {
            System.out.print(l.get(pos++) + " ");
        }

        sc.close();
    }
}
