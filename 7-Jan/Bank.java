class BankAccount {

    int acc_no;
    String acc_holder_name;
    double balance;

    BankAccount(int acc_no, String acc_holder_name, double balance) {
        this.acc_no = acc_no;
        this.acc_holder_name = acc_holder_name;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Updated balance is:- " + balance);
        } else {
            System.out.println("Invalid Amount.");
        }
    }

    void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Invalid Amount.");
        } else if ((balance - amount > 0)) {
            balance -= amount;
            System.out.println("Updated balance is:- " + balance);
        } else {
            System.out.println("Balance is not sufficient.");
        }
    }

    void display() {
        System.out.println("Your Current balance is:- " + balance);
    }
}

class SavingsAccount extends BankAccount {

    int interest_rate, year;

    SavingsAccount(int acc_no, String acc_holder_name, double balance, int interest_rate, int year) {
        super(acc_no, acc_holder_name, balance);
        this.interest_rate = interest_rate;
        this.year = year;
    }

    void interest() {
        System.out.println("Interest is:- " + (balance * interest_rate * year) / 100);
    }
}

public class Bank {

    public static void main(String[] args) {

        SavingsAccount s = new SavingsAccount(1, "Raj", 10000, 5, 3);

        s.display();
        s.deposit(5000.00);
        s.withdraw(5000.00);
        s.interest();
    }
}
