import java.util.*;

class Rectangles {

    int length;
    int width;

    Rectangles(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void area() {
        System.out.println("Area of Rectangle is:- " + length * width);
    }

    public void perimeter() {
        System.out.println("Perimeter of Rectangle is:- " + (2 * (length + width)));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int length=sc.nextInt();    
        int width=sc.nextInt();

        Rectangles r = new Rectangles(length, width);

        r.area();
        r.perimeter();
        
        sc.close();
    }
}
