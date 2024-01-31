import java.util.*;

public interface acc {
    //getters for bms
    public String getName();
    public String getNumber();
    public Date getCreationDate();
    public double getBalance();
    //setters for bms
    public void deposit(double amount);
    public void withdraw(double amount);
}