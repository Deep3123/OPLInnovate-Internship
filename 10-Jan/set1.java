
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class set1 {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of set:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of set:");

        while ((n--) > 0) {
            int ele = sc.nextInt();
            s.add(ele);
        }

        System.out.println("Set: " + s);

        Set<Integer> s2 = new HashSet<>(s);

        System.out.println("Set-2: " + s2);

        sc.close();
    }
}
