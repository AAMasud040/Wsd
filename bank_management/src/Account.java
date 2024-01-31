import java.util.*;

public class Account implements accountInterface {
    private String name;
    private String number;
    private Date creationDate;
    private double balance;
    private String accountType;

    // Exception messages
    private static final String NEGATIVE_BALANCE_EXCEPTION = "Negative balance is not allowed.";
    private static final String INSUFFICIENT_FUNDS_EXCEPTION = "Insufficient funds for withdrawal.";
    private static final String INSUFFICIENT_INITIAL_BALANCE_EXCEPTION = "Account creation failed: Initial balance must be at least 500.";
    
    public Account(String name, String number, double balance, String accountType) throws InsufficientInitialBalanceException{
        if (balance < 500) {
            throw new InsufficientInitialBalanceException(INSUFFICIENT_INITIAL_BALANCE_EXCEPTION);
        }
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
    public void deposit(double amount) throws NegativeBalanceException{
        if (amount < 0) {
            throw new NegativeBalanceException(NEGATIVE_BALANCE_EXCEPTION);
        }
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) throws NegativeBalanceException, InsufficientFundsException {
        if (amount < 0) {
            throw new NegativeBalanceException(NEGATIVE_BALANCE_EXCEPTION);
        }
        if (amount > this.balance) {
            throw new InsufficientFundsException(INSUFFICIENT_FUNDS_EXCEPTION);
        }
        this.balance -= amount;
    }  
}


class SavingsAccount extends Account{
    public SavingsAccount(String name, String number, double balance) throws InsufficientInitialBalanceException{
        super(name, number, balance, "Savings Account");
    }
}

class CurrentAccount extends Account{
    public CurrentAccount(String name, String number, double balance) throws InsufficientInitialBalanceException{
        super(name, number, balance, "Current Account");
    }
}

class SalaryAccount extends Account{
    public SalaryAccount(String name, String number, double balance) throws InsufficientInitialBalanceException{
        super(name, number, balance, "Salary Account");
    }
}

class NegativeBalanceException extends Exception {
    public NegativeBalanceException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InsufficientInitialBalanceException extends Exception {
    public InsufficientInitialBalanceException(String message) {
        super(message);
    }
}

// ExceptionHandle Negative Balance, Withdrawl Amount, Creation 