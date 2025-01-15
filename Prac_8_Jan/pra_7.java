
import java.util.Scanner;

class Employee {
    String name;
    String role;
    String dept;

    public Employee(String name, String role, String dept) {
        this.name = name;
        this.role = role;
        this.dept = dept;
    }

    void calculate_salary() {
        System.out.println("Please specify your role.");
    }
}

class Manager extends Employee {
    // String name;
    // String role;
    // String dept;

    public Manager(String name, String role, String dept) {
        super(name, role, dept);
    }

    @Override
    void calculate_salary() {
        System.out.println("---------------------------------------------");
        String CTC = "20 LPA";
        String base_salary = "16 LPA";
        String variable_pay = "2 LPA";
        String bonus = "2 LPA";
        System.out.println("Your salary structure is: ");
        System.out.println("CTC: " + CTC);
        System.out.println("Base_salary: " + base_salary);
        System.out.println("Variable_pay: " + variable_pay);
        System.out.println("Bonus: " + bonus);
    }
}

class Programmer extends Employee {
    // String name;
    // String role;
    // String dept;

    public Programmer(String name, String role, String dept) {
        super(name, role, dept);
    }

    @Override
    void calculate_salary() {
        System.out.println("---------------------------------------------");
        String CTC = "12 LPA";
        String base_salary = "9 LPA";
        String variable_pay = "2 LPA";
        String bonus = "1 LPA";
        System.out.println("Your salary structure is: ");
        System.out.println("CTC: " + CTC);
        System.out.println("Base_salary: " + base_salary);
        System.out.println("Variable_pay: " + variable_pay);
        System.out.println("Bonus: " + bonus);
    }
}

public class pra_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your Name: ");
        String name = sc.next();

        System.out.println("Enter Your Role: ");
        String role = sc.next();

        System.out.println("Enter Your Department: ");
        String dept = sc.next();

        if (role.equals("Manager")) {
            Employee e = new Manager(name, role, dept);
            e.calculate_salary();
        }

        else if (role.equals("Programmer")) {
            Employee e = new Programmer(name, role, dept);
            e.calculate_salary();
        }
    }
}
