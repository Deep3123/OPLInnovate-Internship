package Prac_21_Jan.pra_8;

import java.util.ArrayList;
import java.util.Scanner;

interface A {
    void compare(ArrayList<String> arr);
}

public class p9 {
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
            int mx = array.get(0).length();
            int mn = array.get(0).length();

            String s1 = null, s2 = null;

            for (String s : array) {
                if (mx <= s.length()) {
                    mx = s.length();
                    s1 = s;
                }

                if (mn >= s.length()) {
                    mn = s.length();
                    s2 = s;
                }
            }

            System.out.println("Longest string: " + s1 + "  ||  size of that string: " + mx);
            System.out.println("Smallest string: " + s2 + "  ||  size of that string: " + mn);
        };

        a.compare(arr);
    }
}
