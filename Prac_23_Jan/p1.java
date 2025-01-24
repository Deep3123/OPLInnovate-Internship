package Prac_23_Jan;

@FunctionalInterface
interface I {
    void getData();
}

public class p1 {
    public static String getData() {
        for (int i = 0; i <= 10; i++)
            System.out.println("Child Method");
                    return "";
    }

    public static int getData1() {
        for (int i = 0; i <= 10; i++)
            System.out.println("Child Method");
                    return 0;
    }

    public static void main(String[] args) {
        I i = p1::getData;

        i.getData();
    }
}
