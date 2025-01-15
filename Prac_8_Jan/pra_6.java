
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Students {
    String name;
    int age;
    int enrollment_no;
    String branch;
    int sem;

    Students(String name, int age, int enrollment_no, String branch, int sem) {
        this.name = name;
        this.age = age;
        this.enrollment_no = enrollment_no;
        this.branch = branch;
        this.sem = sem;
    }

    void display() {
        System.out.println("Student Name is: "+name);
        System.out.println("Student Age is: "+age);
        System.out.println("Student Enrollment_No is: "+enrollment_no);
        System.out.println("Student Branch is: "+branch);
        System.out.println("Student Semester is: "+sem);
        System.out.println("---------------------------------------------");
    }
}

public class pra_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many students do you want to add in our database: ");
        int k = sc.nextInt();

        List<Students> student = new ArrayList<>();

        while (k > 0) {
            System.out.println("Enter Student's name: ");
            String name = sc.next();

            System.out.println("Enter Student's age: ");
            int age = sc.nextInt();

            System.out.println("Enter Student's Enrollment_No: ");
            int enrollment_no = sc.nextInt();

            System.out.println("Enter Student's Branch: ");
            String branch = sc.next();

            System.out.println("Enter Student's semester: ");
            int sem = sc.nextInt();

            Students s = new Students(name, age, enrollment_no, branch, sem);
            student.add(s);

            System.out.println("---------------------------------------------");

            k--;
        }

        for(Students st:student)
        st.display();
    }
}
