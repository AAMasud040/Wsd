import java.util.ArrayList;
import java.util.List;

class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount(String type, String name, String number, double balance) {
        Account account = AccountFactory.createAccount(type, name, number, balance);
        if (account != null) {
            accounts.add(account);
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Failed to create account. Invalid account type.");
        }
    }

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
}
