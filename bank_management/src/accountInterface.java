import java.util.*;

public interface accountInterface {
    //getters for bms
    public String getName();
    public String getNumber();
    public Date getCreationDate();
    public double getBalance();
    public String getAccountType();

    //setters for bms
    public void deposit(double amount);
    public void withdraw(double amount);
    public void updateName(String newName);
}

