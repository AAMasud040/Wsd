import java.util.Scanner;

class BankManagementSystem {

    private static void bankOperations(Scanner scanner){

    }
    
    private static void atmOperations(Scanner scanner){

    }

    public static void startBankManagementSystem() {
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
                    bankOperations(scanner);
                    break;
                case 2:
                    atmOperations(scanner);
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
