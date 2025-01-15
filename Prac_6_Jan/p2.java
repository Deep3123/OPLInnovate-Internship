
import java.util.*;

public class p2 {

    public static boolean solve(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        if (solve(n)) {
            System.out.println("Given number is prime."); 
        }else {
            System.out.println("Given number is not prime.");
        }
    }
}
