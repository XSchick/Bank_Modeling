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


    public boolean removeAccount(int accountNumber) {
        for (int i = 0; i < accounts.length; i++){
            if (accountNumber == accounts[i].getAccountNumber()) {
                return true;
            }

        }
        return false;
    }
//public boolean containsAccount(int accountNumber) {}
//public boolean internalBankTransfer(int fromAccountNumber ,int toAccountNumber ,int amount) {}
    public int length() {
        return this.accounts.length;
    }
//public int size() {}
//public Account  getAccount(int index) {}


}
