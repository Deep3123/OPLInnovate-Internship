package Prac_21_Jan.pra_2;

import java.util.Scanner;

@FunctionalInterface
interface A {
    void empty(String s);
}

public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of string: ");
        String s = sc.next();

        A a = (st) -> {
            if (st.isEmpty() == true)
                System.out.println("String is empty.");

            else
                System.out.println("String is not empty.");
        };

        a.empty(s);
    }
}
