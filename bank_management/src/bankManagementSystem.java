import java.util.Scanner;

class BankManagementSystem {
    private Bank bank;

    public BankManagementSystem(Bank bank){
        this.bank = bank;
    }
    private Bank getBankInstance() {
        return this.bank;
    }

    private static void bankOperations(Scanner scanner, Bank bank) {
        while (true) {
            System.out.println("===================BANK=======================");
            System.out.println("\nBank Operations:");
            System.out.println("1) Create a new account");
            System.out.println("2) Display all accounts");
            System.out.println("3) Update account type");
            System.out.println("4) Delete an account");
            System.out.println("5) Deposit into your account");
            System.out.println("6) Withdraw from your account");
            System.out.println("7) Search for account");
            System.out.println("8) View Account Details");
            System.out.println("9) Exit\n");
            System.out.println("===============================================");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter account type (Savings/Current/Salary):");
                    String type = scanner.nextLine();
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter account number:");
                    String number = scanner.nextLine();
                    System.out.println("Enter initial balance:");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();
                    bank.createAccount(type, name, number, balance);
                    break;
                case 2:
                    bank.displayAllAccounts();
                    break;
                case 3:
                    System.out.println("Enter account number:");
                    String accNumber = scanner.nextLine();
                    System.out.println("Enter new account type (Savings/Current/Salary):");
                    String newType = scanner.nextLine();
                    bank.updateAccount(accNumber, newType);
                    break;
                case 4:
                    System.out.println("Enter account number:");
                    String delNumber = scanner.nextLine();
                    System.out.println("Enter account name:");
                    String delName = scanner.nextLine();
                    bank.deleteAccount(delNumber, delName, true);
                    break;
                case 5:
                    System.out.println("Enter account number:");
                    String depositNumber = scanner.nextLine();
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    bank.deposit(depositNumber, depositAmount);
                    break;
                case 6:
                    System.out.println("Enter account number:");
                    String withdrawNumber = scanner.nextLine();
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    bank.withdraw(withdrawNumber, withdrawAmount);
                    break;
                case 7:
                    System.out.println("Enter account number:");
                    String searchNumber = scanner.nextLine();
                    Account acc = bank.searchAccount(searchNumber);
                    if(acc ==null){
                        System.out.println("No Account Found");
                    }
                    else{
                        bank.accountInfo(acc.getNumber());
                    }
                    break;
                case 8:
                    System.out.println("Enter account number:");
                    String accInfoNumber = scanner.nextLine();
                    bank.accountInfo(accInfoNumber);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void atmOperations(Scanner scanner, Bank bank) {
        while (true) {
            System.out.println("===================ATM========================");
            System.out.println("\nATM Operations:");
            System.out.println("1) View Account Details");
            System.out.println("2) Deposit into your account");
            System.out.println("3) Withdraw from your account");
            System.out.println("4) Exit");
            System.out.println("==============================================");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter account number:");
                    String accNumber = scanner.nextLine();
                    bank.accountInfo(accNumber);
                    break;
                case 2:
                    System.out.println("Enter account number:");
                    String depositNumber = scanner.nextLine();
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    bank.deposit(depositNumber, depositAmount);
                    break;
                case 3:
                    System.out.println("Enter account number:");
                    String withdrawNumber = scanner.nextLine();
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    bank.withdraw(withdrawNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM operations...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void startBankManagementSystem() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1) Go to Bank");
            System.out.println("2) Go to ATM");
            System.out.println("3) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    bankOperations(scanner, getBankInstance());
                    break;
                case 2:
                    atmOperations(scanner, getBankInstance());
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
