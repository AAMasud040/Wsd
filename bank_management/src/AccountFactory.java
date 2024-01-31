class AccountFactory {
    public static Account createAccount(String type, String name, String number, double balance) {
        try {
            switch (type.toLowerCase()) {
                case "savings":
                    return new SavingsAccount(name, number, balance);
                case "current":
                    return new CurrentAccount(name, number, balance);
                case "salary":
                    return new SalaryAccount(name, number, balance);
                default:
                    throw new IllegalArgumentException("Invalid account type: " + type);
            }
        } catch (InsufficientInitialBalanceException e) {
            System.out.println("Failed to create account: " + e.getMessage());
            return null;
        }
    }
    
}