import java.util.*;

public class Account implements accInt {
    private String name;
    private String number;
    private Date creationDate;
    private double balance;
    private String accoutType;

    public Account(String name, String number, double balance, String accountType) {
        this.name = name;
        this.number = number;
        this.creationDate = new Date();
        this.balance = balance;
        this.accoutType = accountType;
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
    public String getAccountType(){
        return this.accoutType;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }
}