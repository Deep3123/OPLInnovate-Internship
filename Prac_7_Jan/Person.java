
import java.util.Scanner;

class Person {

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name:- " + name + " " + "Age:- " + age);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Person p1 = new Person("Raj", 20);

        p1.display();

        Person p2 = new Person("Ramesh", 21);

        p2.display();
    }
}
