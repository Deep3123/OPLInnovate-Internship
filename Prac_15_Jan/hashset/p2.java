import java.util.HashSet;
import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        HashSet<Integer> s = new HashSet<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of set-1:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of set-1:");

        while ((n--) > 0) {
            int ele = sc.nextInt();
            s.add(ele);
        }

        System.out.println("Set: " + s);

        Object arr[] = s.toArray();

        System.out.print("Array:");

        for (Object it : arr) {
            System.out.print(" "+it);
        }
    }
}
