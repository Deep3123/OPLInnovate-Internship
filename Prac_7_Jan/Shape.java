
abstract class Shapes {

    abstract public void perimeter();

    abstract public void area();
}

class Rectangle extends Shapes {

    int length;
    int width;

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void area() {
        System.out.println("Area of Rectangle is:- " + length * width);
    }

    @Override
    public void perimeter() {
        System.out.println("Perimeter of Rectangle is:- " + (2 * (length + width)));
    }
}

class Circle extends Shapes {

    int r;

    Circle(int r) {
        this.r = r;
    }

    @Override
    public void perimeter() {
        System.out.println("Perimeter of circle is:- " + (2 * Math.PI * r));
    }

    @Override
    public void area() {
        System.out.println("Area of circle is:- " + (Math.PI * r * r));
    }
}

class Triangle extends Shapes {

    int a, b, c, h;

    Triangle(int a, int b, int c, int h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    public void perimeter() {
        System.out.println("Perimeter of triangle is:- " + (a + b + c));
    }

    @Override
    public void area() {
        System.out.println("Area of triangle is:- " + ((h * b) / 2));
    }
}

class Shape {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 4);
        Circle c = new Circle(5);
        Triangle t = new Triangle(2, 3, 5, 4);

        r.area();
        r.perimeter();

        c.area();
        c.perimeter();

        t.area();
        t.perimeter();
    }
}