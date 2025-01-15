import java.util.*;

public class p6 {
    public static int factorial(int n)
    {
        if(n<=1)
        return n;

        return factorial(n-1)*n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        System.out.println(factorial(n));
    }
}
