import edu.kit.informatik.*;

public class Test {

    public static void main(String[] args) {
        //Creating two objects of class bank
        Bank bank1 = new Bank(123);
        Bank bank2 = new Bank(456);

        //Creating new Accounts
        bank1.createAccount();
        bank1.createAccount();
        bank1.createAccount();
        bank1.createAccount();
        bank1.createAccount();
        bank2.createAccount();
        bank2.createAccount();
        bank2.createAccount();
        //Removing account 2 of bank1
        bank1.removeAccount(3);
        //Show the length of array accounts
        Terminal.printLine(bank1.length());
        //Testing how many accounts have been created
        Terminal.printLine(bank1.size());
        //Tests the deposit to an account
        testBankBalance(bank1, 0);
        testBankBalance(bank1, 2);
        //Tests a withdraw (amount less than balance)
        testWithdrawEnoughMoney(bank1, 0, 5);
        //Tests a withdraw (amount higher than balance)
        testWithdrawNotEnoughMoney(bank1, 0);
        //Gives the accounts numbers of all accounts
        viewAllAccounts(bank1);
        //Tests money transfer from one account to another
        testTransfer(bank1, 0, 1, 7);



    }

    private static void viewAllAccounts(Bank bank) {
        for (int i = 0; i < bank.length(); i++) {
            if (bank.getAccount(i) != null) {
                Terminal.printLine(bank.getAccount(i).getAccountNumber());
            } else {
                Terminal.printLine("null");
            }

        }
    }

    private static void testBankBalance(Bank bank, int accountNumber) {
        bank.getAccount(bank.giveIndex(accountNumber)).deposit(10);
        Terminal.printLine(bank.accounts[bank.giveIndex(accountNumber)].getBalance());
    }

    private static void testTransfer(Bank bank, int fromAccount, int toAccount, int amount) {
        bank.internalBankTransfer(fromAccount, toAccount, amount);
        Terminal.printLine(bank.accounts[bank.giveIndex(fromAccount)].getBalance());
        Terminal.printLine(bank.accounts[bank.giveIndex(toAccount)].getBalance());
    }

    private static void testWithdrawEnoughMoney(Bank bank, int accountNumber, int amount) {
        bank.getAccount(bank.giveIndex(accountNumber)).withdraw(amount);
        Terminal.printLine(bank.getAccount(bank.giveIndex(accountNumber)).getBalance());
    }

    private static void testWithdrawNotEnoughMoney(Bank bank, int accountNumber) {
        bank.getAccount(bank.giveIndex(accountNumber)).withdraw(11);
        Terminal.printLine(bank.getAccount(bank.giveIndex(accountNumber)).getBalance());
    }
}
