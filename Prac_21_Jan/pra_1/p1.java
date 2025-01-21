package Prac_21_Jan.pra_1;

import java.util.Scanner;

@FunctionalInterface
interface A {
    int add(int x, int y);
}

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the values of x and y: ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        A a = (x, y) -> (x + y);
        System.out.println("Sum of m and n is: " + a.add(m, n));
    }
}
