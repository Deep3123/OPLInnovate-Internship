import java.util.*;

public class p7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println("which element do you want to find:- ");

        int key=sc.nextInt();

        int m=arr.length;

        int i=0,j=m-1;

        int ans=0,ind=0;

        while(i<=j)
        {
            int mid=(i+j)/2;

            if(arr[mid]==key)
            {
                ans=arr[mid];
                ind=mid;
                break;
            }

            else if(arr[mid]<key)
            i=mid+1;

            else if(arr[mid]>key)
            j=mid-1;
        }

        if(ans!=0 && ind!=0)
        System.out.println("Given element "+ans+" found at index: "+ind);

        else
        System.out.println("Element not found in array.");
    }
}
