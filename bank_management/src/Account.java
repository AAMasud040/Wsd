import java.util.*;

public class Account implements accountInterface {
    private String name;
    private String number;
    private Date creationDate;
    private double balance;
    private String accountType;
    
    public Account(String name, String number, double balance, String accountType) {
        this.name = name;
        this.number = number;
        this.creationDate = new Date();
        this.balance = balance;
        this.accountType = accountType;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public Date getCreationDate() {
        return this.creationDate;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public String getAccountType() {
        return this.accountType;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    @Override
    public void updateName(String newName){
        this.name = newName;
    }   
}


class SavingsAccount extends Account{
    public SavingsAccount(String name, String number, double balance) {
        super(name, number, balance, "Savings Account");
    }
}

class CurrentAccount extends Account{
    public CurrentAccount(String name, String number, double balance) {
        super(name, number, balance, "Current Account");
    }
}

class SalaryAccount extends Account{
    public SalaryAccount(String name, String number, double balance) {
        super(name, number, balance, "Salary Account");
    }
}


// ExceptionHandle Negative Balance, Withdrawl Amount, Creation 