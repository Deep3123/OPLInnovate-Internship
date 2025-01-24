package Prac_21_Jan.pra_7;

import java.util.Scanner;

@FunctionalInterface
interface A {
    void prime_num(int n);
}

public class p10 {
    public static boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        A a = (num) -> {
            System.out.println("List of prime number upto the n: ");

            for (int i = 1; i <= num; i++) {
                if (isPrime(i))
                    System.out.print(i + " ");
            }
        };

        a.prime_num(n);
    }
}
