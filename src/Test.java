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
        bank2.createAccount();
        bank2.createAccount();
        bank2.createAccount();
        //Removing account 2 of bank1
        bank1.removeAccount(3);
        //Testing how many accounts have been created
        System.out.println(bank1.size());
        //Tests the deposit to an account
        testBankBalance(bank1, 0);
        //Tests a withdraw (amount less than balance)
        testWithdrawEnoughMoney(bank1, 0);
        //Tests a withdraw (amount higher than balance)
        testWithdrawNotEnoughMoney(bank1, 0);
        //Gives the accounts numbers of all accounts
        viewAllAccounts(bank1);


    }

    public static void viewAllAccounts(Bank bank) {
        for (int i = 0; i < bank.length(); i++) {
            if (bank.getAccount(i) != null) {
                System.out.println(bank.getAccount(i).getAccountNumber());
            } else {
                System.out.println("null");
            }

        }
    }

    public static void testBankBalance(Bank bank, int accountNumber) {
        bank.getAccount(bank.giveIndex(accountNumber)).deposit(10);
        System.out.println(bank.getAccount(accountNumber).getBalance());
    }

    private static void testTransfer(Bank bank, int fromAccount, int toAccount, int amount) {
        bank.internalBankTransfer(fromAccount, toAccount, amount);
        System.out.println();
    }

    private static void testWithdrawEnoughMoney(Bank bank, int accountNumber) {
        bank.getAccount(bank.giveIndex(accountNumber)).withdraw(5);
        System.out.println(bank.getAccount(bank.giveIndex(accountNumber)).getBalance());
    }

    private static void testWithdrawNotEnoughMoney(Bank bank, int accountNumber) {
        bank.getAccount(bank.giveIndex(accountNumber)).withdraw(11);
        System.out.println(bank.getAccount(bank.giveIndex(accountNumber)).getBalance());
    }


}
