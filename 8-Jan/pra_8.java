
class Shape_2 {

    public void perimeter() {
        System.out.println("You have to specify shape first.");
    }

    public void area() {
        System.out.println("You have to specify shape first.");
    }
}

class Rectangle_2 extends Shape_2 {

    int length;
    int width;

    Rectangle_2(int length, int width) {
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

class Circle_2 extends Shape_2 {

    int r;

    Circle_2(int r) {
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

class Triangle_2 extends Shape_2 {

    int a, b, c, h;

    Triangle_2(int a, int b, int c, int h) {
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

class pra_8 {

    public static void main(String[] args) {
        Rectangle_2 r = new Rectangle_2(5, 4);
        Circle_2 c = new Circle_2(5);
        Triangle_2 t = new Triangle_2(2, 3, 5, 4);

        r.area();
        r.perimeter();

        c.area();
        c.perimeter();

        t.area();
        t.perimeter();
    }
}