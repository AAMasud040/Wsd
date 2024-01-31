import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    //1. Create Account
    public void createAccount(String type, String name, String number, double balance) {
        Account account = AccountFactory.createAccount(type, name, number, balance);
        if (account != null) {
            accounts.add(account);
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Failed to create account. Invalid account type.");
        }
    }

    //2. Display All Account
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (Account account : accounts) {
                System.out.println("Name: " + account.getName());
                System.out.println("Account Type: " + account.getAccountType());
                System.out.println("Number: " + account.getNumber());
                System.out.println("Balance: " + account.getBalance());
                System.out.println("Creation Date: " + account.getCreationDate());
                System.out.println("-------------------------");
            }
        }
    }


    //3. Update Account Start
    public void updateAccountName(String number, String newName) {
        Account account = searchAccount(number);
        if (account != null) {
            account.updateName(newName);
            System.out.println("Account name updated successfully!");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void convertAccountType(String number, String newType) {
        Account account = searchAccount(number);
        if (account != null) {
            if (newType.equals("Savings") && !(account instanceof SavingsAccount)) {
                account = new SavingsAccount(account.getName(), account.getNumber(), account.getBalance());
                accounts.remove(account);
                accounts.add(account);
                System.out.println("Account type converted to Savings Account successfully!");
            } else if (newType.equals("Current") && !(account instanceof CurrentAccount)) {
                account = new CurrentAccount(account.getName(), account.getNumber(), account.getBalance());
                accounts.remove(account);
                accounts.add(account);
                System.out.println("Account type converted to Current Account successfully!");
            } else if (newType.equals("Salary") && !(account instanceof SalaryAccount)) {
                account = new SalaryAccount(account.getName(), account.getNumber(), account.getBalance());
                accounts.remove(account);
                accounts.add(account);
                System.out.println("Account type converted to Salary Account successfully!");
            } else {
                System.out.println("Account is already of the specified type.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
    //3. Update Account End

    //7. Search Account
    public Account searchAccount(String number) {
        for (Account account : accounts) {
            if (account.getNumber().equals(number)) {
                return account;
            }
        }
        return null;
    }

    //4. Delete Account
    public void deleteAccount(String number, String name) {
        for (Iterator<Account> iterator = accounts.iterator(); iterator.hasNext();) {
            Account account = iterator.next();
            if (account.getNumber().equals(number) && account.getName().equals(name)) {
                iterator.remove();
                System.out.println("Account deleted successfully!");
                return;
            }
        }
        System.out.println("Account not found or wrong number or wrong name.");
    }

    //5. Deposit
    public void deposit(String number, double amount) {
        Account account = searchAccount(number);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Account not found.");
        }
    }

    //6. Withdraw
    public void withdraw(String number, double amount) {
        Account account = searchAccount(number);
        if (account != null) {
            account.withdraw(amount);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Account not found.");
        }
    }
}
