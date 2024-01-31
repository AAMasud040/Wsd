class ATM {
    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void accountDetails(String number){
        bank.accountInfo(number);
    }

    public void deposit(String number, double amount) {
        bank.deposit(number, amount);
    }

    public void withdraw(String number, double amount) {
        bank.withdraw(number, amount);
    }
}