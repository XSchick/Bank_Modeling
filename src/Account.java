import edu.kit.informatik.*;

public class Account {
    int accountNumber;
    int bankCode;
    int balance;

    /**
     * Initializing bank code and the account number
     * Initialize the account balance with 0
     *
     * @param theBankCode      bank code
     * @param theAccountNumber account number
     */
    public Account(int theBankCode, int theAccountNumber) {
        this.bankCode = theBankCode;
        this.accountNumber = theAccountNumber;
        this.balance = 0;
    }

    //public boolean withdraw(int amount) {}
    //public void deposit(int amount) {}
    //public boolean transfer(Account  account ,int amount)
}
