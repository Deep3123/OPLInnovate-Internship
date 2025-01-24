package Prac_21_Jan.pra_3;

import java.util.ArrayList;
import java.util.Scanner;

@FunctionalInterface
interface A {
    void caseConversion(ArrayList<String> arr);
}

public class p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements of Arraylist: ");
        int n = sc.nextInt();

        ArrayList<String> arr = new ArrayList<>();

        System.out.println("Enter the elements of Arraylist: ");
        while ((n--) > 0) {
            arr.add(sc.next());
        }

        A a = (array) -> {

            for (String st : array) {
                System.out.println("String in Uppercase: " + st.toUpperCase());
                System.out.println("String in Lowercase: " + st.toLowerCase());
            }
        };

        a.caseConversion(arr);
    }
}
