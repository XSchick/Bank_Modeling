import edu.kit.informatik.*;

public class Bank {
    private int bankCode;
    public Account[] accounts = new Account[8];
    private int nextAccountNumber = 0;

    /**
     * Constructor of class Bank
     *
     * @param theBankCode bank code
     */
    public Bank(int theBankCode) {
        this.bankCode = theBankCode;
    }

    /**
     * This method is looking for a free space in the array to create a new account.
     * If there is no further space, the array will be doubled
     *
     * @return the account number of the new created account
     */
    public int createAccount() {
        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i] == null) {
                this.accounts[i] = new Account(this.bankCode, nextAccountNumber);
                return nextAccountNumber++;
            }
            if (i == this.accounts.length - 1) {
                resize(this.accounts);
            }
        }
        return 0;
    }

    /**
     * Doubles the size of the array accounts
     *
     * @param oldAccount accounts[] with old length
     */
    private void resize(Account[] oldAccount) {
        Account[] tempArray = new Account[oldAccount.length * 2];
        System.arraycopy(oldAccount, 0, tempArray, 0, oldAccount.length);
        this.accounts = tempArray;
    }

    /**
     * @param accountNumber account number of the account to be deleted
     * @return true if the the account with the given account number exists, false if not
     */
    public boolean removeAccount(int accountNumber) {
        for (int i = 0; i < accounts.length; i++) {
            if (accountNumber == accounts[i].getAccountNumber()) {
                accounts[i] = null;
                /* If less than a quarter of the array is used and
                the array is bigger than it's default size, cut the array */
                if ((fillRate() < 0.25) && (this.accounts.length != 8)) {
                    cutArray();
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates how much of the array is used for accounts
     *
     * @return fill rate
     */
    private double fillRate() {
        double numberOfAccounts = 0;
        for (Account account : this.accounts) {
            if (account != null) {
                numberOfAccounts++;
            }
        }
        return numberOfAccounts / this.accounts.length;
    }

    /**
     * Halves a array
     */
    private void cutArray() {
        Account[] tempArray = new Account[this.accounts.length / 2];
        int k = 0;
        for (Account account : this.accounts) {
            if (account != null) {
                tempArray[k] = account;
                k++;
            }
        }
        this.accounts = tempArray;
    }

    /**
     * @param accountNumber account number
     * @return true if account exists, false if not
     */
    public boolean containsAccount(int accountNumber) {
        for (Account account : this.accounts) {
            if (accountNumber == account.getAccountNumber()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Transfer an amount from one account to another
     *
     * @param fromAccountNumber source account
     * @param toAccountNumber   target account
     * @param amount            amount
     * @return true if the two account numbers exist
     * and the balance of the source account wouldn't be negative after transfer
     */
    public boolean internalBankTransfer(int fromAccountNumber, int toAccountNumber, int amount) {
        if (containsAccount(fromAccountNumber) && containsAccount(toAccountNumber)) {
            return accounts[fromAccountNumber].transfer(accounts[toAccountNumber], amount);
        }
        return false;
    }

    /**
     * Giving the length of the account array
     *
     * @return length of account array
     */
    public int length() {
        return this.accounts.length;
    }

    /**
     * Adds up the number of accounts
     *
     * @return number of existing accounts
     */
    public int size() {
        int numberOfAccounts = 0;
        for (Account account : this.accounts) {
            if (account != null) {
                numberOfAccounts++;
            }
        }
        return numberOfAccounts;
    }

    /**
     * @param index account index
     * @return elements of the array
     */
    public Account getAccount(int index) {
        return this.accounts[index];
    }

    /**
     * Gives the array index to the given account
     *
     * @param accountNumber account number
     * @return index of array
     */
    public int giveIndex(int accountNumber) {
        int index = 0;
        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i].getAccountNumber() == accountNumber) {
                index = i;
                break;
            }
        }
        return index;
    }
}
