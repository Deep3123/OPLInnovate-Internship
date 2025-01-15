// package 8-Jan;

import java.util.Scanner;

/* 
1. Write a Java program to Print Shape as mentioned below:
*
* *
* * *
* * * *
*/

public class pra_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

