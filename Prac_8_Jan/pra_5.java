interface Shape {
    public void getArea();
}

class Rectangle implements Shape {

    int length;
    int width;

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void getArea() {
        System.out.println("Area of Rectangle is:- " + length * width);
    }
}

class Circle implements Shape {

    int r;

    Circle(int r) {
        this.r = r;
    }

    @Override
    public void getArea() {
        System.out.println("Area of circle is:- " + (Math.PI * r * r));
    }
}

class Triangle implements Shape {

    int a, b, c, h;

    Triangle(int a, int b, int c, int h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    public void getArea() {
        System.out.println("Area of triangle is:- " + ((h * b) / 2));
    }
}

public class pra_5 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 4);
        Circle c = new Circle(5);
        Triangle t = new Triangle(2, 3, 5, 4);

        r.getArea();

        c.getArea();

        t.getArea();
    }

}
