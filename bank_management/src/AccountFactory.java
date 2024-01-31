class AccountFactory {
    public static Account createAccount(String type, String name, String number, double balance) {
        switch (type.toLowerCase()) {
            case "Savings":
                return new SavingsAccount(name, number, balance);
            case "Current":
                return new CurrentAccount(name, number, balance);
            case "Salary":
                return new SalaryAccount(name, number, balance);
            default:
                throw new IllegalArgumentException("Invalid account type: " + type);
        }
    }
}