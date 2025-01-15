
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Employee {

    String name;
    double salary;
    LocalDate Hiredate;

    Employee(String name, double salary, String Hiredate) {
        this.name = name;
        this.salary = salary;
        this.Hiredate = LocalDate.parse(Hiredate, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    void display() {
        System.out.println(LocalDate.now().getYear()-Hiredate.getYear());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String Hiredate = sc.nextLine();
        double salary = sc.nextDouble();

        Employee e = new Employee(name, salary, Hiredate);

        e.display();
    }
}
