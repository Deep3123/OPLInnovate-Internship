import java.util.*;

public class p3 {
    // public static boolean solve(int n) {
    //     String s=Integer.toString(n);

    //     int m=s.length();

    //     int i=0,j=m-1;

    //     while(i<=j)
    //     {
    //         if(s.charAt(i)!=s.charAt(j))
    //         return false;

    //         i++;
    //         j--;
    //     }
    //     return true;
    // }

    public static boolean solve(int n) {
        int rev=0;
        
        int temp=n;

        while(temp>0)
        {
            rev=temp%10+rev*10;
            temp/=10;
        }
        
        if(rev==n)
        return true;

        else return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the value of n:-");
        
        int n=sc.nextInt();

        if(solve(n))
        System.out.println("Given number is palinedrome.");

        else
        System.out.println("Given number is not palinedrome.");
    }
}
