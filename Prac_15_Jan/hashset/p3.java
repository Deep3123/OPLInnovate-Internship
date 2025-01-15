import java.util.HashSet;
import java.util.Scanner;

public class p3 {
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of set-1:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of set-1:");

        while ((n--) > 0) {
            int ele = sc.nextInt();
            s1.add(ele);
        }

        System.out.println("Set-1: " + s1);

        HashSet<Integer> s2 = (HashSet<Integer>) s1.clone();

        System.out.println("Set-2: " + s2);
    }
}
