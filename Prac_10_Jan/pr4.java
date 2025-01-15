import java.util.LinkedList;
import java.util.Scanner;

public class pr4 {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements do you want to add: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of array: ");

        while ((n--) > 0) {
            int ele = sc.nextInt();
            l.add(ele);
        }

        System.out.println("Before swapping the elements: ");
        System.out.println(l);

        System.out.println("Enter the index of elements do you want to swap: ");

        int x = sc.nextInt();
        int y = sc.nextInt();

        if (l.contains(l.get(x)) && l.contains(l.get(y))) {
            int temp1 = l.get(x);
            int temp2 = l.get(y);

            l.remove(x);
            l.add(x, temp2);

            l.remove(y);
            l.add(y, temp1);
        }

        System.out.println("Before swapping the elements: ");
        System.out.println(l);

        sc.close();
    }

}
