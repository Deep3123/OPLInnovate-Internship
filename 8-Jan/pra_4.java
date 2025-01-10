
import java.util.ArrayList;
import java.util.List;

interface Account {
    public void deposit(double amount);

    public void withdraw(double amount);

    public void calculate_interest();

    public void balance();

    public void details();
}

class SavingsAccount_2 implements Account {
    int acc_no;
    String acc_holder_name;
    double balance;
    int interest_rate, year;

    SavingsAccount_2(int acc_no, String acc_holder_name, double balance, int interest_rate, int year) {
        this.acc_no = acc_no;
        this.acc_holder_name = acc_holder_name;
        this.balance = balance;
        this.interest_rate = interest_rate;
        this.year = year;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Updated balance is:- " + balance);
        } else {
            System.out.println("Invalid Amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Invalid Amount.");
        } else if ((balance - amount > 0)) {
            balance -= amount;
            System.out.println("Updated balance is:- " + balance);
        } else {
            System.out.println("Balance is not sufficient.");
        }
    }

    @Override
    public void calculate_interest() {
        System.out.println("Interest is:- " + (balance * interest_rate * year) / 100);
    }

    @Override
    public void balance() {
        System.out.println("Your Current balance is:- " + balance);
    }

    @Override
    public void details() {
        System.out.println("Account Number:- " + acc_no);
        System.out.println("Account Holder Name:- " + acc_holder_name);
    }
}

class CurrentAccount_2 implements Account {
    int acc_no;
    String acc_holder_name;
    double balance;

    CurrentAccount_2(int acc_no, String acc_holder_name, double balance) {
        this.acc_no = acc_no;
        this.acc_holder_name = acc_holder_name;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Updated balance is:- " + balance);
        } else {
            System.out.println("Invalid Amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Invalid Amount.");
        } else if ((balance - amount > 0)) {
            balance -= amount;
            System.out.println("Updated balance is:- " + balance);
        } else {
            System.out.println("Balance is not sufficient.");
        }
    }

    @Override
    public void calculate_interest() {
        System.out.println("You are using current account, so no interest will be credited.");
    }

    @Override
    public void balance() {
        System.out.println("Your Current balance is:- " + balance);
    }

    @Override
    public void details() {
        System.out.println("Account Number:- " + acc_no);
        System.out.println("Account Holder Name:- " + acc_holder_name);
    }
}

class Bank_2 {
    private List<Account> accounts;

    Bank_2() {
        accounts = new ArrayList<>();
    }

    void addAccount(Account account) {
        accounts.add(account);
        // System.out.println("Total numbers of accounts are:- "+accounts.size());
    }

    void displayAccount() {
        System.out.println("---------------------------------------------");
        for (Account account : accounts) {
            System.out.println("Account details are: ");
            account.details();
            System.out.println("---------------------------------------------");
        }
    }
}

public class pra_4 {
    public static void main(String[] args) {
        Bank_2 bank = new Bank_2();

        SavingsAccount_2 s = new SavingsAccount_2(1, "Raj", 10000, 5, 3);
        bank.addAccount(s);

        CurrentAccount_2 c = new CurrentAccount_2(2, "Jay", 20000);
        bank.addAccount(c);

        System.out.println("---------------------------------------------");
        s.balance();
        s.deposit(5000);
        s.withdraw(10000);
        s.calculate_interest();
        s.details();

        System.out.println("----------------------------------------------");
        c.balance();
        c.deposit(20000);
        c.withdraw(15000);
        c.calculate_interest();
        c.details();

        bank.displayAccount();
    }
}