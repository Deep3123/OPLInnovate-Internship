import java.util.Scanner;

public class pra_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();

        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<n-i;j++)
            System.out.print(" ");

            for(int k=1;k<=i;k++)
            System.out.print("* ");

            System.out.println();
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            System.out.print(" ");

            for(int k=1;k<=n-i;k++)
            System.out.print("* ");

            System.out.println();
        }
    }
}
