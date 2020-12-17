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

    /**
     * The account balance is reduced by the amount transferred.
     * If the account balance would become negative due to the payout,
     * the payout will not take place and the method returns false
     *
     * @param amount payment amount
     * @return true if payment take place, false if the balance would be negative
     */
    public boolean withdraw(int amount) {
        if ((this.balance - amount) < 0) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    /**
     * This method pays money into the account
     * and increases the balance by the deposit amount
     *
     * @param amount deposit amount
     */
    public void deposit(int amount) {
        this.balance += amount;
    }

    /**
     * Transfers an amount from one bank account to another
     *
     * @param account Target account
     * @param amount  amount of transfer
     * @return false if the balance of the source account wouldn't´t go negative
     */
    public boolean transfer(Account account, int amount) {
        if (withdraw(amount)) {
            account.deposit(amount);
            return true;
        }
        return false;
    }

    /**
     * Returns the account number
     *
     * @return account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }
}
