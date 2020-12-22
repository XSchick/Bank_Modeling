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
        bank1.removeAccount(2);

        testBankBalance(bank1, 0);
        testWithdrawEnoughMoney(bank1, 0);
        testWithdrawNotEnoughMoney(bank1, 0);

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

    public static boolean testBankBalance(Bank bank, int i) {
        bank.getAccount(i).deposit(10);
        System.out.println(bank.getAccount(i).getBalance());
        return true;
    }

    private static boolean testWithdrawEnoughMoney(Bank bank, int i) {
        bank.getAccount(i).withdraw(5);
        System.out.println(bank.getAccount(i).getBalance());
        return true;
    }

    private static boolean testWithdrawNotEnoughMoney(Bank bank, int i) {
        bank.getAccount(i).withdraw(11);
        System.out.println(bank.getAccount(i).getBalance());
        return true;
    }


}
