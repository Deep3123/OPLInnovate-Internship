package Prac_21_Jan.pra_7;

import java.util.Scanner;

interface A {
    void fact(int n);
}

public class p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        A a = (num) -> {
            int fact = 1;

            for (int i = 1; i <= num; i++)
                fact *= i;

            System.out.println("Factorial of number is: " + fact);
        };

        a.fact(n);
    }
}
