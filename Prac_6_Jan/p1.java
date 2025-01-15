import java.util.*;

class p1{
    public static void main(String[] args) 
    {
        int a,b;

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the value of a and b:-");

        a=sc.nextInt();
        b=sc.nextInt();

        System.out.println(a+" "+b);

        a=a+b;
        b=a-b;
        a=a-b;

        System.out.println(a+" "+b);
    }
}