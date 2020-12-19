import edu.kit.informatik.*;

public class Bank {
    int bankCode; //maybe static?????
    Account[] accounts = new Account[8];

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
                this.accounts[i] = new Account(this.bankCode, i);
                return i;
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

    //public boolean containsAccount(int accountNumber) {}
//public boolean internalBankTransfer(int fromAccountNumber ,int toAccountNumber ,int amount) {}
    public int length() {
        return this.accounts.length;
    }
//public int size() {}
//public Account  getAccount(int index) {}


}
